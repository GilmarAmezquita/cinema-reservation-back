package icine.cinema.dashboard.domain.dto;

public record AuthenticationRequestDTO(
        String email,
        String password) {
}
