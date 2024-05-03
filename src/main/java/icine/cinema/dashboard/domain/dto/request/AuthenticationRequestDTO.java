package icine.cinema.dashboard.domain.dto.request;

public record AuthenticationRequestDTO(
        String email,
        String password) {
}
