package my.project.armorer.s.shop.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Column;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@RedisHash("carts")
public class Cart {
   @Id
   private Long id;
    //в качестве id корзины используем id юзера, поскольку одна корзина принадлежит одному юзеру
    @Id
    private Long customerId;

    //@Indexed
    private List<CartItem> cartItems;

    private BigDecimal totalPrice;

    public Cart(Long customerId) {
        this.customerId = customerId;
    }

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    /*public void add(CartItem cartItem) {
        for (CartItem item : cartItems) {
           if (item.getProduct().getId().equals(cartItem.getProduct().getId())) {
               item.increment(cartItem.getQuantity());
               calculate();
               return;
           }
        }
        cartItems.add(cartItem);
        cartItem.setCart(this);
        calculate();
    }

    public void calculate() {
        totalPrice = new BigDecimal(0.0);
        for (CartItem cartItem : cartItems) {
            totalPrice.add(cartItem.getPrice());
        }
    }

    public void clear() {
        cartItems.clear();
        calculate();
    }*/
}
