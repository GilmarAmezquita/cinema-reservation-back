package icine.cinema.dashboard.domain.dto.response;

public record ReservationResponseDTO(
        long id,
        long seats,
        ProjectionResponseDTO projection,
        UserResponseDTO user
) {
}
