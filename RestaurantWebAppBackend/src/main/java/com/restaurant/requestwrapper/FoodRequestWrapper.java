package com.restaurant.requestwrapper;

import com.restaurant.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestWrapper {

    private String name;
    private Double price;
    private int rating;
    private long categoryId;
}
