package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.Cart;

@Data
public class CartDto {
    private Long productId;
    private String productTitle;
    private Double pricePerItem; //Тогда private Double productPrice;
    private Double price;
    private Integer quantity;

    public CartDto(Cart cart) {
        this.productId = cart.getProduct().getId();
        this.productTitle = cart.getProduct().getTitle();
        this.pricePerItem = cart.getPricePerItem(); //Возможно, лучше cart.getProduct().getPrice();
        this.price = cart.getPrice();
        this.quantity = cart.getQuantity();
    }
}
