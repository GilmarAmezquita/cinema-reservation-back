package icine.cinema.dashboard.domain.exception.util;

import icine.cinema.dashboard.domain.exception.error.IcineException;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class IcineExceptionBuilder {
    public static Supplier<IcineException> createIcineException(String message, HttpStatus status) {
        return () -> new IcineException(message, status);
    }
}
