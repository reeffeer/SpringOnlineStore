package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
 //   @Query("select p from products p where ")
//    Product findAllByCategories();
//    Product getAllByPriceGreaterThanAndPri
}
