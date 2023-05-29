package sit.thinktaegeb.mybackend.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sit.thinktaegeb.mybackend.services.CategoryService;

@Component
public class CategoryValidator implements ConstraintValidator<CategoryValidate, Integer> {
    @Autowired
    CategoryService categoryService;

    @Scope("request")
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if(value == null) {
            return true;
        }
        return categoryService.getCategoryById(value) != null;  
    }
}
