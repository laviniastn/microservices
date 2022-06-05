package com.nutriadvisor.accountservice.services;

import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.dto.mappers.RoleMapper;
import com.nutriadvisor.accountservice.model.Role;
import com.nutriadvisor.accountservice.repositories.RoleRepository;
import errorhandler.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
public class RoleServiceTest {

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    RoleService roleService;

    List<RoleDTO> rolesDTO;

    List<Role> roles;

    RoleDTO roleDTO;

    Role role;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        roleService = new RoleService(roleRepository);


        role = new Role(1, "role");

        roles = new ArrayList<>();
        roles.add(role);

        roleDTO = RoleMapper.INSTANCE.fromRole(role);

        rolesDTO = new ArrayList<>();
        rolesDTO.add(roleDTO);

    }

    @Test
    public void roleService_findAll() {
        /**
         *  GIVEN
         */

        given(roleRepository.findAll()).willReturn(roles);

        /**
         *  WHEN
         */

        List<RoleDTO> actualRolesDTO = roleService.findAll();

        /**
         * THEN
         */
        assertEquals(rolesDTO.size(), actualRolesDTO.size());
            }

    @Test
    public void roleService_insert() {
        /**
         *  GIVEN
         */

        given(roleRepository.save(any())).willReturn(role);
        int expectedId = role.getId();

        /**
         *  WHEN
         */

        int actualId = roleService.insert(roleDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void roleService_update() {
        /**
         *  GIVEN
         */

        given(roleRepository.findById(any())).willReturn(Optional.ofNullable(role));
        given(roleRepository.save(any())).willReturn(role);
        int expectedId = roles.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = roleService.update(roleDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void roleService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */

        given(roleRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "Role not found with role id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                roleService.update(roleDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void roleService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(roleRepository);


        /**
         *  WHEN
         */

        roleService.delete(role.getId());

        /**
         * THEN
         */


        List<RoleDTO> actualRolesDTO = roleService.findAll();
        assertEquals(expectedSize, actualRolesDTO.size());
    }
}
