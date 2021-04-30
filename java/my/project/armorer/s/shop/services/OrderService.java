package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Order;
import my.project.armorer.s.shop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private UserService userService;
    private OrderRepository orderRepository;

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
    public List<Order> findAllByOwner(String username) {
            return orderRepository.findAllByOwnerUsername(username);
    }
}
