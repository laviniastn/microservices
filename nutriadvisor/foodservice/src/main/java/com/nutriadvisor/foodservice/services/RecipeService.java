package com.nutriadvisor.foodservice.services;



import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.dto.builders.RecipeBuilder;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.Recipe;
import com.nutriadvisor.foodservice.repositories.RecipeRepository;
import com.nutriadvisor.foodservice.validators.RecipeFieldsValidator;
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
        Optional<Recipe> recipe = recipeRepository.findById(recipeDTO.getId());
        if (!recipe.isPresent()) {
            throw new ResourceNotFoundException("Recipe", "recipe id", recipeDTO.getId());
        }

        RecipeFieldsValidator.validateInsertOrUpdate(recipeDTO);

        return recipeRepository.save(RecipeBuilder.generateEntityFromDTO(recipeDTO)).getId();
    }

    public void delete(Integer id) {
        this.recipeRepository.deleteById(id);
    }
}
