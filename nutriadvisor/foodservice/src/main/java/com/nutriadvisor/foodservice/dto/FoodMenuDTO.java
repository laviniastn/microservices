package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.NutritionPlan;
import com.nutriadvisor.foodservice.model.Receipe;

import java.util.List;

public class FoodMenuDTO {

    private int id;

    private int dayNr;

    private float kcals;

    private List<Receipe> receipes;

    private NutritionPlan nutritionPlan;

    public FoodMenuDTO(){

    }

    public FoodMenuDTO(int id, int dayNr, float kcals){
        this.id=id;
        this.dayNr=dayNr;
        this.kcals=kcals;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayNr() {
        return dayNr;
    }

    public void setDayNr(int dayNr) {
        this.dayNr = dayNr;
    }

    public float getKcals() {
        return kcals;
    }

    public void setKcals(float kcals) {
        this.kcals = kcals;
    }
}
