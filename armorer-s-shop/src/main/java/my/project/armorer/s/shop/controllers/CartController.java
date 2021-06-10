package my.project.armorer.s.shop.controllers;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.entities.CartItem;
import my.project.armorer.s.shop.entities.Product;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.services.CartService;
import my.project.armorer.s.shop.services.ProductService;
import my.project.armorer.s.shop.services.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public Cart getCurrentCart(Principal principal) {
//        if (principal == null) {
//            return cartService.getCartForUser(null, null);
//        }
        User user = userService.findByUsername(principal.getName()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        return cartService.findCartByCustomerId(user.getId());
    }

    @PostMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping
    public Cart clearCart(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        return cartService.clearCart(user.getId());
    }

    @GetMapping("/mock")
    public Cart getMockCart(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        Cart cart = new Cart();
        List<CartItem> items = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            items.add(new CartItem(product));
        }
        cart.setCustomerId(1L);
        cart.setCartItems(items);
        return cart;
    }
}
