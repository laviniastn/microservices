package com.nutriadvisor.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {

    private int id;

    private String roleName;

    public RoleDTO(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

}
