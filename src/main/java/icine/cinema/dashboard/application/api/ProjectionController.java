package icine.cinema.dashboard.application.api;

import icine.cinema.dashboard.domain.dto.response.ProjectionResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/projection")
public interface ProjectionController {
    @GetMapping("/{movieId}")
    List<ProjectionResponseDTO> getProjectionsByMovie(
            @PathVariable long movieId
    );
}
