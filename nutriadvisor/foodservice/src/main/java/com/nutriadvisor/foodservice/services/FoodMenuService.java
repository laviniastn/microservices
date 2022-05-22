package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.FoodMenuDTO;
import com.nutriadvisor.foodservice.dto.builders.FoodMenuBuilder;
import com.nutriadvisor.foodservice.errorhandler.ResourceNotFoundException;
import com.nutriadvisor.foodservice.model.FoodMenu;
import com.nutriadvisor.foodservice.repositories.FoodMenuRepository;
import com.nutriadvisor.foodservice.validators.FoodMenuFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodMenuService {

    private final FoodMenuRepository userRepository;

    @Autowired
    public FoodMenuService(FoodMenuRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<FoodMenuDTO> findAll() {
        List<FoodMenu> persons = userRepository.findAll();
        return persons.stream().map(FoodMenuBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }

    public Integer insert(FoodMenuDTO userDTO) {
        FoodMenuFieldsValidator.validateInsertOrUpdate(userDTO);
        return userRepository.save(FoodMenuBuilder.generateEntityFromDTO(userDTO)).getId();
    }

    public Integer update(FoodMenuDTO userDTO) {
        Optional<FoodMenu> user = userRepository.findById(userDTO.getId());
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("FoodMenu", "foodMenu id", userDTO.getId());
        }

        FoodMenuFieldsValidator.validateInsertOrUpdate(userDTO);

        return userRepository.save(FoodMenuBuilder.generateEntityFromDTO(userDTO)).getId();
    }

    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }
}
