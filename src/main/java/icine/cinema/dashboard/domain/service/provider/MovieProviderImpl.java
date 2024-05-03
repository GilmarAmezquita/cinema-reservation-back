package icine.cinema.dashboard.domain.service.provider;

import icine.cinema.dashboard.domain.exception.util.IcineExceptionBuilder;
import icine.cinema.dashboard.infrastructure.model.Movie;
import icine.cinema.dashboard.infrastructure.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieProviderImpl implements MovieProvider {
    public static String MOVIE_NOT_FOUND = "Movie not found.";

    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElseThrow(
                IcineExceptionBuilder.createIcineException(
                        MOVIE_NOT_FOUND,
                        HttpStatus.NOT_FOUND
                )
        );
    }

    @Override
    public Page<Movie> getMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public List<Movie> getMovies(Sort sort) {
        return movieRepository.findAll(sort);
    }
}
