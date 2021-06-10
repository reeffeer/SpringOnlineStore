package my.project.armorer.s.shop.controllers;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.services.FirebaseMessagingService;
import my.project.armorer.s.shop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
@Slf4j
@RequestMapping("/api/v1/firetest")
@AllArgsConstructor
public class PushNotifyTestController {
    private final FirebaseMessagingService firebaseMessagingService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> testPush(@RequestParam String email, @RequestParam String title, @RequestParam String body) throws FirebaseMessagingException {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!"));

        firebaseMessagingService.sendPrivateDeviceNotification(user, title, body);
        return ResponseEntity.ok("Push sent");
    }
}
