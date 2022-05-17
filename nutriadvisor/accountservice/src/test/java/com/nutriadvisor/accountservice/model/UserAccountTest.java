package com.nutriadvisor.accountservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserAccountTest {

    public Role role;

    public UserAccount userAccount;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        role=new Role(1,"role");
        userAccount = new UserAccount(1, "Lavinia","Stan", "laviniastn25@gmail.com", "password",role,null);
    }

    @Test
    public void test_getUserAccountId(){
        /**
         * GIVEN
         */

        int expectedId=1;

        /**
         * WHEN
         */
        int actualId=userAccount.getId();

        /**
         * THEN
         */

        assertEquals(expectedId,actualId);
    }

    @Test
    public void test_getUserAccountFirstName(){
        /**
         * GIVEN
         */

        String expectedFirstName="Lavinia";

        /**
         * WHEN
         */

        String actualFirstName= userAccount.getFirstName();


        /**
         * THEN
         */

        assertEquals(expectedFirstName,actualFirstName);
    }

    @Test
    public void test_getUserAccountLastName(){
        /**
         * GIVEN
         */

        String expectedLastName="Lavinia";

        /**
         * WHEN
         */

        String actualLastName= userAccount.getFirstName();


        /**
         * THEN
         */

        assertEquals(expectedLastName,actualLastName);
    }

    @Test
    public void test_getUserAccountEmail(){
        /**
         * GIVEN
         */

        String expectedEmail="laviniastn25@gmail.com";

        /**
         * WHEN
         */

        String actualEmail= userAccount.getEmail();


        /**
         * THEN
         */

        assertEquals(expectedEmail,actualEmail);
    }

    @Test
    public void test_getUserAccountPassword(){
        /**
         * GIVEN
         */

        String expectedPassword="password";

        /**
         * WHEN
         */

        String actualPassword= userAccount.getPassword();

        /**
         * THEN
         */

        assertEquals(expectedPassword,actualPassword);
    }

    @Test
    public void test_getUserAccountRole(){
        /**
         * GIVEN
         */

        Role expectedRole = new Role(1, "role");

        /**
         * WHEN
         */

        Role actualRole = userAccount.getRole();

        /**
         * THEN
         */
        assertEquals(expectedRole.getId(),actualRole.getId());
        assertEquals(expectedRole.getRoleName(),actualRole.getRoleName());
    }

    @Test
    public void test_getUserAccountPhoto(){
        /**
         * GIVEN
         */

        byte[] expectedPhoto=null;

        /**
         * WHEN
         */

        byte[] actualPhoto=userAccount.getPhoto();

        /**
         * THEN
         */

        assertEquals(expectedPhoto,actualPhoto);
    }

}
