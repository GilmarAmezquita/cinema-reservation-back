package icine.cinema.dashboard.domain.dto.request;

import java.util.List;

public record ReservationRequestDTO(
        long seats,
        long projectionId,
        long userId,
        List<Long> seatIds
) {
}
