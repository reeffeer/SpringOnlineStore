package my.project.armorer.s.shop.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.Column;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "carts")
public class Cart {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    private UUID id;


    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public void add(CartItem cartItem) {
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
    }
}
