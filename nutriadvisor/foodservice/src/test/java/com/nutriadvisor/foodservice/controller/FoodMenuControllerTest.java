package com.nutriadvisor.foodservice.controller;


import com.nutriadvisor.foodservice.controllers.FoodMenuController;
import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
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
public class FoodMenuControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    FoodMenuController foodMenuController;

    @MockBean
    private RecipeService roleService;

    @MockBean
    private FoodMenuService foodMenuService;

    @MockBean
    private NutritionPlanService nutritionPlanService;

    @Test
    public void test_foodMenuController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/foodmenus")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_foodMenuController_getRoleById() throws Exception {

        List<FoodMenuDTO> foodMenusDTO = new ArrayList<>();
        FoodMenuDTO foodMenuDTO = new FoodMenuDTO(1, 10,100f);
        foodMenusDTO.add(foodMenuDTO);

        given(foodMenuService.findAll()).willReturn(foodMenusDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/foodmenus/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_foodMenuController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/foodmenus/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"dayNr\":1,\"kcals\":1200.0}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_foodMenuController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/foodmenus/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"dayNr\":1,\"kcals\":1200.0}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_foodMenuController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/foodmenus/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
