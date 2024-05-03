package icine.cinema.dashboard.application.controller;

import icine.cinema.dashboard.application.api.ProjectionController;
import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;
import icine.cinema.dashboard.domain.service.ProjectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectionControllerImpl implements ProjectionController {
    private final ProjectionService projectionService;

    @Override
    public List<ProjectionResponseDTO> getProjectionsByMovie(long movieId) {
        return projectionService.getProjectionsByMovie(movieId);
    }
}
