package my.project.armorer.s.shop.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.armorer.s.shop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/users")
@Api(value = "Set of endpoints for profiles")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping(value = "/set_firebase_token")
    @ApiOperation("Sets firebase token to user")
    public ResponseEntity<?> setFirebaseToken(@RequestParam String token, Principal principal) {
        userService.setFirebaseToken(principal.getName(), token);
        return new ResponseEntity<>("Token updated", HttpStatus.OK);
    }
}
