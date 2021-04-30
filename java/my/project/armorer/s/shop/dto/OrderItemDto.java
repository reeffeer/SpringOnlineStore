package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.OrderItem;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private BigDecimal productPrice;
    private BigDecimal price;
    private Integer quantity;


    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProduct().getId();
        this.productTitle = orderItem.getTitle();
        this.productPrice = orderItem.getProductPrice();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }
}
