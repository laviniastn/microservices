package com.nutriadvisor.accountservice.controller;

import com.nutriadvisor.accountservice.controllers.UserAccountController;
import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.dto.mappers.RoleMapper;
import com.nutriadvisor.accountservice.dto.mappers.UserAccountMapper;
import com.nutriadvisor.accountservice.model.Role;
import com.nutriadvisor.accountservice.model.UserAccount;
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
public class UserAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserAccountController userAccountController;

    @MockBean
    private RoleService roleService;

    @MockBean
    private UserAccountService userAccountService;

    @Test
    public void test_userAccountController_getAllRoles() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/accounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_userAccountController_getRoleById() throws Exception {

        Role role=new Role(1,"role");

        List<UserAccountDTO> userAccountsDTO = new ArrayList<>();
        UserAccount userAccount = new UserAccount(1, "Lavinia","Stan", "laviniastn25@gmail.com", "password",role,null);

        UserAccountDTO userAccountDTO = UserAccountMapper.INSTANCE.fromUserAccount(userAccount);
        userAccountsDTO.add(userAccountDTO);

        given(userAccountService.findAll()).willReturn(userAccountsDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/accounts/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_userAccountController_createRole() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/accounts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"firstName\":\"Lavinia\",\"lastName\":\"stan\",\"email\":\"lavinistan25@gmail.com\",\"password\":\"lavinia\\n\",\"role\":{\"id\":1,\"roleName\":\"nutritionist\"},\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_userAccountController_updateRole() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/accounts/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"firstName\":\"Lavinia\",\"lastName\":\"stan\",\"email\":\"lavinistan25@gmail.com\",\"password\":\"lavinia\\n\",\"role\":{\"id\":1,\"roleName\":\"nutritionist\"},\"photo\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_userAccountController_deleteRole() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/accounts/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}

