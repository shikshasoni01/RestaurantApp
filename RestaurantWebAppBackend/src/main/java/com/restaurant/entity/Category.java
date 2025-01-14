package com.restaurant.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="food_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "category_name")
    private String categoryName;

    public Category() {
    }
    public Category(long id, String categoryName) {

        this.id = id;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
