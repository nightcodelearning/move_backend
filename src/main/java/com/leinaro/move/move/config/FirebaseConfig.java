package com.leinaro.move.move.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final Logger logger= LoggerFactory.getLogger(FirebaseConfig.class);

    @Value("${firebase.config.path}")
    private String configPath;

    @PostConstruct
    public void init() throws IOException {

        ClassPathResource resource = new ClassPathResource(configPath);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                .build();

        FirebaseApp.initializeApp(options);
        logger.info("app Name : {}", FirebaseApp.getInstance().getName());
    }
}
