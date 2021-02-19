package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CovidRegulationRepository extends JpaRepository<CovidRegulation, Long> {


    CovidRegulation findByCovidregulationid(long id);

}
