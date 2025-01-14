package com.restaurant.repository;

import com.restaurant.entity.UserLoggedIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoggedRepository extends JpaRepository<UserLoggedIn,Long> {
}
