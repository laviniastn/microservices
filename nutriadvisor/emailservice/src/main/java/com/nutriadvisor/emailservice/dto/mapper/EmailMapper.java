package com.nutriadvisor.emailservice.dto.mapper;

import com.nutriadvisor.emailservice.dto.EmailDTO;
import com.nutriadvisor.emailservice.model.Email;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { EmailMapper.class })
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

     Email toEmail(EmailDTO emailDto);

    @InheritInverseConfiguration
     EmailDTO fromEmail(Email email);
}
