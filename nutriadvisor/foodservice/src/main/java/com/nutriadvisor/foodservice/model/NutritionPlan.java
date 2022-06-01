package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nutrition_plan")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NutritionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "nr_of_days", nullable = true)
    private int nrOfDays;

    @OneToMany(mappedBy="nutritionPlan")
    private List<FoodMenu> foodMenus;

    public NutritionPlan(){

    }

    public NutritionPlan(int id, int nrOfDays){
        this.id=id;
        this.nrOfDays=nrOfDays;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }

}