package com.nutriadvisor.foodservice.controllers;

import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.services.RecipeService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    private static final Logger logger = Logger.getLogger(RecipeController.class);

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        logger.setLevel(Level.DEBUG);
        this.recipeService = recipeService;
    }

    @GetMapping()
    public List<RecipeDTO> getAllRecipes() {

        logger.debug("Get all recipes");
        return recipeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public RecipeDTO getRoleById(@PathVariable("id") Integer id) {
        logger.debug("Get  recipe by id");
        return recipeService.findAll().get(id - 1);
    }

    @PostMapping(value = "/create")
    public Integer createRecipe(@RequestBody RecipeDTO recipeDTO) {
        logger.debug("Create recipe");
        return recipeService.insert(recipeDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateRecipe(@RequestBody RecipeDTO recipeDTO) {
        logger.debug("Update recipe");
        return recipeService.update(recipeDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteRecipeById(@PathVariable("id") Integer id) {
        logger.debug("Delete recipe");
        recipeService.delete(id);
    }

}
