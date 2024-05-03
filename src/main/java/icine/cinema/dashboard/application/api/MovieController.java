package icine.cinema.dashboard.application.api;

import icine.cinema.dashboard.domain.dto.response.MovieResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/movie")
public interface MovieController {
    @GetMapping("/{id}")
    MovieResponseDTO getMovie(
            @PathVariable long id
    );

    @GetMapping
    Page<MovieResponseDTO> getMovies(
            Authentication authentication,
            @PageableDefault Pageable pageable
    );
}
