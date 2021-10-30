package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.EmailVerificationToken;
import com.reef.demo_store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {
    EmailVerificationToken findByToken(String token);
    EmailVerificationToken findByUser(User user);
}
