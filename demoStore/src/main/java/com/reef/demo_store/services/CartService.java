package com.reef.demo_store.services;

import com.reef.demo_store.entities.Cart;
import com.reef.demo_store.entities.CartItem;
import com.reef.demo_store.exceptions.ResourceNotFoundException;
import com.reef.demo_store.repositories.CartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Slf4j
public class CartService {
    private CartRepository cartRepository;
    private ProductService productService;

    public Cart updateCart(Cart cart) {
        recalculateCart(cart);
        return cartRepository.save(cart);
    }

    private void recalculateCart(Cart cart) {
        cart.setPrice(new BigDecimal("0.0"));
        for (CartItem cartItem: cart.getCartItems()) {
            cart.setPrice(cart.getPrice().add(cartItem.getPrice()));
        }
    }

    public Cart findCartByOwnerId(Long id) {
        Cart cart = cartRepository.findById(id).orElse(new Cart(id));
        return cartRepository.save(cart);
    }

    public Cart clearCart(Long id) {
        Cart cart = findCartByOwnerId(id);
        cart.getCartItems().clear();
        return cartRepository.save(cart);
    }

    public void addToCart(Long userId, Long productId) {
        log.debug("Adding to cart");
        Cart cart = findCartByOwnerId(userId);
        for(CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getProductId().equals(productId)) {
                log.debug("Found existing item {}", cartItem.getTitle());
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                recalculateCart(cart);
                cartRepository.save(cart);
                log.debug("Added item to cart {}:{}", cartItem.getTitle(), cartItem.getQuantity());
                return;
            }
        }
        CartItem item = new CartItem(productService.findProductById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Not found")));
        cart.getCartItems().add(item);
        recalculateCart(cart);
        cartRepository.save(cart);
    }
}
