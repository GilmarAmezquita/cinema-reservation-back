package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.MovieResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "url", source = "url")
    MovieResponseDTO toResponseDTO(Movie movie);
}
