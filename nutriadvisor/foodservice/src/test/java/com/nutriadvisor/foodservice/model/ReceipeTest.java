package com.nutriadvisor.foodservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReceipeTest {

    private Receipe receipe;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        receipe=new Receipe(1, "name", "eggs","breakfast",10.5f,new byte[1]);
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
        int actualId=receipe.getId();
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
        receipe.setId(expectedId);
        int actualId=receipe.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getReceipeName(){
        /**
         * GIVEN
         */
        String expectedReceipeName="name";

        /**
         * WHEN
         */
        String actualReceipeName=receipe.getReceipeName();
        /**
         * THEN
         */
        assertEquals(expectedReceipeName,actualReceipeName);
    }

    @Test
    public void test_setRoleName(){
        /**
         * GIVEN
         */
        String expectedRoleName="name";

        /**
         * WHEN
         */
        receipe.setReceipeName(expectedRoleName);
        String actualRoleName=receipe.getReceipeName();
        /**
         * THEN
         */
        assertEquals(expectedRoleName,actualRoleName);
    }

    @Test
    public void test_getIngredients(){
        /**
         * GIVEN
         */
        String expectedIngredients="eggs";

        /**
         * WHEN
         */
        String actualIngredients=receipe.getIngredients();
        /**
         * THEN
         */
        assertEquals(expectedIngredients,actualIngredients);
    }

    @Test
    public void test_setIngredients(){
        /**
         * GIVEN
         */
        String expectedIngredients="eggs";

        /**
         * WHEN
         */
        receipe.setIngredients(expectedIngredients);
        String actualIngredients=receipe.getIngredients();
        /**
         * THEN
         */
        assertEquals(expectedIngredients,actualIngredients);
    }

    @Test
    public void test_getCategory(){
        /**
         * GIVEN
         */
        String expectedCategory="breakfast";

        /**
         * WHEN
         */
        String actualCategory=receipe.getCategory();
        /**
         * THEN
         */
        assertEquals(expectedCategory,actualCategory);
    }

    @Test
    public void test_setCategory(){
        /**
         * GIVEN
         */
        String expectedCategory="breakfast";

        /**
         * WHEN
         */
        receipe.setCategory(expectedCategory);
        String actualCategory=receipe.getCategory();
        /**
         * THEN
         */
        assertEquals(expectedCategory,actualCategory);
    }

    @Test
    public void test_getKcals(){
        /**
         * GIVEN
         */
        float expectedKcals=10.5f;

        /**
         * WHEN
         */
        float actualKcals=receipe.getKcals();
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
        receipe.setKcals(expectedKcals);
        float actualKcals=receipe.getKcals();
        /**
         * THEN
         */
        assertEquals(expectedKcals,actualKcals);
    }

    @Test
    public void test_getPhoto(){
        /**
         * GIVEN
         */
        byte[] expectedBytes= new byte[1];
        byte myByte=1;
        expectedBytes[0]=myByte;


        /**
         * WHEN
         */

        byte[] actualBytes=receipe.getPhoto();

        /**
         * THEN
         */
        assertEquals(expectedBytes.length,actualBytes.length);
    }

    @Test
    public void test_setPhoto(){
        /**
         * GIVEN
         */
        byte[] expectedBytes= new byte[1];
        byte myByte=1;
        expectedBytes[0]=myByte;

        /**
         * WHEN
         */
        receipe.setPhoto(expectedBytes);
        byte[] actualBytes=receipe.getPhoto();
        /**
         * THEN
         */
        assertEquals(expectedBytes,actualBytes);
    }

}
