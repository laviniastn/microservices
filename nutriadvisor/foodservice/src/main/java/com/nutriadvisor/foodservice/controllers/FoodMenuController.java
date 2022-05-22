package com.nutriadvisor.foodservice.controllers;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.services.FoodMenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/foodmenus")
public class FoodMenuController {

    private static final Logger logger = Logger.getLogger(FoodMenuController.class);

    private final FoodMenuService userService;

    @Autowired
    public FoodMenuController(FoodMenuService userService) {

        logger.setLevel(Level.DEBUG);
        this.userService = userService;
    }

    @ApiOperation(value = "Get list of food menus", response = Iterable.class, tags = "getAllFoodMenus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping()
    public List<FoodMenuDTO> getAllFoodMenus() {

        logger.debug("Get all food menus");
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public FoodMenuDTO getFoodMenuById(@PathVariable("id") Integer id) {
        logger.debug("Get food menu by id");
        return userService.findAll().get(id - 1);
    }

    @PostMapping(value = "/create")
    public Integer createFoodMenu(@RequestBody FoodMenuDTO userDTO) {
        logger.debug("Create food menu");
        return userService.insert(userDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateFoodMenu(@RequestBody FoodMenuDTO userDTO) {
        logger.debug("Update food menu");
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFoodMenu(@PathVariable("id") Integer id) {
        logger.debug("Delete food menu");
        userService.delete(id);
    }

}
