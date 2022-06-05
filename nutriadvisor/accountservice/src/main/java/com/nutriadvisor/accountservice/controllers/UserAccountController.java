package com.nutriadvisor.accountservice.controllers;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.services.UserAccountService;
import hashing.PasswordHash;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/accounts")
public class UserAccountController {

    private static final Logger logger = Logger.getLogger(UserAccountController.class);

    private final UserAccountService userService;

    @Autowired
    public UserAccountController(UserAccountService userService) {

        logger.setLevel(Level.DEBUG);
        this.userService = userService;
    }

    @ApiOperation(value = "Get list of user accounts", response = Iterable.class, tags = "getAllUserAccounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping()
    public List<UserAccountDTO> getAllUserAccounts() {

        logger.debug("Get all user accounts");
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserAccountDTO getUserAccountById(@PathVariable("id") Integer id) {
        logger.debug("Get user account by id");
        return userService.findAll().get(id);
    }

    @PostMapping(value = "/create")
    public Integer createUserAccount(@RequestBody UserAccountDTO userDTO) throws NoSuchAlgorithmException {
        logger.debug("Create user account");
        String passwordEncode = PasswordHash.hashPassword(userDTO.getPassword());
        userDTO.setPassword(passwordEncode);
        return userService.insert(userDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateUserAccount(@RequestBody UserAccountDTO userDTO) {
        logger.debug("Update user account");
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserAccount(@PathVariable("id") Integer id) {
        logger.debug("Delete user account");
        userService.delete(id);
    }

}
