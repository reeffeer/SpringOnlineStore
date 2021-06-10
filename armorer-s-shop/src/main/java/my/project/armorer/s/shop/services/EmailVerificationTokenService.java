package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.EmailVerificationToken;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.repositories.EmailVerificationTokenRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
@AllArgsConstructor
public class EmailVerificationTokenService {
    private static final int EXPIRATION = 60 * 24;
    private EmailVerificationTokenRepository repository;

    public void createToken(User user, String token) {
        EmailVerificationToken myToken = new EmailVerificationToken();
        myToken.setToken(token);
        myToken.setUser(user);
        myToken.setExpiryDate(calculateExpiration());
        repository.save(myToken);
    }

    private Date calculateExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, EXPIRATION);
        return new Date(calendar.getTime().getTime());
    }

    public EmailVerificationToken getTokenFromDB(String token) {
        return repository.findByToken(token);
    }
}
