package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.ConsumableType;
import nl.novi.clemens.bgbbackend.domain.enums.EConsumableType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumableTypeRepository extends JpaRepository<ConsumableType, Long> {
    ConsumableType findByName(EConsumableType name);
}