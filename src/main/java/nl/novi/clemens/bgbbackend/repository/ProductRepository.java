package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean findByName(String name);
    Boolean existsByName(String name);
    Product findByProductid(long id);
}
