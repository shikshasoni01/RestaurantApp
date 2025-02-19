package com.restaurant.service;

import com.restaurant.DTO.CartDTO;
import com.restaurant.entity.Cart;
import com.restaurant.entity.Food;
import com.restaurant.entity.User;
import com.restaurant.exception.RestaurantException;
import com.restaurant.repository.CartRepository;
import com.restaurant.repository.FoodRepository;
import com.restaurant.repository.UserRepository;
import com.restaurant.requestwrapper.CartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private UserRepository userRepository;

    public void addCart(CartRequestWrapper cartRequestWrapper) throws RestaurantException{

        Optional<User> user= userRepository.findById(cartRequestWrapper.getUserId());
        Optional<Food> food = foodRepository.findById(cartRequestWrapper.getFoodId());

        if(user.isPresent())
        {
           if(food.isPresent()){
               Cart cart =new Cart();
               cart.setFood(food.get());
               cart.setUser(user.get());
               cart.setQuantity(cartRequestWrapper.getQuantity());
               cartRepository.save(cart);
           }else{
               throw new RestaurantException(
                       "Food Not Exist", 400);
           }
        }else{
            throw new RestaurantException(
                    "User Not Exist", 400);
        }
    }
    public List<CartDTO> viewCart(Long userId) throws RestaurantException{

        Optional<User> user= userRepository.findById(userId);
        List<CartDTO> cartDTOS=new ArrayList<>();
        if(user.isPresent())
        {
            List<Cart> carts=cartRepository.findByUser(user.get());
            for(Cart cart:carts){
                CartDTO cartDTO =new CartDTO();
                cartDTO.setFoodName(cart.getFood().getName());
                cartDTO.setFoodPrice(cart.getFood().getPrice());
                cartDTO.setQuantity(cart.getQuantity());
                cartDTOS.add(cartDTO);
            }
        }else{
            throw new RestaurantException(
                    "User Not Exist", 400);
        }
        return cartDTOS;
    }
}
