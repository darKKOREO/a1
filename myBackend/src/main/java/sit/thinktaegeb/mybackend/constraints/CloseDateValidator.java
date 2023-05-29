package sit.thinktaegeb.mybackend.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanUtils;

import java.time.ZonedDateTime;


public class CloseDateValidator implements ConstraintValidator<CloseDate, Object> {

    private String publishDate;
    private String closeDate;

    @Override
    public void initialize(CloseDate constraintAnnotation) {
        this.publishDate = constraintAnnotation.publishDate();
        this.closeDate = constraintAnnotation.closeDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            ZonedDateTime publishDate = (ZonedDateTime) BeanUtils.getPropertyDescriptor(value.getClass(), this.publishDate).getReadMethod().invoke(value);
            ZonedDateTime closeDate = (ZonedDateTime) BeanUtils.getPropertyDescriptor(value.getClass(), this.closeDate).getReadMethod().invoke(value);
            if (publishDate == null || closeDate == null) {
                return true;
            }
            return closeDate.isAfter(publishDate);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

