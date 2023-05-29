package sit.thinktaegeb.mybackend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {


    private Integer categoryId;

    private static String categoryName;

    public static String getCategoryName() {
        return categoryName;
    }
}
