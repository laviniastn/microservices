package com.nutriadvisor.foodservice.services;



import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.dto.builders.RecipeBuilder;
import com.nutriadvisor.foodservice.dto.mappers.RecipeMapper;
import com.nutriadvisor.foodservice.model.Recipe;
import com.nutriadvisor.foodservice.repositories.RecipeRepository;
import com.nutriadvisor.foodservice.validators.RecipeFieldsValidator;
import errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(RecipeBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }

    public Integer insert(RecipeDTO recipeDTO) {
        RecipeFieldsValidator.validateInsertOrUpdate(recipeDTO);
        return recipeRepository.save(RecipeBuilder.generateEntityFromDTO(recipeDTO)).getId();
    }

    public Integer update(RecipeDTO recipeDTO) {

        RecipeFieldsValidator.validateInsertOrUpdate(recipeDTO);

        Recipe recipeFromDTO = RecipeMapper.INSTANCE.toRecipe(recipeDTO);

        Optional<Recipe> recipe = recipeRepository.findById(recipeFromDTO.getId());
        if (!recipe.isPresent()) {
            throw new ResourceNotFoundException("Recipe", "recipe id", recipeDTO.getId());
        }

        return recipeRepository.save(RecipeMapper.INSTANCE.toRecipe(recipeDTO)).getId();
    }

    public void delete(Integer id) {
        this.recipeRepository.deleteById(id);
    }
}
