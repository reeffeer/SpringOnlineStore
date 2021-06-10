package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.entities.CartItem;
import my.project.armorer.s.shop.repositories.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartItemService {
    private CartItemRepository cartItemRepository;
    private  ProductService productService;

    public void addToCart(Cart cart, Long productId) {
        CartItem cartItem = new CartItem(productService.findProductById(productId).orElseThrow());
        cartItemRepository.save(cartItem);
    }

    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    public CartItem saveOrUpdate(CartItem item) {
        return cartItemRepository.save(item);
    }

//    public void recalculateItem(CartItem item) {
//        item.set
//    }
}
