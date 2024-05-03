package icine.cinema.dashboard.domain.dto.response;

import java.util.Date;

public record MovieResponseDTO(
        long id,
        String name,
        String director,
        long durationMin,
        String url,
        Date premiere
) {
}
