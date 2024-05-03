package icine.cinema.dashboard.domain.dto.response;

import java.util.Set;

public record RoomResponseDTO(
        long id,
        long capacity,
        Set<SeatResponseDTO> seats
) {
}
