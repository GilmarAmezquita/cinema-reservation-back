package icine.cinema.dashboard.domain.dto.response;

public record UserResponseDTO(
        long id,
        String firstName,
        String lastName,
        String email
) {
}
