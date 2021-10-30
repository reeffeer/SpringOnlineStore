package com.reef.demo_store.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reef.demo_store.dto.OrderDto;
import com.reef.demo_store.entities.Order;
import com.reef.demo_store.entities.User;
import com.reef.demo_store.services.CartService;
import com.reef.demo_store.services.OrderService;
import com.reef.demo_store.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class OrderController {
    @Value("${spring.rabbitmq.send-queue: market.orders}")
    private String orderQueueName;

    private final OrderService orderService;
    private final UserService userService;
    private final CartService cartService;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrderFromCart(Principal principal, @RequestParam String address) throws JsonProcessingException {
        Order order = orderService.createFromUserCart(principal.getName(), address);
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        cartService.clearCart(user.getId());
        OrderDto orderDto = new OrderDto(order);
        rabbitTemplate.convertAndSend(orderQueueName, objectMapper.writeValueAsString(orderDto));
        return orderDto;
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDto(order);
    }

    @GetMapping
    public List<OrderDto> getCurrentUserOrders(Principal principal) {
        return orderService.findAllByOwner(principal.getName())
                .stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
