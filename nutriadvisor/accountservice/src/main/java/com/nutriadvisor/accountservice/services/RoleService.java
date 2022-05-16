package com.nutriadvisor.accountservice.services;


import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.dto.builders.RoleBuilder;
import com.nutriadvisor.accountservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.accountservice.model.Role;
import com.nutriadvisor.accountservice.repositories.RoleRepository;
import com.nutriadvisor.accountservice.validators.RoleFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository userRepository) {
        this.roleRepository = userRepository;
    }

    public List<RoleDTO> findAll() {
        List<Role> persons = roleRepository.findAll();
        return persons.stream().map(RoleBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }

    public Integer insert(RoleDTO roleDTO) {
        RoleFieldsValidator.validateInsertOrUpdate(roleDTO);
        return roleRepository.save(RoleBuilder.generateEntityFromDTO(roleDTO)).getId();
    }

    public Integer update(RoleDTO roleDTO) {
        Optional<Role> user = roleRepository.findById(roleDTO.getId());
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("Role", "role id", roleDTO.getId());
        }

        RoleFieldsValidator.validateInsertOrUpdate(roleDTO);

        return roleRepository.save(RoleBuilder.generateEntityFromDTO(roleDTO)).getId();
    }

    public void delete(Integer id) {
        this.roleRepository.deleteById(id);
    }
}
