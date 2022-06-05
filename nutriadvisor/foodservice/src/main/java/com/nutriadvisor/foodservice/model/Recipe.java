package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "recipes")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter @NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "recipe_name", nullable = true)
    private String recipeName;

    @Column(name = "ingredients", nullable = true)
    private String ingredients;

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name = "kcals", nullable = true)
    private float kcals;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name="food_menu_id", nullable=false)
    private FoodMenu foodMenu;

    public Recipe(int id, String recipeName, String ingredients, String category, float kcals, byte[] photo) {
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.category = category;
        this.kcals=kcals;
        this.photo = photo;
    }

}
