package service;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.stereotype.Service;

@Service
public class FirebaseConnectionTest {

    public void testFirebaseConnection() {
        try {
            String testUid = FirebaseAuth.getInstance().createCustomToken("test_user");
            System.out.println("✅ Firebase is connected! Test token generated: " + testUid);
        } catch (Exception e) {
            System.err.println("❌ Firebase connection failed: " + e.getMessage());
        }
    }
}
