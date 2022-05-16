package com.nutriadvisor.accountservice.controllers;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.services.UserAccountService;
import io.swagger.annotations.Api;
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
@RequestMapping(value = "/accounts")
public class UserAccountController {

    private static final Logger logger = Logger.getLogger(UserAccountController.class);


    private final UserAccountService userService;

    @Autowired
    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get list of user accounts", response = Iterable.class, tags = "getAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!") })
    @GetMapping()
    public List<UserAccountDTO> getAll(){
        logger.setLevel(Level.DEBUG);
        logger.debug("Get all users");
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserAccountDTO findById(@PathVariable("id") Integer id){
        return userService.findAll().get(id-1);
    }

    @PostMapping(value="/create")
    public Integer insertUserDTO(@RequestBody UserAccountDTO userDTO){
        return userService.insert(userDTO);
    }

    @PutMapping(value="/update")
    public Integer updateUser(@RequestBody UserAccountDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }

}
