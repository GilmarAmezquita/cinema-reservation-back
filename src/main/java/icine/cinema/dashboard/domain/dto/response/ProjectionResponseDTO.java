package icine.cinema.dashboard.domain.dto.response;

import java.util.Date;

public record ProjectionResponseDTO(
        long id,
        Date startDate,
        RoomResponseDTO room
) {
}
