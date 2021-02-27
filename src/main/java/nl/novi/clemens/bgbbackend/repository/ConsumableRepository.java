package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumableRepository extends JpaRepository<Consumable, Long> {
    Consumable findByConsumableid(Long id);
}
