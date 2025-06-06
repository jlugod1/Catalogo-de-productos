package com.ecom.productCatalog.controler;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")


public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}



