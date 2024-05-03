package icine.cinema.dashboard.infrastructure.repository;

import icine.cinema.dashboard.infrastructure.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
