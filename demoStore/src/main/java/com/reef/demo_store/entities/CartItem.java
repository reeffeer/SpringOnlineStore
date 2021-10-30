package com.reef.demo_store.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RedisHash("cart_item")
public class CartItem {

    @Id
    private Long id;

    @Indexed
    private Cart cart;
    private Long productId;
    private String title;
    private Integer quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;

    public CartItem(Product product) {
        this.productId = product.getId();
        this.title = product.getTitle();
        this.quantity = 1;
        this.pricePerProduct = product.getPrice();
        this.price = pricePerProduct;
    }
}
