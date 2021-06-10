package my.project.armorer.s.shop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RedisHash("cart_item")
public class CartItem {

    @Id
    private Long id;

    @Indexed
    private Cart cart;

    private Product product;

    private String title;

    private Integer quantity;

    private BigDecimal productPrice;

    private BigDecimal price;

    public CartItem(Product product) {
        this.product = product;
        this.title = product.getTitle();
        this.quantity = 1;
        this.productPrice = product.getPrice();
        this.price = productPrice;
    }

//    public void increment(int quantity) {
//        this.quantity += quantity;
//        price = this.pricePerProduct.multiply(new BigDecimal(this.quantity));
//    }
//
//    public void decrement(int quantity) {
//        this.quantity -= quantity;
//        price = this.pricePerProduct.multiply(new BigDecimal(this.quantity));
//    }
}
