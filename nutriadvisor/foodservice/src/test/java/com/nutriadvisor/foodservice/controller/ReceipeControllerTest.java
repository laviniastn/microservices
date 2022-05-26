package com.nutriadvisor.foodservice.controller;


import com.nutriadvisor.foodservice.controllers.ReceipeController;
import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.services.FoodMenuService;
import com.nutriadvisor.foodservice.services.NutritionPlanService;
import com.nutriadvisor.foodservice.services.ReceipeService;
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
public class ReceipeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ReceipeController receipeController;

    @MockBean
    private ReceipeService receipeService;

    @MockBean
    private FoodMenuService foodMenuService;

    @MockBean
    private NutritionPlanService nutritionPlanService;

    @Test
    public void test_receipeController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/receipes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_receipeController_getRoleById() throws Exception {

        List<ReceipeDTO> receipesDTO = new ArrayList<>();
        ReceipeDTO roleDTO = new ReceipeDTO(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        receipesDTO.add(roleDTO);

        given(receipeService.findAll()).willReturn(receipesDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/receipes/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_receipeController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/receipes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"receipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_receipeController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/receipes/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"receipeName\":\"omlette\",\"ingredients\":\"2 eggs, salt, onions\",\"category\":\"breakfast\",\"kcals\":200.0,\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_receipeController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/receipes/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
