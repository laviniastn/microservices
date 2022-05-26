package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;

public class ReceipeDTO {

    private int id;

    private String receipeName;

    private String ingredients;

    private String category;

    private float kcals;

    private byte[] photo;

    private FoodMenu foodMenu;

    public ReceipeDTO() {

    }

    public ReceipeDTO(int id, String receipeName, String ingredients, String category,float kcals, byte[] photo) {
        this.id = id;
        this.receipeName = receipeName;
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

    public String getReceipeName() {
        return receipeName;
    }

    public void setReceipeName(String receipeName) {
        this.receipeName = receipeName;
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
