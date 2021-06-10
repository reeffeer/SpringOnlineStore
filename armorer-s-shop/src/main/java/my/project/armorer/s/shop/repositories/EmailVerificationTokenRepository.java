package my.project.armorer.s.shop.repositories;

import my.project.armorer.s.shop.entities.EmailVerificationToken;
import my.project.armorer.s.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {
    EmailVerificationToken findByToken(String token);
    EmailVerificationToken findByUser(User user);
}
