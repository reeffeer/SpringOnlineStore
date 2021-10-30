package com.reef.demo_store.dto;

import com.reef.demo_store.entities.CartItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class CartItemDto {
    private Long productId;
    private String title;
    private Integer quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;

    public CartItemDto(CartItem cartItem) {
        this.productId = cartItem.getProductId();
        this.title = cartItem.getTitle();
        this.quantity = cartItem.getQuantity();
        this.pricePerProduct = cartItem.getPricePerProduct();
        this.price = cartItem.getPrice();
    }
}
