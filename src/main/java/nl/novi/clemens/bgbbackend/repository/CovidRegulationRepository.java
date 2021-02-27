package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.CovidRegulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidRegulationRepository extends JpaRepository<CovidRegulation, Long> {

    CovidRegulation findByCovidregulationid(long id);

}