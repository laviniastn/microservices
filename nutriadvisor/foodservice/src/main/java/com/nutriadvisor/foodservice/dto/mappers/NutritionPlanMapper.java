package com.nutriadvisor.foodservice.dto.mappers;

import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.model.NutritionPlan;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { NutritionPlanMapper.class })
public interface NutritionPlanMapper {

    NutritionPlanMapper INSTANCE = Mappers.getMapper(NutritionPlanMapper.class);

    NutritionPlan toNutritionPlan(NutritionPlanDTO nutritionPlanDto);

    @InheritInverseConfiguration
    NutritionPlanDTO fromNutritionPlan(NutritionPlan nutritionPlan);
}
