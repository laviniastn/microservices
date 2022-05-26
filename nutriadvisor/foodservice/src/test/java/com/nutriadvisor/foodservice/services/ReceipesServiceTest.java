package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.Receipe;
import com.nutriadvisor.foodservice.repositories.ReceipeRepository;
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
public class ReceipesServiceTest {

    @MockBean
    private ReceipeRepository receipeRepository;

    @Autowired
    ReceipeService receipeService;

    List<ReceipeDTO> receipesDTO;

    List<Receipe> receipes;

    ReceipeDTO receipeDTO;

    Receipe receipe;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        receipeService = new ReceipeService(receipeRepository);
        Receipe role = new Receipe(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);

        receipeDTO = new ReceipeDTO(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        receipesDTO = new ArrayList<>();
        receipesDTO.add(receipeDTO);

        receipe = new Receipe(1, "name", "eggs", "breakfast", 10.5f, new byte[1]);
        receipes = new ArrayList<>();
        receipes.add(receipe);

    }

    @Test
    public void receipeService_findAll() {
        /**
         *  GIVEN
         */

        given(receipeRepository.findAll()).willReturn(receipes);

        /**
         *  WHEN
         */

        List<ReceipeDTO> actualreceipesDTO = receipeService.findAll();

        /**
         * THEN
         */
        assertEquals(receipesDTO.size(), actualreceipesDTO.size());
        assertEquals(receipesDTO.get(0).getId(), actualreceipesDTO.get(0).getId());

    }

    @Test
    public void receipeService_insert() {
        /**
         *  GIVEN
         */

        given(receipeRepository.save(any())).willReturn(receipe);
        int expectedId = receipe.getId();

        /**
         *  WHEN
         */

        int actualId = receipeService.insert(receipeDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void receipeService_update() {
        /**
         *  GIVEN
         */

        given(receipeRepository.findById(any())).willReturn(Optional.ofNullable(receipe));
        given(receipeRepository.save(any())).willReturn(receipe);
        int expectedId = receipes.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = receipeService.update(receipeDTO);

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void receipeService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */
        given(receipeRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "Receipe not found with receipe id : '1'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                receipeService.update(receipeDTO));
        String actualMessage = exception.getMessage();

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void receipeService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(receipeRepository);


        /**
         *  WHEN
         */

        receipeService.delete(receipe.getId());

        /**
         * THEN
         */


        List<ReceipeDTO> actualreceipesDTO = receipeService.findAll();
        assertEquals(expectedSize, actualreceipesDTO.size());
    }
}
