package my.project.armorer.s.shop.repositories;

import my.project.armorer.s.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findOneByEmail(String email);

    boolean existsByEmail(String email);
}
