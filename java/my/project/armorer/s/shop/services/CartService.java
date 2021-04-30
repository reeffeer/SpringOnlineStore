package my.project.armorer.s.shop.services;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.entities.Product;
import my.project.armorer.s.shop.repositories.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;

    public Cart addToCart(UUID id, Long productId) throws NotFoundException {
        Cart cart = findById(id).orElseThrow(() -> new NotFoundException("Cart is not found"));
        return cart;
    }

    public Optional<Cart> findById(UUID id) {
        return cartRepository.findById(id);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Transactional
    public boolean cartExists(UUID cartId) {
        return cartRepository.existsById(cartId);
    }
}
