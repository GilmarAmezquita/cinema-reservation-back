package icine.cinema.dashboard.infrastructure.repository;

import icine.cinema.dashboard.infrastructure.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
