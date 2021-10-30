package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    //    Optional<Cart> findByOwnerId(Long id);
}
