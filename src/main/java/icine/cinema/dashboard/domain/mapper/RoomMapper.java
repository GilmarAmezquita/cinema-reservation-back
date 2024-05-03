package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.RoomResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SeatMapper.class})
public interface RoomMapper {
    @Mapping(target = "seats", source = "seats")
    RoomResponseDTO toRoomResponseDTO(Room room);
}
