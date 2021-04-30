package my.project.armorer.s.shop.controllers;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.dto.CartDto;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.services.CartService;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    @PostMapping("/")
    public UUID createCart() throws NotFoundException {
        Cart cart = cartService.save(new Cart());
        return cart.getId();
    }

    @GetMapping("exists/{cartId}")
    public boolean cartExist(@PathVariable UUID cartId) {
        return cartService.cartExists(cartId);
    }

    @GetMapping("/{cartId}")
    public CartDto getCart(@PathVariable UUID cartId) throws NotFoundException {
        return new CartDto(cartService.findById(cartId).orElseThrow(() -> new NotFoundException("Not found")));
    }

    
}
