package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Projection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectionMapper {
    ProjectionResponseDTO toProjectionResponseDTO(Projection projectionResponseDTO);
}
