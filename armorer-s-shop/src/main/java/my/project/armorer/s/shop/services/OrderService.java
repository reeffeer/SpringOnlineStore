package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Cart;
import my.project.armorer.s.shop.entities.Order;
import my.project.armorer.s.shop.entities.User;
import my.project.armorer.s.shop.exceptions.ResourceNotFoundException;
import my.project.armorer.s.shop.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private UserService userService;
    private CartService cartService;
    private OrderRepository orderRepository;

    @Transactional
    public Order createFromUserCart(String username, String address) {
        User user = userService.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Cart cart = cartService.findCartByCustomerId(user.getId());
        if (cart.getCartItems().isEmpty()) {throw new RuntimeException("Cart is empty");}
        Order order = new Order(cart, address, user);
        order = orderRepository.save(order);
        return  order;
    }
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
    public List<Order> findAllByOwner(String username) {
            return orderRepository.findAllByOwnerUsername(username);
    }
}
