package com.nutriadvisor.foodservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NutritionPlanTest {

    private NutritionPlan nutritionPlan;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        nutritionPlan=new NutritionPlan(1, 10);
    }

    @Test
    public void test_getId(){
        /**
         * GIVEN
         */
        int expectedId=1;

        /**
         * WHEN
         */
        int actualId=nutritionPlan.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_setId(){
        /**
         * GIVEN
         */
        int expectedId=10;

        /**
         * WHEN
         */
        nutritionPlan.setId(expectedId);
        int actualId=nutritionPlan.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getNrOfDays(){
        /**
         * GIVEN
         */
        int expectedNrOfDays=10;

        /**
         * WHEN
         */
        int actualNrOfDays=nutritionPlan.getNrOfDays();
        /**
         * THEN
         */
        assertEquals(expectedNrOfDays,actualNrOfDays);
    }

    @Test
    public void test_setNrOfDays(){
        /**
         * GIVEN
         */
        int expectedNrOfDays=10;

        /**
         * WHEN
         */
        nutritionPlan.setNrOfDays(expectedNrOfDays);
        int actualNrOfDays=nutritionPlan.getNrOfDays();
        /**
         * THEN
         */
        assertEquals(expectedNrOfDays,actualNrOfDays);
    }

}
