package com.nutriadvisor.accountservice.controller;

import com.nutriadvisor.accountservice.controllers.RoleController;
import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.services.RoleService;
import com.nutriadvisor.accountservice.services.UserAccountService;
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
public class RoleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    RoleController roleController;

    @MockBean
    private RoleService roleService;

    @MockBean
    private UserAccountService userAccountService;

    @Test
    public void test_roleController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/roles")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_roleController_getRoleById() throws Exception {

        List<RoleDTO> rolesDTO = new ArrayList<>();
        RoleDTO roleDTO = new RoleDTO(1, "role");
        rolesDTO.add(roleDTO);

        given(roleService.findAll()).willReturn(rolesDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/roles/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_roleController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/roles/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"roleName\":\"admin\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_roleController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/roles/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"roleName\":\"admin\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_roleController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/roles/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
