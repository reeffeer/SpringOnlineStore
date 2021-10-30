package com.reef.demo_store.services;

import com.reef.demo_store.entities.Cart;
import com.reef.demo_store.entities.CartItem;
import com.reef.demo_store.exceptions.ResourceNotFoundException;
import com.reef.demo_store.repositories.CartItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CartItemService {
    private CartItemRepository cartItemRepository;
    private ProductService productService;

    public CartItem addToCart(Cart cart, Long productId) {
        CartItem cartItem = new CartItem(productService.findProductById(productId).orElseThrow(() ->
                new ResourceNotFoundException("No this product")));
        cartItem.setCart(cart);
        log.info("Add item to cart {}:{}", cartItem.getTitle(), cartItem.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }
    public Optional<CartItem> findByProductId(Long id) {
        return cartItemRepository.findCartItemByProductId(id);
    }

    public CartItem saveOrUpdate(CartItem item) {
        return cartItemRepository.save(item);
    }
}
