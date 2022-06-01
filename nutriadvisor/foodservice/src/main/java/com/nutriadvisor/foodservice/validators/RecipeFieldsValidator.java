package com.nutriadvisor.foodservice.validators;

import com.nutriadvisor.foodservice.dto.RecipeDTO;
import com.nutriadvisor.foodservice.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class RecipeFieldsValidator {

    private static final Log LOGGER = LogFactory.getLog(RecipeFieldsValidator.class);

    public static void validateInsertOrUpdate(RecipeDTO recipeDTO) {
        List<String> errors = new ArrayList<>();
        if (recipeDTO == null) {
            errors.add("RecipeDTO is null");
            throw new IncorrectParameterException(RecipeDTO.class.getSimpleName(), errors);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(RecipeFieldsValidator.class.getSimpleName(), errors);
        }
    }
}
