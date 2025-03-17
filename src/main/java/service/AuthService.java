package service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import config.JwtUtil;
import entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import payload.AuthResponse;
import payload.GoogleLoginRequest;
import payload.LoginRequest;
import repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse login(LoginRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                throw new RuntimeException("This account was created using Google Sign-In. Please log in with Google.");
            }

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getEmail());
                return new AuthResponse(token);
            }

            throw new RuntimeException("Invalid credentials");
        }
        throw new RuntimeException("User not found");
    }

    public AuthResponse googleLogin(GoogleLoginRequest request) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(request.getGoogleToken());
            String email = decodedToken.getEmail();

            Optional<User> existingUser = userRepository.findByEmail(email);
            if (existingUser.isEmpty()) {
                User newUser = new User();
                newUser.setUid(UUID.randomUUID());
                newUser.setEmail(email);
                userRepository.save(newUser);
            }

            String token = jwtUtil.generateToken(email);
            return new AuthResponse(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid Google token");
        }
    }
}
