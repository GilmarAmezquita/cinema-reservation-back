package icine.cinema.dashboard.infrastructure.repository;

import icine.cinema.dashboard.infrastructure.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
