package my.project.armorer.s.shop.controllers;


import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.dto.ProductDto;
import my.project.armorer.s.shop.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;
    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }
}
