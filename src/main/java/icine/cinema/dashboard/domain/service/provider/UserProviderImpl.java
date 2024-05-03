package icine.cinema.dashboard.domain.service.provider;

import icine.cinema.dashboard.domain.exception.error.IcineException;
import icine.cinema.dashboard.domain.exception.util.IcineExceptionBuilder;
import icine.cinema.dashboard.infrastructure.model.User;
import icine.cinema.dashboard.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserProviderImpl implements UserProvider {
    public static String USER_NOT_FOUND = "User not found.";
    public static String USER_ALREADY_EXISTS = "User already exists.";
    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                IcineExceptionBuilder.createIcineException(
                        USER_NOT_FOUND,
                        HttpStatus.NOT_FOUND
                )
        );
    }

    @Override
    @Transactional
    public User save(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(
                u -> {
                    throw new IcineException(
                            USER_ALREADY_EXISTS,
                            HttpStatus.CONFLICT
                    );
                }
        );
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }
}
