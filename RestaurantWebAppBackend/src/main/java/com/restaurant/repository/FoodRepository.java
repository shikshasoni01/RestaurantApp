package com.restaurant.repository;


import com.restaurant.entity.Category;
import com.restaurant.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    @Query("select f from Food f where UPPER(name) = ?1")
    Optional<Food> findByFoodName(String name);
    @Query( "select f from Food f Join Category c on f.category = ?1" )
    List<Food> findByCategory( Category category);
}
