package my.project.armorer.s.shop.repositories;

import my.project.armorer.s.shop.entities.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
//    @Query("select p from products p where ")
//    Product findAllByCategories();
//    Product getAllByPriceGreaterThanPrice;
}
