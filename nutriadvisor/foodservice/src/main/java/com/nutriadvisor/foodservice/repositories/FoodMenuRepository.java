package com.nutriadvisor.foodservice.repositories;

import com.nutriadvisor.foodservice.model.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {

}
