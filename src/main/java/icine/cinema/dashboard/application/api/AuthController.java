package icine.cinema.dashboard.application.api;

import icine.cinema.dashboard.domain.dto.AuthenticationRequestDTO;
import icine.cinema.dashboard.domain.dto.request.UserRequestDTO;
import icine.cinema.dashboard.domain.dto.response.AuthenticationResponseDTO;
import icine.cinema.dashboard.domain.dto.response.UserResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/register")
    UserResponseDTO register(
            @RequestBody UserRequestDTO requestDTO
    );

    @PostMapping("/login")
    AuthenticationResponseDTO login(
            @RequestBody AuthenticationRequestDTO requestDTO
    );
}
