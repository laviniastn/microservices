package com.nutriadvisor.foodservice.validators;

import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class ReceipeFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(ReceipeFieldsValidator.class);

    public static void validateInsertOrUpdate(ReceipeDTO userAccountDTO) {
        List<String> errors = new ArrayList<>();
        if (userAccountDTO == null) {
            errors.add("ReceipeDTO is null");
            throw new IncorrectParameterException(ReceipeDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(ReceipeFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
