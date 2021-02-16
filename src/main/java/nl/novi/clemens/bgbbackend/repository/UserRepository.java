package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * De JpaRepositories die jullie al kennen. Hier wordt gebruik gemaakt van Query Creation. Op basis van de methode naam
 * weten Spring en JPA welke query op de database uitgevoerd moet worden.
 * Hier kan meer informatie over gevonden worden:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
