package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.SeatResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatResponseDTO toSeatResponseDTO(Seat seat);
}
