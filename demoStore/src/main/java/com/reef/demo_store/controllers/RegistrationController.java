package com.reef.demo_store.controllers;

import com.reef.demo_store.dto.UserRegisterDto;
import com.reef.demo_store.entities.User;
import com.reef.demo_store.services.UserRegisterService;
import com.reef.demo_store.util.OnEmailVerificationCompleteEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/register")
@AllArgsConstructor
@CrossOrigin("*")
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
        return ResponseEntity.ok("{\"msg\": \"Verification is success. Please log in.\"}");
    }
}
