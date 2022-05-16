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
        logger.setLevel(Level.DEBUG);
        this.roleService = roleService;
    }

    @GetMapping()
    public List<RoleDTO> getAllRoles() {

        logger.debug("Get all roles");
        return roleService.findAll();
    }

    @GetMapping(value = "/{id}")
    public RoleDTO getRoleById(@PathVariable("id") Integer id) {
        logger.debug("Get  role by id");
        return roleService.findAll().get(id - 1);
    }

    @PostMapping(value = "/create")
    public Integer createRole(@RequestBody RoleDTO roleDTO) {
        logger.debug("Create role");
        return roleService.insert(roleDTO);
    }

    @PutMapping(value = "/update")
    public Integer updateRole(@RequestBody RoleDTO roleDTO) {
        logger.debug("Update role");
        return roleService.update(roleDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteRoleById(@PathVariable("id") Integer id) {
        logger.debug("Delete role");
        roleService.delete(id);
    }

}
