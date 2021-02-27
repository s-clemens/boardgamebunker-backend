package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.enums.ERole;
import nl.novi.clemens.bgbbackend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}