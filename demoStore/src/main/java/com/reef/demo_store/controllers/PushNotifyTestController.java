package com.reef.demo_store.controllers;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.reef.demo_store.entities.User;
import com.reef.demo_store.services.FirebaseMessagingService;
import com.reef.demo_store.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/api/v1/firetest")
@AllArgsConstructor
@CrossOrigin("*")
public class PushNotifyTestController {
    private final FirebaseMessagingService firebaseMessagingService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> testPush(@RequestParam String email, @RequestParam String title, @RequestParam String body) throws FirebaseMessagingException {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User is not found"));
        firebaseMessagingService.sendPrivateDeviceNotification(user, title, body);
        return ResponseEntity.ok("Push sent");
    }
}
