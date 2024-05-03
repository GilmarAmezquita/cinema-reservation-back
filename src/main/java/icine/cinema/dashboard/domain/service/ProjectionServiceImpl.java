package icine.cinema.dashboard.domain.service;

import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;
import icine.cinema.dashboard.domain.mapper.ProjectionMapper;
import icine.cinema.dashboard.infrastructure.repository.ProjectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectionServiceImpl implements ProjectionService {
    private final ProjectionRepository projectionRepository;
    private final ProjectionMapper projectionMapper;

    @Override
    public List<ProjectionResponseDTO> getProjectionsByMovie(long movieId) {
        return projectionRepository.findAllByMovieId(movieId).stream()
                .map(projectionMapper::toProjectionResponseDTO)
                .toList();
    }
}
