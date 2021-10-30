package com.reef.demo_store.services;

import com.google.firebase.messaging.*;
import com.reef.demo_store.entities.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;

    public void sendPrivateDeviceNotification(User user,String messageTitle, String messageBody) throws FirebaseMessagingException {
        if (user.getFirebaseToken() == null || user.getFirebaseToken().isEmpty()) {
            log.warn("User has no firebase token");
            throw new RuntimeException("Token is not available");
        }

        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(messageTitle)
                        .setBody(messageBody)
                        .build())
                .setToken(user.getFirebaseToken())
                .build();

        String response = firebaseMessaging.send(message);
        log.info("Successfully sent message: {}", response);
    }

    public void sendBroadcastNotification(List<User> users, String messageTitle, String messageBody) throws FirebaseMessagingException {
        List<String> tokens = new ArrayList<>();
        users.forEach(u -> {
            if (u.getFirebaseToken() != null && !u.getFirebaseToken().isEmpty()) {
                tokens.add(u.getFirebaseToken());
            }
        });

        MulticastMessage message = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle(messageTitle)
                        .setBody(messageBody)
                        .build())
                .addAllTokens(tokens)
                .build();

        BatchResponse response = firebaseMessaging.sendMulticast(message);
        log.info("{} messages were sent successfully. {} unsuccessfully.", response.getSuccessCount(), response.getFailureCount());
    }
}
