package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;

import java.util.List;

public class NutritionPlanDTO {

    private int id;

    private int nrOfDays;

    private List<FoodMenu> foodMenus;

    public NutritionPlanDTO(){

    }

    public NutritionPlanDTO(int id, int nrOfDays){
        this.id=id;
        this.nrOfDays=nrOfDays;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }
}
