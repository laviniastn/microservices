package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.NutritionPlan;
import com.nutriadvisor.foodservice.model.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodMenuDTO {

    private int id;

    private int dayNr;

    private float kcals;

    private List<Recipe> receipes;

    private NutritionPlan nutritionPlan;

    public FoodMenuDTO(){

    }

    public FoodMenuDTO(int id, int dayNr, float kcals){
        this.id=id;
        this.dayNr=dayNr;
        this.kcals=kcals;

    }

}
