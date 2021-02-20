package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.domain.ProductType;
import nl.novi.clemens.bgbbackend.domain.enums.EProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findByName(EProductType name);
}
