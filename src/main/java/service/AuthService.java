package service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String firebaseToken) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(firebaseToken);
        String uid = decodedToken.getUid();
        String email = decodedToken.getEmail();

        Optional<User> existingUser = userRepository.findByEmail(email);
        if(existingUser.isPresent()) {
            return existingUser.get();
        }
        User newUser = new User();
        newUser.setUid(Integer.parseInt(uid));
        newUser.setEmail(email);
        newUser.setDisplayName(decodedToken.getName());

        return userRepository.save(newUser);
    }
}
