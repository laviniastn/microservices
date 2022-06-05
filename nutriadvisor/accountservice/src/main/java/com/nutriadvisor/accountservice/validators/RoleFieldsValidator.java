package com.nutriadvisor.accountservice.validators;

import com.nutriadvisor.accountservice.dto.RoleDTO;
import errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class RoleFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(RoleFieldsValidator.class);

    public static void validateInsertOrUpdate(RoleDTO roleDTO) {
        List<String> errors = new ArrayList<>();
        if (roleDTO == null) {
            errors.add("roleDTO is null");
            throw new IncorrectParameterException(RoleDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(RoleFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
