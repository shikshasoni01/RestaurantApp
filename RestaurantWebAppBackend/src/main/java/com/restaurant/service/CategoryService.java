package com.restaurant.service;

import com.restaurant.entity.Category;
import com.restaurant.exception.RestaurantException;
import com.restaurant.repository.CategoryRepository;
import com.restaurant.requestwrapper.CategoryRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(CategoryRequestWrapper categoryRequestWrapper) throws RestaurantException{
        Optional<Category> category1 = categoryRepository.findCategoryByName(categoryRequestWrapper.getCategoryName());

        if(category1.isEmpty())
        {
            Category category= new Category();
            category.setCategoryName(categoryRequestWrapper.getCategoryName());
            categoryRepository.save(category);
        }else{
            throw new RestaurantException(
                  "CategoryAlreadyExist", 400);
        }
    }
    public List<Category> getAllCategory()
    {
        List<Category> categories=  categoryRepository.findAll();
        return categories;
    }

}
