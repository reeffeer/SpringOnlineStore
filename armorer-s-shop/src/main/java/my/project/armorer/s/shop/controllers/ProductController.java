package my.project.armorer.s.shop.controllers;


import lombok.AllArgsConstructor;
import my.project.armorer.s.shop.dto.ProductDto;
import my.project.armorer.s.shop.entities.Product;
import my.project.armorer.s.shop.services.ProductService;
import my.project.armorer.s.shop.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    /*@GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }*/

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {  //todo exceptions
        return productService.findProductDtoById(id).orElseThrow(() ->
                new RuntimeException("Not found."));
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }

        return productService.findAll(ProductSpecifications.build(params), page, 4);
    }
}
