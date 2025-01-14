package com.restaurant.controller;

import com.restaurant.constant.Webconstant;
import com.restaurant.entity.Category;
import com.restaurant.exception.RestaurantException;
import com.restaurant.formatter.ResponseFormatter;
import com.restaurant.requestwrapper.CategoryRequestWrapper;
import com.restaurant.service.CategoryService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<JSONObject> createCategory(@RequestBody CategoryRequestWrapper categoryRequestWrapper) throws RestaurantException
    {
        System.out.println("create category Start");
        categoryService.createCategory(categoryRequestWrapper);

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Category Created Successfully ");

        System.out.println("end category end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<JSONObject> getAllCategory()
    {
        System.out.println("get category Start");
        List<Category> categories=categoryService.getAllCategory();

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Category Listed Successfully ",categories);

        System.out.println("get category end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
