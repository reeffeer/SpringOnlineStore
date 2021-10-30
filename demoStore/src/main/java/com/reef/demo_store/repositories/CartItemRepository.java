package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findAllByCartId(Long id);
    Optional<CartItem> findCartItemByProductId(Long productId);
}
