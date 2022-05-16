package com.nutriadvisor.accountservice.dto.builders;

import com.nutriadvisor.accountservice.dto.RoleDTO;
import com.nutriadvisor.accountservice.model.Role;

public class RoleBuilder {

    public RoleBuilder() {
    }

    public static RoleDTO generateDTOFromEntity(Role role){
        return new RoleDTO(
                role.getId(),
                role.getRoleName()
                );
    }

    public static Role generateEntityFromDTO(RoleDTO roleDTO){
        return new Role(
                roleDTO.getId(),
                roleDTO.getRoleName()
                );
    }

}
