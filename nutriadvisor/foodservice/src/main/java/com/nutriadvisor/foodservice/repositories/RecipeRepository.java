package com.nutriadvisor.foodservice.repositories;

import com.nutriadvisor.foodservice.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
