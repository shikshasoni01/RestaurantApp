package com.restaurant.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class RoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role_name")
    private String role;

    public long getId() {
        return id;
    }
//
    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

