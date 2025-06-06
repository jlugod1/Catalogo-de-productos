package com.ecom.productCatalog.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

    