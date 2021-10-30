package com.reef.demo_store.specifications;

import com.reef.demo_store.entities.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

public class ProductSpecifications {
    private static Specification<Product> priceGreatOrEqualsThan(int minPrice) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    private static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    private static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey("min_price") && !params.getFirst("min_price").isBlank()) {
            spec = spec.and(ProductSpecifications
                    .priceGreatOrEqualsThan(Integer.parseInt(params.getFirst("min_price"))));
        }

        if (params.containsKey("max_price") && !params.getFirst("max_price").isBlank()) {
            spec = spec.and(ProductSpecifications
            .priceLesserOrEqualsThan(Integer.parseInt(params.getFirst("max_price"))));
        }

        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(ProductSpecifications.titleLike(params.getFirst("title")));
        }
        return spec;
    }
}
