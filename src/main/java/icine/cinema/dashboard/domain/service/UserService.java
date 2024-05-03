package icine.cinema.dashboard.domain.service;

import icine.cinema.dashboard.domain.dto.AuthenticationRequestDTO;
import icine.cinema.dashboard.domain.dto.request.UserRequestDTO;
import icine.cinema.dashboard.domain.dto.response.AuthenticationResponseDTO;
import icine.cinema.dashboard.domain.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(UserRequestDTO requestDTO);
    AuthenticationResponseDTO login(AuthenticationRequestDTO requestDTO);
}
