package com.nutriadvisor.foodservice.controller;


import com.nutriadvisor.foodservice.controllers.NutritionPlanController;
import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
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
public class NutritionPlanControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    NutritionPlanController nutritionPlanController;

    @MockBean
    private RecipeService roleService;

    @MockBean
    private FoodMenuService foodMenuService;

    @MockBean
    private NutritionPlanService nutritionPlanService;

    @Test
    public void test_nutritionPlanController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/nutritionplans")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void test_nutritionPlanController_getRoleById() throws Exception {

        List<NutritionPlanDTO> nutritionPlansDTO = new ArrayList<>();
        NutritionPlanDTO nutritionPlanDTO = new NutritionPlanDTO(1, 10);
        nutritionPlansDTO.add(nutritionPlanDTO);

        given(nutritionPlanService.findAll()).willReturn(nutritionPlansDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/nutritionplans/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_nutritionPlanController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/nutritionplans/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"receipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_nutritionPlanController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/nutritionplans/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"receipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_nutritionPlanController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/nutritionplans/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
