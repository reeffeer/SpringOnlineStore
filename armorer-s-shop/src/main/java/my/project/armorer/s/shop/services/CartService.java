package my.project.armorer.s.shop.services;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.entities.CartItem;
import my.project.armorer.s.shop.entities.Product;
import my.project.armorer.s.shop.repositories.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;

    public Cart updateCart(Cart cart) {
        recalculateCart(cart);
        return cartRepository.save(cart);
    }

    public Cart findCartByCustomerId(Long id) {
        Cart cart = cartRepository.findById(id).orElse(new Cart(id));
        return  cart;
    }

    public Cart clearCart(Long id) {
        Cart cart = findCartByCustomerId(id);
        cart.getCartItems().clear();
        return cartRepository.save(cart);
    }

    private void recalculateCart(Cart cart) {
        cart.setTotalPrice(new BigDecimal("0.0"));
        for (CartItem cartItem : cart.getCartItems()) {
            cart.setTotalPrice(cart.getTotalPrice().add(cartItem.getPrice()));
        }
    }
}
