package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.dto.UserRegisterDto;
import my.project.armorer.s.shop.entities.EmailVerificationToken;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.exceptions.BadDataRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class UserRegisterService {
    private final UserService userService;
    private final EmailVerificationTokenService emailVerificationTokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User createNewUser(UserRegisterDto dto) {
        if (userService.existsByEmail(dto.getEmail()))
            throw new RuntimeException("User with this email already exists!");

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(List.of(roleService.findRoleByName("ROLE_USER")));
        user.setStatus(0);
        return userService.save(user);
    }

    //todo переделать на дто, возвращающее значение
    public User validateEmail(String token) {
        EmailVerificationToken verificationToken = emailVerificationTokenService.getTokenFromDB(token);

        if (verificationToken == null) throw new BadDataRequestException("Invalid token!");
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if (verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0)
            throw new BadDataRequestException("Token is expired!");
        user.setStatus(1);
        return userService.save(user);
    }
}
