package com.nutriadvisor.foodservice.dto.mappers;

import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.model.Recipe;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { RecipeMapper.class })
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe toRecipe(RecipeDTO recipeDto);

    @InheritInverseConfiguration
    RecipeDTO fromRole(Recipe recipe);
}
