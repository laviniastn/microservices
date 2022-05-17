package com.nutriadvisor.accountservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoleTest {


    private Role role;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        role=new Role(1,"role");
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
         int actualId=role.getId();
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
        role.setId(expectedId);
        int actualId=role.getId();
        /**
         * THEN
         */
        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getRoleName(){
        /**
         * GIVEN
         */
        String expectedRoleName="role";

        /**
         * WHEN
         */
        String actualRoleName=role.getRoleName();
        /**
         * THEN
         */
        assertEquals(expectedRoleName,actualRoleName);
    }

    @Test
    public void test_setRoleName(){
        /**
         * GIVEN
         */
        String expectedRoleName="admin";

        /**
         * WHEN
         */
        role.setRoleName(expectedRoleName);
        String actualRoleName=role.getRoleName();
        /**
         * THEN
         */
        assertEquals(expectedRoleName,actualRoleName);
    }
}
