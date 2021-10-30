package com.reef.demo_store.dto;

import com.reef.demo_store.entities.OrderItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private BigDecimal pricePerProduct;
    private BigDecimal price;
    private Integer quantity;

    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.productTitle = orderItem.getTitle();
        this.pricePerProduct = orderItem.getPriceProduct();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }
}
