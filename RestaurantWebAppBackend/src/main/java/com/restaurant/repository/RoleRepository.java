package com.restaurant.repository;

import com.restaurant.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleType,Long>
{
    @Query("select r from RoleType r where UPPER(r.role)= ?1")
    RoleType findByRole(String role);
}
