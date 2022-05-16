package com.nutriadvisor.accountservice.controllers;

import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.services.RoleService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private static final Logger logger = Logger.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<RoleDTO> getAll(){
        logger.setLevel(Level.DEBUG);
        logger.debug("Get all roles");
        return roleService.findAll();
    }

    @GetMapping(value = "/{id}")
    public RoleDTO findById(@PathVariable("id") Integer id){
        return roleService.findAll().get(id-1);
    }

    @PostMapping(value="/create")
    public Integer insertUserDTO(@RequestBody RoleDTO roleDTO){
        return roleService.insert(roleDTO);
    }

    @PutMapping(value="/update")
    public Integer updateUser(@RequestBody RoleDTO roleDTO) {
        return roleService.update(roleDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        roleService.delete(id);
    }

}
