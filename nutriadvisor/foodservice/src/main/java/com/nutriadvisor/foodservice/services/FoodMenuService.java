package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.dto.builders.FoodMenuBuilder;
import com.nutriadvisor.foodservice.dto.mappers.FoodMenuMapper;
import com.nutriadvisor.foodservice.model.FoodMenu;
import com.nutriadvisor.foodservice.repositories.FoodMenuRepository;
import com.nutriadvisor.foodservice.validators.FoodMenuFieldsValidator;
import errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodMenuService {

    private final FoodMenuRepository foodMenuRepository;

    @Autowired
    public FoodMenuService(FoodMenuRepository foodMenuRepository) {
        this.foodMenuRepository = foodMenuRepository;
    }

    public List<FoodMenuDTO> findAll() {
        List<FoodMenu> foodMenus = foodMenuRepository.findAll();
        return foodMenus.stream().map(foodMenuDTO -> FoodMenuMapper.INSTANCE.fromFoodMenu(foodMenuDTO)).collect(Collectors.toList());
    }

    public Integer insert(FoodMenuDTO foodMenuDTO) {
        FoodMenuFieldsValidator.validateInsertOrUpdate(foodMenuDTO);
        return foodMenuRepository.save(FoodMenuMapper.INSTANCE.toFoodMenu(foodMenuDTO)).getId();
    }

    public Integer update(FoodMenuDTO foodMenuDTO) {
        FoodMenuFieldsValidator.validateInsertOrUpdate(foodMenuDTO);

        FoodMenu foodMenuFromDTO = FoodMenuMapper.INSTANCE.toFoodMenu(foodMenuDTO);
        Optional<FoodMenu> foodMenu = foodMenuRepository.findById(foodMenuDTO.getId());
        if (!foodMenu.isPresent()) {
            throw new ResourceNotFoundException("FoodMenu", "foodMenu id", foodMenuFromDTO.getId());
        }

        return foodMenuRepository.save(FoodMenuMapper.INSTANCE.toFoodMenu(foodMenuDTO)).getId();
    }

    public void delete(Integer id) {
        this.foodMenuRepository.deleteById(id);
    }
}
