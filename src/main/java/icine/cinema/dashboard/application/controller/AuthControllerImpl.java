package icine.cinema.dashboard.application.controller;

import icine.cinema.dashboard.application.api.AuthController;
import icine.cinema.dashboard.domain.dto.request.AuthenticationRequestDTO;
import icine.cinema.dashboard.domain.dto.request.UserRequestDTO;
import icine.cinema.dashboard.domain.dto.response.AuthenticationResponseDTO;
import icine.cinema.dashboard.domain.dto.response.UserResponseDTO;
import icine.cinema.dashboard.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final UserService userService;

    @Override
    public UserResponseDTO register(UserRequestDTO requestDTO) {
        return userService.register(requestDTO);
    }

    @Override
    public AuthenticationResponseDTO login(AuthenticationRequestDTO requestDTO) {
        return userService.login(requestDTO);
    }
}
