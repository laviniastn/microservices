package com.nutriadvisor.foodservice.dto.builders;

import com.nutriadvisor.foodservice.dto.ReceipeDTO;
import com.nutriadvisor.foodservice.model.Receipe;

public class ReceipeBuilder {

    public ReceipeBuilder() {
    }

    public static ReceipeDTO generateDTOFromEntity(Receipe receipe){
        return new ReceipeDTO(
                receipe.getId(),
                receipe.getReceipeName(),
                receipe.getIngredients(),
                receipe.getCategory(),
                receipe.getKcals(),
                receipe.getPhoto()
                );
    }

    public static Receipe generateEntityFromDTO(ReceipeDTO receipeDTO){
        return new Receipe(
                receipeDTO.getId(),
                receipeDTO.getReceipeName(),
                receipeDTO.getIngredients(),
                receipeDTO.getCategory(),
                receipeDTO.getKcals(),
                receipeDTO.getPhoto()
                );
    }

}
