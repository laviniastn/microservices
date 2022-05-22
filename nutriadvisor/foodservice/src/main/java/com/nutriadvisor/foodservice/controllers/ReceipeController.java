package com.nutriadvisor.foodservice.controllers;

import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.services.ReceipeService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/receipes")
public class ReceipeController {

    private static final Logger logger = Logger.getLogger(ReceipeController.class);

    private final ReceipeService receipeService;

    @Autowired
    public ReceipeController(ReceipeService receipeService) {
        logger.setLevel(Level.DEBUG);
        this.receipeService = receipeService;
    }

    @GetMapping()
    public List<ReceipeDTO> getAllReceipes() {

        logger.debug("Get all receipes");
        return receipeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ReceipeDTO getRoleById(@PathVariable("id") Integer id) {
        logger.debug("Get  receipe by id");
        return receipeService.findAll().get(id - 1);
    }

    @PostMapping(value = "/create")
    public Integer createReceipe(@RequestBody ReceipeDTO receipeDTO) {
        logger.debug("Create receipe");
        return receipeService.insert(receipeDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateReceipe(@RequestBody ReceipeDTO receipeDTO) {
        logger.debug("Update receipe");
        return receipeService.update(receipeDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteReceipeById(@PathVariable("id") Integer id) {
        logger.debug("Delete receipe");
        receipeService.delete(id);
    }

}
