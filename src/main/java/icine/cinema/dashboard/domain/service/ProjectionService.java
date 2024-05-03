package icine.cinema.dashboard.domain.service;

import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;

import java.util.List;

public interface ProjectionService {
    List<ProjectionResponseDTO> getProjectionsByMovie(long movieId);
}
