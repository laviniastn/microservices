package com.nutriadvisor.foodservice.controllers;

import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.services.NutritionPlanService;
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
@RequestMapping(value = "/nutritionplans")
public class NutritionPlanController {

    private static final Logger logger = Logger.getLogger(NutritionPlanController.class);

    private final NutritionPlanService nutritionPlanService;

    @Autowired
    public NutritionPlanController(NutritionPlanService nutritionPlanService) {

        logger.setLevel(Level.DEBUG);
        this.nutritionPlanService = nutritionPlanService;
    }

    @ApiOperation(value = "Get list of nutrition plan", response = Iterable.class, tags = "getAllNutritionPlans")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping()
    public List<NutritionPlanDTO> getAllNutritionPlans() {

        logger.debug("Get all nutrition plans");
        return nutritionPlanService.findAll();
    }

    @GetMapping(value = "/{id}")
    public NutritionPlanDTO getNutritionPlanById(@PathVariable("id") Integer id) {
        logger.debug("Get nutrition plan by id");
        return nutritionPlanService.findAll().get(id);
    }

    @PostMapping(value = "/create")
    public Integer createNutritionPlan(@RequestBody NutritionPlanDTO nutritionPlanDTO) {
        logger.debug("Create nutrition plan");
        return nutritionPlanService.insert(nutritionPlanDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateNutritionPlan(@RequestBody NutritionPlanDTO nutritionPlanDTO) {
        logger.debug("Update nutrition plan");
        return nutritionPlanService.update(nutritionPlanDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteNutritionPlan(@PathVariable("id") Integer id) {
        logger.debug("Delete nutrition plan");
        nutritionPlanService.delete(id);
    }

}
