package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardgameTypeRepository extends JpaRepository<BoardgameType, Long> {
}
