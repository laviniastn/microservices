package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.FoodMenu;
import com.nutriadvisor.foodservice.repositories.FoodMenuRepository;
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
public class FoodMenuServiceTest {

    @MockBean
    private FoodMenuRepository foodMenuRepository;

    @Autowired
    FoodMenuService foodMenuService;

    List<FoodMenuDTO> foodMenusDTO;

    List<FoodMenu> foodMenus;

    FoodMenuDTO foodMenuDTO;

    FoodMenu foodMenu;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        foodMenuService = new FoodMenuService(foodMenuRepository);

        foodMenuDTO = new FoodMenuDTO(1, 10, 10f);

        foodMenusDTO = new ArrayList<>();
        foodMenusDTO.add(foodMenuDTO);

        foodMenu = new FoodMenu(1, 10, 10f);

        foodMenus = new ArrayList<>();
        foodMenus.add(foodMenu);

    }

    @Test
    public void foodMenuService_findAll() {
        /**
         *  GIVEN
         */

        given(foodMenuRepository.findAll()).willReturn(foodMenus);

        /**
         *  WHEN
         */

        List<FoodMenuDTO> actualRolesDTO = foodMenuService.findAll();

        /**
         * THEN
         */
        assertEquals(foodMenusDTO.size(), actualRolesDTO.size());
        assertEquals(foodMenusDTO.get(0).getId(), actualRolesDTO.get(0).getId());
        assertEquals(foodMenusDTO.get(0).getDayNr(), actualRolesDTO.get(0).getDayNr());
        assertEquals(foodMenusDTO.get(0).getKcals(), actualRolesDTO.get(0).getKcals());
          }

    @Test
    public void foodMenuService_insert() {
        /**
         *  GIVEN
         */

        given(foodMenuRepository.save(any())).willReturn(foodMenu);
        int expectedId = foodMenu.getId();

        /**
         *  WHEN
         */

        int actualId = foodMenuService.insert(foodMenuDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void foodMenuService_update() {
        /**
         *  GIVEN
         */

        given(foodMenuRepository.findById(any())).willReturn(Optional.ofNullable(foodMenu));
        given(foodMenuRepository.save(any())).willReturn(foodMenu);
        int expectedId = foodMenus.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = foodMenuService.update(foodMenuDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void foodMenuService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */

        given(foodMenuRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "FoodMenu not found with foodMenu id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                foodMenuService.update(foodMenuDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void foodMenuService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(foodMenuRepository);


        /**
         *  WHEN
         */

        foodMenuService.delete(foodMenu.getId());

        /**
         * THEN
         */


        List<FoodMenuDTO> actualRolesDTO = foodMenuService.findAll();
        assertEquals(expectedSize, actualRolesDTO.size());
    }
}
