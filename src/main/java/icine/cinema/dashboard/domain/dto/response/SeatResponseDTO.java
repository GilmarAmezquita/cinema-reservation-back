package icine.cinema.dashboard.domain.dto.response;

public record SeatResponseDTO(
        long id,
        int row,
        int number,
        int price
) {
}
