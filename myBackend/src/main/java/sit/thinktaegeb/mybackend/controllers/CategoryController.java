package sit.thinktaegeb.mybackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.thinktaegeb.mybackend.entities.Category;
import sit.thinktaegeb.mybackend.services.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryService.getCategory();
    }

    @GetMapping("/{categoryId}")
    public Category getAnnouncementById(@PathVariable Integer categoryId) {
        return modelMapper.map(categoryService.getCategoryById(categoryId), Category.class);

    }
}
