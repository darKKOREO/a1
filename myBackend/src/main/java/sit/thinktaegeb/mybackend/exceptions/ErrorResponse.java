package sit.thinktaegeb.mybackend.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int status;
    private String message;
    private String instance;
    private List<ValidationError> detail;


    public void addValidationError(String field, String message) {
        if (Objects.isNull(detail)) {
            detail = new ArrayList<>();
        }
        detail.add(new ValidationError(field, message));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    private static class ValidationError {
        private String field;
        private String errorMessage;


    }

}