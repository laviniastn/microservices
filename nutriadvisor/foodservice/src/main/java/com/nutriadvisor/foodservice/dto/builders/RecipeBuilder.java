package com.nutriadvisor.foodservice.dto.builders;

import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.model.Recipe;

public class RecipeBuilder {

    public RecipeBuilder() {
    }

    public static RecipeDTO generateDTOFromEntity(Recipe recipe){
        return new RecipeDTO(
                recipe.getId(),
                recipe.getRecipeName(),
                recipe.getIngredients(),
                recipe.getCategory(),
                recipe.getKcals(),
                recipe.getPhoto()
                );
    }

    public static Recipe generateEntityFromDTO(RecipeDTO recipeDTO){
        return new Recipe(
                recipeDTO.getId(),
                recipeDTO.getRecipeName(),
                recipeDTO.getIngredients(),
                recipeDTO.getCategory(),
                recipeDTO.getKcals(),
                recipeDTO.getPhoto()
                );
    }

}
