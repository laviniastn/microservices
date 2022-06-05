package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
