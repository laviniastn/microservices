package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.Recipe;
import com.nutriadvisor.foodservice.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
public class RecipesServiceTest {

    @MockBean
    private RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    List<RecipeDTO> recipesDTO;

    List<Recipe> recipes;

    RecipeDTO recipeDTO;

    Recipe recipe;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        recipeService = new RecipeService(recipeRepository);
        Recipe role = new Recipe(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);

        recipeDTO = new RecipeDTO(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        recipesDTO = new ArrayList<>();
        recipesDTO.add(recipeDTO);

        recipe = new Recipe(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        recipes = new ArrayList<>();
        recipes.add(recipe);

    }

    @Test
    public void recipeService_findAll() {
        /**
         *  GIVEN
         */

        given(recipeRepository.findAll()).willReturn(recipes);

        /**
         *  WHEN
         */

        List<RecipeDTO> actualrecipesDTO = recipeService.findAll();

        /**
         * THEN
         */
        assertEquals(recipesDTO.size(), actualrecipesDTO.size());
        assertEquals(recipesDTO.get(0).getId(), actualrecipesDTO.get(0).getId());

    }

    @Test
    public void recipeService_insert() {
        /**
         *  GIVEN
         */

        given(recipeRepository.save(any())).willReturn(recipe);
        int expectedId = recipe.getId();

        /**
         *  WHEN
         */

        int actualId = recipeService.insert(recipeDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void recipeService_update() {
        /**
         *  GIVEN
         */

        given(recipeRepository.findById(any())).willReturn(Optional.ofNullable(recipe));
        given(recipeRepository.save(any())).willReturn(recipe);
        int expectedId = recipes.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = recipeService.update(recipeDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void recipeService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */
        given(recipeRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "Recipe not found with recipe id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                recipeService.update(recipeDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void recipeService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(recipeRepository);


        /**
         *  WHEN
         */

        recipeService.delete(recipe.getId());

        /**
         * THEN
         */

        List<RecipeDTO> actualrecipesDTO = recipeService.findAll();
        assertEquals(expectedSize, actualrecipesDTO.size());
    }
}
