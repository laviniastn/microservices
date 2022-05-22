package com.nutriadvisor.foodservice.validators;

import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class NutritionPlanFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(NutritionPlanFieldsValidator.class);

    public static void validateInsertOrUpdate(NutritionPlanDTO nutritionPlanDTO) {
        List<String> errors = new ArrayList<>();
        if (nutritionPlanDTO == null) {
            errors.add("nutritionPlanDTO is null");
            throw new IncorrectParameterException(NutritionPlanDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(NutritionPlanFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
