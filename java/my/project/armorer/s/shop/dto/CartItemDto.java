package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.CartItem;

import java.math.BigDecimal;

@Data
public class CartItemDto {

    private Long id;
    private String title;
    private Integer quantity;
    private BigDecimal product_price;
    private BigDecimal price;

    public CartItemDto(CartItem cartItem) {
        this.id = cartItem.getProduct().getId();
        this.title = cartItem.getProduct().getTitle();
        this.quantity = cartItem.getQuantity();
        this.product_price = cartItem.getProduct_price();
        this.price = cartItem.getPrice();
    }
}
