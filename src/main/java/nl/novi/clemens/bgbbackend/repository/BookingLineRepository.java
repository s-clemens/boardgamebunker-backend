package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.BookingLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingLineRepository extends JpaRepository<BookingLine, Long> {
}