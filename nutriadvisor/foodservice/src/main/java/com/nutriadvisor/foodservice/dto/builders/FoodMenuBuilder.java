package com.nutriadvisor.foodservice.dto.builders;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.model.FoodMenu;

public class FoodMenuBuilder {

    public FoodMenuBuilder() {
    }

    public static FoodMenuDTO generateDTOFromEntity(FoodMenu foodMenu){
        return new FoodMenuDTO(
                foodMenu.getId(),
                foodMenu.getDayNr(),
                foodMenu.getKcals()
        );

    }

    public static FoodMenu generateEntityFromDTO(FoodMenuDTO foodMenuDTO){
        return new FoodMenu(
                foodMenuDTO.getId(),
                foodMenuDTO.getDayNr(),
                foodMenuDTO.getKcals()
        );
    }

}
