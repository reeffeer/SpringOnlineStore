package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.User;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findOneByEmail(String email);
    boolean existsByEmail(String email);
}
