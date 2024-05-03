package icine.cinema.dashboard.infrastructure.repository;

import icine.cinema.dashboard.infrastructure.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
