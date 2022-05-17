package com.nutriadvisor.accountservice.services;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.accountservice.model.Role;
import com.nutriadvisor.accountservice.model.UserAccount;
import com.nutriadvisor.accountservice.repositories.UserAccountRepository;
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
public class AccountServiceTest {

    @MockBean
    private UserAccountRepository userAccountRepository;

    @Autowired
    UserAccountService accountService;

    List<UserAccountDTO> personsDTO;

    List<UserAccount> persons;

    UserAccountDTO userAccountDTO;

    UserAccount userAccount;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        accountService = new UserAccountService(userAccountRepository);
        Role role = new Role(1, "role");

        userAccountDTO = new UserAccountDTO(1, "Lavinia", "Stan", "laviniastn25@gmail.com", "password", role, null);
        personsDTO = new ArrayList<>();
        personsDTO.add(userAccountDTO);

        userAccount = new UserAccount(1, "Lavinia", "Stan", "laviniastn25@gmail.com", "password", role, null);
        persons = new ArrayList<>();
        persons.add(userAccount);

    }

    @Test
    public void userAccountService_findAll() {
        /**
         *  GIVEN
         */

        given(userAccountRepository.findAll()).willReturn(persons);

        /**
         *  WHEN
         */

        List<UserAccountDTO> actualPersonsDTO = accountService.findAll();

        /**
         * THEN
         */
        assertEquals(personsDTO.size(), actualPersonsDTO.size());
        assertEquals(personsDTO.get(0).getId(), actualPersonsDTO.get(0).getId());
        assertEquals(personsDTO.get(0).getFirstName(), actualPersonsDTO.get(0).getFirstName());
        assertEquals(personsDTO.get(0).getLastName(), actualPersonsDTO.get(0).getLastName());
        assertEquals(personsDTO.get(0).getEmail(), actualPersonsDTO.get(0).getEmail());
        assertEquals(personsDTO.get(0).getPassword(), actualPersonsDTO.get(0).getPassword());
        assertEquals(personsDTO.get(0).getRole().getId(), actualPersonsDTO.get(0).getRole().getId());
        assertEquals(personsDTO.get(0).getRole().getRoleName(), actualPersonsDTO.get(0).getRole().getRoleName());
        assertEquals(personsDTO.get(0).getPhoto(), actualPersonsDTO.get(0).getPhoto());
    }

    @Test
    public void userAccountService_insert() {
        /**
         *  GIVEN
         */

        given(userAccountRepository.save(any())).willReturn(userAccount);
        int expectedId = userAccount.getId();

        /**
         *  WHEN
         */

        int actualId = accountService.insert(userAccountDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void userAccountService_update() {
        /**
         *  GIVEN
         */

        given(userAccountRepository.findById(any())).willReturn(Optional.ofNullable(userAccount));
        given(userAccountRepository.save(any())).willReturn(userAccount);
        int expectedId = persons.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = accountService.update(userAccountDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void userAccountService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */
        int id = persons.get(0).getId();
        given(userAccountRepository.findById(any())).willThrow(new ResourceNotFoundException("User", "user id", id));
        String expectedMessage = "User not found with user id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                accountService.update(userAccountDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void userAccountService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(userAccountRepository);


        /**
         *  WHEN
         */

        accountService.delete(userAccount.getId());

        /**
         * THEN
         */


        List<UserAccountDTO> actualPersonsDTO = accountService.findAll();
        assertEquals(expectedSize, actualPersonsDTO.size());
    }
}
