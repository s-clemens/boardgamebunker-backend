package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.Boardgame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardgameRepository extends JpaRepository<Boardgame, Long> {
    Boardgame findByBoardgameid(Long id);
}