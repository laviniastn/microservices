package com.nutriadvisor.foodservice.validators;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(FoodMenuFieldsValidator.class);

    public static void validateInsertOrUpdate(FoodMenuDTO foodMenuDTO) {
        List<String> errors = new ArrayList<>();
        if (foodMenuDTO == null) {
            errors.add("foodMenuDTO is null");
            throw new IncorrectParameterException(FoodMenuDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(FoodMenuFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
