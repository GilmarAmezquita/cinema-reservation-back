package icine.cinema.dashboard.domain.service;

import icine.cinema.dashboard.domain.dto.AuthenticationRequestDTO;
import icine.cinema.dashboard.domain.dto.request.UserRequestDTO;
import icine.cinema.dashboard.domain.dto.response.AuthenticationResponseDTO;
import icine.cinema.dashboard.domain.dto.response.UserResponseDTO;
import icine.cinema.dashboard.domain.mapper.UserMapper;
import icine.cinema.dashboard.domain.service.provider.AuthorityProvider;
import icine.cinema.dashboard.domain.service.provider.UserProvider;
import icine.cinema.dashboard.infrastructure.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final AuthorityProvider authorityProvider;
    private final UserProvider userProvider;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDTO register(UserRequestDTO requestDTO) {
        User user = userMapper.toEntity(requestDTO);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityProvider.getAuthorityUser());
        return userMapper.toDTO(userProvider.save(user));
    }

    @Override
    public AuthenticationResponseDTO login(AuthenticationRequestDTO requestDTO) {
        return new AuthenticationResponseDTO(jwtService.generateToken(
                userProvider.findByEmail(requestDTO.email())
        ));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userProvider.findByEmail(username);
    }
}
