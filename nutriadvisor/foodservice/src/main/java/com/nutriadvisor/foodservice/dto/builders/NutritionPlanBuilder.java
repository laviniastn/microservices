package com.nutriadvisor.foodservice.dto.builders;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.model.FoodMenu;
import com.nutriadvisor.foodservice.model.NutritionPlan;

public class NutritionPlanBuilder {

    public NutritionPlanBuilder(){

    }

    public static NutritionPlanDTO generateDTOFromEntity(NutritionPlan nutritionPlan){
        return new NutritionPlanDTO(
                nutritionPlan.getId(),
                nutritionPlan.getNrOfDays()
        );

    }

    public static NutritionPlan generateEntityFromDTO(NutritionPlanDTO nutritionPlanDTO){
        return new NutritionPlan(
                nutritionPlanDTO.getId(),
                nutritionPlanDTO.getNrOfDays()
        );
    }
}
