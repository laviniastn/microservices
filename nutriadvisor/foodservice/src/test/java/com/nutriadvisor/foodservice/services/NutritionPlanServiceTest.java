package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.model.NutritionPlan;
import com.nutriadvisor.foodservice.repositories.NutritionPlanRepository;
import errorhandler.ResourceNotFoundException;
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
public class NutritionPlanServiceTest {

    @MockBean
    private NutritionPlanRepository nutritionPlanRepository;

    @Autowired
    NutritionPlanService nutritionPlanService;

    List<NutritionPlanDTO> nutritionPlansDTO;

    List<NutritionPlan> nutritionPlans;

    NutritionPlanDTO nutritionPlanDTO;

    NutritionPlan nutritionPlan;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        nutritionPlanService = new NutritionPlanService(nutritionPlanRepository);

        nutritionPlanDTO = new NutritionPlanDTO(1, 10);

        nutritionPlansDTO = new ArrayList<>();
        nutritionPlansDTO.add(nutritionPlanDTO);

        nutritionPlan = new NutritionPlan(1, 10);

        nutritionPlans = new ArrayList<>();
        nutritionPlans.add(nutritionPlan);

    }

    @Test
    public void nutritionPlanService_findAll() {
        /**
         *  GIVEN
         */

        given(nutritionPlanRepository.findAll()).willReturn(nutritionPlans);

        /**
         *  WHEN
         */

        List<NutritionPlanDTO> actualnutritionPlanDTO = nutritionPlanService.findAll();

        /**
         * THEN
         */
        assertEquals(nutritionPlansDTO.size(), actualnutritionPlanDTO.size());
        assertEquals(nutritionPlansDTO.get(0).getId(), actualnutritionPlanDTO.get(0).getId());
        assertEquals(nutritionPlansDTO.get(0).getNrOfDays(), actualnutritionPlanDTO.get(0).getNrOfDays());

          }

    @Test
    public void nutritionPlanService_insert() {
        /**
         *  GIVEN
         */

        given(nutritionPlanRepository.save(any())).willReturn(nutritionPlan);
        int expectedId = nutritionPlan.getId();

        /**
         *  WHEN
         */

        int actualId = nutritionPlanService.insert(nutritionPlanDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void nutritionPlanService_update() {
        /**
         *  GIVEN
         */

        given(nutritionPlanRepository.findById(any())).willReturn(Optional.ofNullable(nutritionPlan));
        given(nutritionPlanRepository.save(any())).willReturn(nutritionPlan);
        int expectedId = nutritionPlans.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = nutritionPlanService.update(nutritionPlanDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void nutritionPlanService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */
        given(nutritionPlanRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "nutritionPlan not found with nutritionPlan id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                nutritionPlanService.update(nutritionPlanDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nutritionPlanService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(nutritionPlanRepository);


        /**
         *  WHEN
         */

        nutritionPlanService.delete(nutritionPlan.getId());

        /**
         * THEN
         */


        List<NutritionPlanDTO> actualnutritionPlansDTO = nutritionPlanService.findAll();
        assertEquals(expectedSize, actualnutritionPlansDTO.size());
    }
}
