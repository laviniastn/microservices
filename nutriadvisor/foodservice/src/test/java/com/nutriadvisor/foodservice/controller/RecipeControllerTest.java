package com.nutriadvisor.foodservice.controller;


import com.nutriadvisor.foodservice.controllers.RecipeController;
import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.services.FoodMenuService;
import com.nutriadvisor.foodservice.services.NutritionPlanService;
import com.nutriadvisor.foodservice.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RecipeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    RecipeController recipeController;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private FoodMenuService foodMenuService;

    @MockBean
    private NutritionPlanService nutritionPlanService;

    @Test
    public void test_recipeController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/recipes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_recipeController_getRoleById() throws Exception {

        List<RecipeDTO> recipesDTO = new ArrayList<>();
        RecipeDTO roleDTO = new RecipeDTO(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        recipesDTO.add(roleDTO);

        given(recipeService.findAll()).willReturn(recipesDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/recipes/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_recipeController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/recipes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"recipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_recipeController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/recipes/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"recipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_recipeController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/recipes/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
