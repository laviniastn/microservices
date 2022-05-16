package com.nutriadvisor.accountservice.dto.builders;


import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.model.UserAccount;

public class UserAccountBuilder {

    public UserAccountBuilder() {
    }

    public static UserAccountDTO generateDTOFromEntity(UserAccount user){
        return new UserAccountDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getPhoto());

    }

    public static UserAccount generateEntityFromDTO(UserAccountDTO userDTO){
        return new UserAccount(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getPhoto());
    }

}
