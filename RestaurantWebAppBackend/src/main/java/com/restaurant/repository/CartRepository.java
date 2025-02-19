package com.restaurant.repository;

import com.restaurant.entity.Cart;
import com.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query( "select c from Cart c Join User u on c.user = ?1" )
    List<Cart> findByUser(User user);
}
