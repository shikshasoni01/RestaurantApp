package com.restaurant.controller;

import com.restaurant.DTO.CartDTO;
import com.restaurant.constant.Webconstant;
import com.restaurant.exception.RestaurantException;
import com.restaurant.formatter.ResponseFormatter;
import com.restaurant.requestwrapper.CartRequestWrapper;
import com.restaurant.service.CartService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<JSONObject> addCart(@RequestBody CartRequestWrapper cartRequestWrapper) throws RestaurantException
    {
        System.out.println("add cart Start");
        cartService.addCart(cartRequestWrapper);

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Food Created Successfully ");

        System.out.println("add cart end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/getCartItemByUser")
    public ResponseEntity<JSONObject> viewCart(@RequestHeader long userId)
    {
        System.out.println("get cart by user Start");
        List<CartDTO> cartDTOS=cartService.viewCart(userId);

        JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Food By Category Listed Successfully ",cartDTOS);

        System.out.println("get cart by user end");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
