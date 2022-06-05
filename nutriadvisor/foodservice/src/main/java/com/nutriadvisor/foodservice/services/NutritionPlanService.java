package com.nutriadvisor.foodservice.services;

import com.nutriadvisor.foodservice.dto.NutritionPlanDTO;
import com.nutriadvisor.foodservice.dto.builders.NutritionPlanBuilder;
import com.nutriadvisor.foodservice.dto.mappers.FoodMenuMapper;
import com.nutriadvisor.foodservice.dto.mappers.NutritionPlanMapper;
import com.nutriadvisor.foodservice.model.NutritionPlan;
import com.nutriadvisor.foodservice.repositories.NutritionPlanRepository;
import com.nutriadvisor.foodservice.validators.NutritionPlanFieldsValidator;
import errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutritionPlanService {

    private final NutritionPlanRepository nutritionPlanRepository;

    @Autowired
    public NutritionPlanService(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }

    public List<NutritionPlanDTO> findAll() {
        List<NutritionPlan> nutritionPlans = nutritionPlanRepository.findAll();
        return nutritionPlans.stream().map(nutritionPlanDTO -> NutritionPlanMapper.INSTANCE.fromNutritionPlan(nutritionPlanDTO)).collect(Collectors.toList());
    }

    public Integer insert(NutritionPlanDTO nutritionPlanDTO) {
        NutritionPlanFieldsValidator.validateInsertOrUpdate(nutritionPlanDTO);
        return nutritionPlanRepository.save(NutritionPlanMapper.INSTANCE.toNutritionPlan(nutritionPlanDTO)).getId();
    }

    public Integer update(NutritionPlanDTO nutritionPlanDTO) {

        NutritionPlanFieldsValidator.validateInsertOrUpdate(nutritionPlanDTO);

        NutritionPlan nutritionPlanFromDTO = NutritionPlanMapper.INSTANCE.toNutritionPlan(nutritionPlanDTO);

        Optional<NutritionPlan> nutritionPlan = nutritionPlanRepository.findById(nutritionPlanFromDTO.getId());
        if (!nutritionPlan.isPresent()) {
            throw new ResourceNotFoundException("nutritionPlan", "nutritionPlan id", nutritionPlanDTO.getId());
        }

        return nutritionPlanRepository.save(NutritionPlanMapper.INSTANCE.toNutritionPlan(nutritionPlanDTO)).getId();
    }

    public void delete(Integer id) {
        this.nutritionPlanRepository.deleteById(id);
    }
}
