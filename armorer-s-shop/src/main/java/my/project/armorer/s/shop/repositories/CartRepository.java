package my.project.armorer.s.shop.repositories;

import my.project.armorer.s.shop.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
   // Optional<Cart> findById(Long id);
}
