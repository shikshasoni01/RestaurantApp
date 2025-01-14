package com.restaurant.controller;

import com.restaurant.constant.Webconstant;
import com.restaurant.entity.Category;
import com.restaurant.entity.Food;
import com.restaurant.exception.RestaurantException;
import com.restaurant.formatter.ResponseFormatter;
import com.restaurant.requestwrapper.CategoryRequestWrapper;
import com.restaurant.requestwrapper.FoodRequestWrapper;
import com.restaurant.service.CategoryService;
import com.restaurant.service.FoodService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/create")
    public ResponseEntity<JSONObject> createFood(@RequestBody FoodRequestWrapper foodRequestWrapper) throws RestaurantException
    {
        System.out.println("create category Start");
        foodService.createFood(foodRequestWrapper);

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Food Created Successfully ");

        System.out.println("end category end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/getAllFoodByCategory")
    public ResponseEntity<JSONObject> getAllCategory(@RequestHeader long id)
    {
        System.out.println("get food by category Start");
        List<Food> food=foodService.getAllFoodByCategory(id);

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Food By Category Listed Successfully ",food);

        System.out.println("get food by category end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
