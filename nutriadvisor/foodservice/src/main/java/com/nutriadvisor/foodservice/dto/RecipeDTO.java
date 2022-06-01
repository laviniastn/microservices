package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;

public class RecipeDTO {

    private int id;

    private String recipeName;

    private String ingredients;

    private String category;

    private float kcals;

    private byte[] photo;

    private FoodMenu foodMenu;

    public RecipeDTO() {

    }

    public RecipeDTO(int id, String recipeName, String ingredients, String category, float kcals, byte[] photo) {
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
