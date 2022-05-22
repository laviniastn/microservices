package com.nutriadvisor.foodservice.repositories;

import com.nutriadvisor.foodservice.model.Receipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceipeRepository extends JpaRepository<Receipe, Integer> {

}
