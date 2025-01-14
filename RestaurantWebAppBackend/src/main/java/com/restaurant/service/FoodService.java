package com.restaurant.service;

import com.restaurant.entity.Category;
import com.restaurant.entity.Food;
import com.restaurant.exception.RestaurantException;
import com.restaurant.repository.CategoryRepository;
import com.restaurant.repository.FoodRepository;

import com.restaurant.requestwrapper.FoodRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void createFood(FoodRequestWrapper foodRequestWrapper) throws RestaurantException {
        Optional<Food> food = foodRepository.findByFoodName(foodRequestWrapper.getName());

        if(food.isEmpty())
        {
            Food newFood= new Food();
            newFood.setName(foodRequestWrapper.getName());
            newFood.setPrice(foodRequestWrapper.getPrice());
            newFood.setRating(foodRequestWrapper.getRating());
            Optional<Category> category = categoryRepository.findById(foodRequestWrapper.getCategoryId());
            if (category.isPresent()) {
                newFood.setCategory ( category.get () );
            } else {
                throw new RestaurantException("CategoryNotExist",400);
            }
            foodRepository.save(newFood);
        }else{
            throw new RestaurantException(
                    "FoodAlreadyExist", 400);
        }
    }
    public List<Food> getAllFoodByCategory(long id)
    {
        List<Food> food=  foodRepository.findByCategory(id);
        return food;
    }


}
