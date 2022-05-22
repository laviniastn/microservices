package com.nutriadvisor.foodservice.repositories;

import com.nutriadvisor.foodservice.model.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionPlanRepository extends JpaRepository<NutritionPlan, Integer> {

}
