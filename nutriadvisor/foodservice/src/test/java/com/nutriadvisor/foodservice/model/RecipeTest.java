package com.nutriadvisor.foodservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeTest {

    private Recipe recipe;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        recipe =new Recipe(1, "name", "eggs","breakfast",10.5f,new byte[1]);
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
        int actualId= recipe.getId();
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
        recipe.setId(expectedId);
        int actualId= recipe.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getRecipeName(){
        /**
         * GIVEN
         */
        String expectedRecipeName="name";

        /**
         * WHEN
         */
        String actualRecipeName= recipe.getRecipeName();
        /**
         * THEN
         */
        assertEquals(expectedRecipeName,actualRecipeName);
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
        recipe.setRecipeName(expectedRoleName);
        String actualRoleName= recipe.getRecipeName();
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
        String actualIngredients= recipe.getIngredients();
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
        recipe.setIngredients(expectedIngredients);
        String actualIngredients= recipe.getIngredients();
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
        String actualCategory= recipe.getCategory();
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
        recipe.setCategory(expectedCategory);
        String actualCategory= recipe.getCategory();
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
        float actualKcals= recipe.getKcals();
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
        recipe.setKcals(expectedKcals);
        float actualKcals= recipe.getKcals();
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

        byte[] actualBytes= recipe.getPhoto();

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
        recipe.setPhoto(expectedBytes);
        byte[] actualBytes= recipe.getPhoto();
        /**
         * THEN
         */
        assertEquals(expectedBytes,actualBytes);
    }

}
