package icine.cinema.dashboard.infrastructure.repository;

import icine.cinema.dashboard.infrastructure.model.SeatReserved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
}
