package sit.thinktaegeb.mybackend.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CloseDateValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface CloseDate {
    String message() default "must be later than publish date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String publishDate();

    String closeDate();
}