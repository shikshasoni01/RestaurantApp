package com.restaurant.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="food_table")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "food_name")
    private String name;
    @Column(name = "food_price")
    private Double price;
    @Column(name = "food_rating")
    private int rating;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
