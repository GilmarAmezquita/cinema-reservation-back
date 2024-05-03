package icine.cinema.dashboard.domain.dto;

import org.springframework.http.HttpStatus;

public record ErrorDetailDTO(
        String message,
        HttpStatus status) {
}
