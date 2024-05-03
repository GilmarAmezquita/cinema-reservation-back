package icine.cinema.dashboard.domain.exception;

import icine.cinema.dashboard.domain.dto.ErrorDetailDTO;
import icine.cinema.dashboard.domain.exception.error.IcineException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Map<String,String>> handleIOException (IOException exception){
        Map<String,String> message = new HashMap<>();
        message.put("message", exception.getMessage() );
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IcineException.class)
    public ResponseEntity<ErrorDetailDTO> handleGIDException(IcineException icineException) {
        return new ResponseEntity<>(new ErrorDetailDTO(
                icineException.getMessage(),
                icineException.getStatus()
        ), icineException.getStatus());
    }
}
