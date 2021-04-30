package my.project.armorer.s.shop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_price")
    private BigDecimal product_price;

    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CartItem(Product product) {
        this.product = product;
        this.title = product.getTitle();
        this.quantity = 1;
        this.product_price = product.getPrice();
        this.price = product_price;
    }

    public void increment(int quantity) {
        this.quantity += quantity;
        price = this.product_price.multiply(new BigDecimal(this.quantity));
    }
}
