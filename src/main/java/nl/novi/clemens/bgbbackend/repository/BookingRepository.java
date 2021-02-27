package nl.novi.clemens.bgbbackend.repository;

import nl.novi.clemens.bgbbackend.domain.Booking;
import nl.novi.clemens.bgbbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Boolean existsByName(String name);
    Booking findByName(String name);
    Booking findByBookingid(Long id);
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByBookingdate(LocalDate date);
}
