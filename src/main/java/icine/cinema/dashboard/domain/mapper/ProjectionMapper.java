package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Projection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoomMapper.class})
public interface ProjectionMapper {
    @Mapping(target = "room", source = "room")
    ProjectionResponseDTO toProjectionResponseDTO(Projection projectionResponseDTO);
}
