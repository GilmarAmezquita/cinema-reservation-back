package icine.cinema.dashboard.application.controller;

import icine.cinema.dashboard.application.api.MovieController;
import icine.cinema.dashboard.domain.dto.response.MovieResponseDTO;
import icine.cinema.dashboard.domain.mapper.MovieMapper;
import icine.cinema.dashboard.domain.service.provider.MovieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {
    private final MovieProvider movieProvider;
    private final MovieMapper movieMapper;

    @Override
    public MovieResponseDTO getMovie(long id) {
        return movieMapper.toResponseDTO(movieProvider.getMovieById(id));
    }

    @Override
    public Page<MovieResponseDTO> getMovies(Authentication authentication, Pageable pageable) {
        return movieProvider.getMovies(pageable).map(movieMapper::toResponseDTO);
    }
}
