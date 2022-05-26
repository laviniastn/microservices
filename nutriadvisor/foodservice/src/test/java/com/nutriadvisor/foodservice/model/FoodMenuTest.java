package com.nutriadvisor.foodservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FoodMenuTest {

    private FoodMenu foodMenu;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        foodMenu=new FoodMenu(1, 10, 10f);
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
        int actualId=foodMenu.getId();
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
        foodMenu.setId(expectedId);
        int actualId=foodMenu.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getDayNr(){
        /**
         * GIVEN
         */
        int expectedDayNr=10;

        /**
         * WHEN
         */
        int actualDayNr=foodMenu.getDayNr();
        /**
         * THEN
         */
        assertEquals(expectedDayNr,actualDayNr);
    }

    @Test
    public void test_setDayNr(){
        /**
         * GIVEN
         */
        int expectedDayNr=10;

        /**
         * WHEN
         */
        foodMenu.setDayNr(expectedDayNr);
        int actualDayNr=foodMenu.getDayNr();
        /**
         * THEN
         */
        assertEquals(expectedDayNr,actualDayNr);
    }

    @Test
    public void test_getKcals(){
        /**
         * GIVEN
         */
        float expectedKcals=10f;

        /**
         * WHEN
         */
        float actualKcals=foodMenu.getKcals();
        /**
         * THEN
         */
        assertEquals(expectedKcals,actualKcals);
    }

    @Test
    public void test_setKcals(){
        /**
         * GIVEN
         */
        float expectedKcals=10.5f;

        /**
         * WHEN
         */
        foodMenu.setKcals(expectedKcals);
        float actualKcals=foodMenu.getKcals();
        /**
         * THEN
         */
        assertEquals(expectedKcals,actualKcals);
    }


}
