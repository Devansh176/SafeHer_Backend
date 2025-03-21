package config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase-service-account.json");
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(
                GoogleCredentials.fromStream(serviceAccount)
        ).build();

        FirebaseApp app = FirebaseApp.getInstance();
        System.out.println("Firebase App Name: " + app.getName());

        return FirebaseApp.initializeApp(options);

    }
}
