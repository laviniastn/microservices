package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "recipes")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public Recipe() {

    }

    public Recipe(int id, String recipeName, String ingredients, String category, float kcals, byte[] photo) {
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.category = category;
        this.kcals=kcals;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getKcals() {
        return kcals;
    }

    public void setKcals(float kcals) {
        this.kcals = kcals;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
