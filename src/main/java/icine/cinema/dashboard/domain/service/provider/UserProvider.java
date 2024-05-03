package icine.cinema.dashboard.domain.service.provider;

import icine.cinema.dashboard.infrastructure.model.User;

public interface UserProvider {
    User findByEmail(String email);
    User save(User user);
    User update(User user);
}
