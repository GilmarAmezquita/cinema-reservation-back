package icine.cinema.dashboard.domain.dto.response;

import java.util.Date;
import java.util.Set;

public record ProjectionResponseDTO(
        long id,
        Date startDate,
        RoomResponseDTO room,
        Set<SeatReservedResponseDTO> seatReserveds
) {
}
