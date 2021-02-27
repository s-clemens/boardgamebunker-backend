package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import nl.novi.clemens.bgbbackend.domain.enums.EBoardgameType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardgameTypeRepository extends JpaRepository<BoardgameType, Long> {
    BoardgameType findByName(EBoardgameType name);
}