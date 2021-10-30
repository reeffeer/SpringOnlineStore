package com.reef.demo_store.controllers;

import com.reef.demo_store.dto.ProductDto;
import com.reef.demo_store.entities.Product;
import com.reef.demo_store.exceptions.ResourceNotFoundException;
import com.reef.demo_store.services.ProductService;
import com.reef.demo_store.specifications.ProductSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findProductDtoById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping
    public Page<ProductDto> findAllProducts(@RequestParam MultiValueMap<String, String> params,
                                            @RequestParam(name = "p", defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }

        return productService.findAll(ProductSpecifications.build(params), page, 4);
    }
}
