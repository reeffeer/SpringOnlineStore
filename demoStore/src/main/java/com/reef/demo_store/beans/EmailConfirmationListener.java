package com.reef.demo_store.beans;

import com.reef.demo_store.entities.User;
import com.reef.demo_store.services.EmailVerificationTokenService;
import com.reef.demo_store.util.OnEmailVerificationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailConfirmationListener implements ApplicationListener<OnEmailVerificationCompleteEvent> {
    private EmailVerificationTokenService emailVerificationTokenService;
    private  JavaMailSender javaMailSender;

    @Value("${email.verify.url: path-to-my-app/register/confirm?token=}")
    private String confirmationUrl;

    @Value("${spring.mail.username: reef}")
    private String emailUsername;

    @Value("${spring.mail.password: 123}")
    private String emailPassword;

    @Autowired
    public void setEmailVerificationTokenService(EmailVerificationTokenService emailVerificationTokenService) {
        this.emailVerificationTokenService = emailVerificationTokenService;
    }
    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void onApplicationEvent(OnEmailVerificationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnEmailVerificationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        emailVerificationTokenService.createToken(user, token);

        String recipientAddress = user.getEmail();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setTo(recipientAddress);
        message.setSubject("Confirm your email");
        message.setText("Verify your email on demo-store \r\n" + confirmationUrl + token);
        javaMailSender.send(message);
    }
}
