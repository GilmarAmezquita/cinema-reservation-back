package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.response.MovieResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieResponseDTO toResponseDTO(Movie movie);
}
