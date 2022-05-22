package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.NutritionPlan;
import com.nutriadvisor.foodservice.model.Receipe;

import java.util.List;

public class FoodMenuDTO {

    private int id;

    private String dayNr;

    private String kcals;

    private List<Receipe> receipes;

    private NutritionPlan nutritionPlan;

    public FoodMenuDTO(){

    }

    public FoodMenuDTO(int id, String dayNr, String kcals){
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

    public String getDayNr() {
        return dayNr;
    }

    public void setDayNr(String dayNr) {
        this.dayNr = dayNr;
    }

    public String getKcals() {
        return kcals;
    }

    public void setKcals(String kcals) {
        this.kcals = kcals;
    }
}
