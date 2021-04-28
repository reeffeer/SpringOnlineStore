package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.OrderItem;

@Data
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private Double pricePerProduct;
    private Double price;
    private Integer quantity;


    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProduct().getId();
        this.productTitle = orderItem.getTitle();
        this.pricePerProduct = orderItem.getPricePerProduct();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }
}
