package my.project.armorer.s.shop.dto;

import lombok.Data;
import my.project.armorer.s.shop.entities.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

}
