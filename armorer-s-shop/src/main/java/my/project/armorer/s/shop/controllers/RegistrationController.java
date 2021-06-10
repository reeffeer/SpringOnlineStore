package my.project.armorer.s.shop.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.armorer.s.shop.dto.UserRegisterDto;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.services.UserRegisterService;
import my.project.armorer.s.shop.util.OnEmailVerificationCompleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    private final UserRegisterService registerService;
    private final ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegisterDto dto) {
        User registered = registerService.createNewUser(dto);

        eventPublisher.publishEvent(new OnEmailVerificationCompleteEvent(registered));
        return ResponseEntity.ok("{\"msg\": \"Please verify your email\"}");
    }

    @GetMapping("/confirm")
    public ResponseEntity<?> confirmRegistration(@RequestParam String token) {
        registerService.validateEmail(token);
        return ResponseEntity.ok("{\"msg\": \"Verify success. Please log in..\"}");
    }
}
