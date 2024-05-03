package icine.cinema.dashboard.domain.exception.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IcineException extends RuntimeException {
    private final HttpStatus status;

    public IcineException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public IcineException(HttpStatus status) {
        this.status = status;
    }
}
