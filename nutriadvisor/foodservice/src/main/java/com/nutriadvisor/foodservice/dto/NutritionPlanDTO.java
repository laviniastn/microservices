package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;

import java.util.List;

public class NutritionPlanDTO {

    private int id;

    private String nrOfDays;

    private List<FoodMenu> foodMenus;

    public NutritionPlanDTO(){

    }

    public NutritionPlanDTO(int id, String nrOfDays){
        this.id=id;
        this.nrOfDays=nrOfDays;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(String nrOfDays) {
        this.nrOfDays = nrOfDays;
    }
}
