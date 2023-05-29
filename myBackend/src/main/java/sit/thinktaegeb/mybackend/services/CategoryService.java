package sit.thinktaegeb.mybackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.thinktaegeb.mybackend.entities.Category;
import sit.thinktaegeb.mybackend.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    //    Get All category
    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    //    Get Category by id
    public Category getCategoryById(Integer categoryId) {
            return categoryRepo.findById(categoryId).orElse(null);
    }
}
