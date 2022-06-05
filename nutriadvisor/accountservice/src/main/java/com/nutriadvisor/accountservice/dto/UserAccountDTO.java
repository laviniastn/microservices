package com.nutriadvisor.accountservice.dto;


import com.nutriadvisor.accountservice.model.Role;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserAccountDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;

    private byte[] photo;


    public UserAccountDTO(int id, String firstName, String lastName, String email, String password,
                          Role role, byte[] photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role=role;
        this.photo = photo;

    }

}
