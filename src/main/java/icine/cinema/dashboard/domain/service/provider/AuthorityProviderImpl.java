package icine.cinema.dashboard.domain.service.provider;

import icine.cinema.dashboard.infrastructure.model.Authority;
import icine.cinema.dashboard.infrastructure.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityProviderImpl implements AuthorityProvider {
    private final AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityUser() {
        return authorityRepository.findByName("ROLE_USER");
    }
}
