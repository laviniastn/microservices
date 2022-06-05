package com.nutriadvisor.accountservice.validators;

import com.nutriadvisor.accountservice.dto.UserAccountDTO;
import errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class UserFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(UserFieldsValidator.class);

    public static void validateInsertOrUpdate(UserAccountDTO userAccountDTO) {
        List<String> errors = new ArrayList<>();
        if (userAccountDTO == null) {
            errors.add("userAccountDTO is null");
            throw new IncorrectParameterException(UserAccountDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(UserFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
