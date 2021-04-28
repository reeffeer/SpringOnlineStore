package my.project.armorer.s.shop.services;

import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.entities.Product;
import my.project.armorer.s.shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }
}
