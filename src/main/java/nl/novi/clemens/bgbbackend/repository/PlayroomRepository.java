package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.Playroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayroomRepository extends JpaRepository<Playroom, Long> {

    Playroom findByPlayroomid(long id);

}