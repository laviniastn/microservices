package com.nutriadvisor.foodservice.dto.mappers;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.model.FoodMenu;
import com.nutriadvisor.foodservice.model.Recipe;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { FoodMenuMapper.class })
public interface FoodMenuMapper {

    FoodMenuMapper INSTANCE = Mappers.getMapper(FoodMenuMapper.class);

    FoodMenu toFoodMenu(FoodMenuDTO foodMenuDto);

    @InheritInverseConfiguration
    FoodMenuDTO fromFoodMenu(FoodMenu foodMenu);

}
