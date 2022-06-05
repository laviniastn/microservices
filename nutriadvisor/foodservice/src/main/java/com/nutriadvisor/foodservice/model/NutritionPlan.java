package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nutrition_plan")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class NutritionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "nr_of_days", nullable = true)
    private int nrOfDays;

    @OneToMany(mappedBy="nutritionPlan")
    private List<FoodMenu> foodMenus;

    public NutritionPlan(int id, int nrOfDays){
        this.id=id;
        this.nrOfDays=nrOfDays;

    }

}
