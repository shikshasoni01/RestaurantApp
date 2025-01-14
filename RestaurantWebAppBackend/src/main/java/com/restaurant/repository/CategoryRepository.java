package com.restaurant.repository;

import com.restaurant.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c from Category c where UPPER(categoryName) = ?1")
    Optional<Category> findCategoryByName(String name);
}
