package my.project.armorer.s.shop.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Это, наверно, не надо.
    /*@OneToMany(mappedBy = "cart")
    private List<Product> products;*/

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    /*Лучше, наверно,
    * @ManyToOne
    * @JoinColumn(name = "product_price")
    * private Double productPrice;*/
    @Column(name = "price_per_item")
    private Double pricePerItem;

    @Column(name = "price")
    private Double price;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
