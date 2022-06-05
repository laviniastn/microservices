package com.nutriadvisor.accountservice.services;


import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.dto.mappers.RoleMapper;
import com.nutriadvisor.accountservice.model.Role;
import com.nutriadvisor.accountservice.repositories.RoleRepository;
import com.nutriadvisor.accountservice.validators.RoleFieldsValidator;
import errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService implements Serializable {

    private final RoleRepository roleRepository;
    RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository userRepository) {
        this.roleRepository = userRepository;
    }

    public List<RoleDTO> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleDTO -> RoleMapper.INSTANCE.fromRole(roleDTO)).collect(Collectors.toList());
    }

    public Integer insert(RoleDTO roleDTO) {
        RoleFieldsValidator.validateInsertOrUpdate(roleDTO);
        return roleRepository.save(RoleMapper.INSTANCE.toRole(roleDTO)).getId();
    }

    public Integer update(RoleDTO roleDTO) {

        RoleFieldsValidator.validateInsertOrUpdate(roleDTO);

        Role roleFromDTO = RoleMapper.INSTANCE.toRole(roleDTO);
        Optional<Role> role = roleRepository.findById(roleFromDTO.getId());
        if (!role.isPresent()) {
            throw new ResourceNotFoundException("Role", "role id", roleFromDTO.getId());
        }

        return roleRepository.save(RoleMapper.INSTANCE.toRole(roleDTO)).getId();
    }

    public void delete(Integer id) {
        this.roleRepository.deleteById(id);
    }
}
