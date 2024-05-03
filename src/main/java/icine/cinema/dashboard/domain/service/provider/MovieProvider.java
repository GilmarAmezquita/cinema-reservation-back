package icine.cinema.dashboard.domain.service.provider;

import icine.cinema.dashboard.infrastructure.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MovieProvider {
    Movie getMovieById(long id);
    Page<Movie> getMovies(Pageable pageable);
    List<Movie> getMovies(Sort sort);
}
