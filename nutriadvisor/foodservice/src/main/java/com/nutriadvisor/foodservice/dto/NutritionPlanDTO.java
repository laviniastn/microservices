package com.nutriadvisor.foodservice.dto;

import com.nutriadvisor.foodservice.model.FoodMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

}
