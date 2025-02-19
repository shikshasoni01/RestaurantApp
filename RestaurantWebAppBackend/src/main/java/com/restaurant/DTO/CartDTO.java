package com.restaurant.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {

    private String foodName;
    private Double foodPrice;
    private Long quantity;

}
