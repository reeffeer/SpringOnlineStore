package com.reef.demo_store.controllers;

import com.reef.demo_store.dto.CartDto;
import com.reef.demo_store.entities.Cart;
import com.reef.demo_store.entities.User;
import com.reef.demo_store.services.CartService;
import com.reef.demo_store.services.ProductService;
import com.reef.demo_store.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j
public class CartController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public CartDto getCurrentCart(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        Cart cart = cartService.findCartByOwnerId(user.getId());
        log.info("{}", cart);
        return new CartDto(cart);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProductToCart(Principal principal,
                                              @RequestParam(name = "product_id") Long productId) {
       User user = userService.findByUsername(principal.getName())
               .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       cartService.addToCart(user.getId(), productId);
       return ResponseEntity.ok("");
    }

    @PostMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping
    public CartDto clearCart(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        Cart cart = cartService.clearCart(user.getId());
        return new CartDto(cart);
    }
}
