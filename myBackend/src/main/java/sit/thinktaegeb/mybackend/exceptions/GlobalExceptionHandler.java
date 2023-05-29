package sit.thinktaegeb.mybackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleBadRequestException(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Announcement attribute validation fail!", "uri=/api/announcements", null);
        exception.getBindingResult().getAllErrors().forEach(objectError -> {
            String field = objectError.getCode().equals("CloseDate") ? "closeDate" : ((org.springframework.validation.FieldError) objectError).getField();
            String error = objectError.getDefaultMessage().equals("must be either 'Y' or 'N'") ? "must be either 'Y' or 'N'" : objectError.getDefaultMessage();
            errorResponse.addValidationError(field, error);
        });
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
