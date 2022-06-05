package com.nutriadvisor.accountservice.dto.mappers;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import com.nutriadvisor.accountservice.model.UserAccount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAccountMapper {

    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

    UserAccount toUserAccount(UserAccountDTO UserAccountDto);

    @InheritInverseConfiguration
    UserAccountDTO fromUserAccount(UserAccount userAccount);
}
