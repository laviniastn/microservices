package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "food_menu")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "day_nr", nullable = true)
    private int dayNr;

    @Column(name = "kcals", nullable = true)
    private float kcals;

    @OneToMany(mappedBy="foodMenu")
    private List<Receipe> receipes;

    @ManyToOne
    @JoinColumn(name="nutrition_plan_id", nullable=false)
    private NutritionPlan nutritionPlan;

    public FoodMenu(){

    }

    public FoodMenu(int id, int dayNr, float kcals){
        this.id=id;
        this.dayNr=dayNr;
        this.kcals=kcals;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayNr() {
        return dayNr;
    }

    public void setDayNr(int dayNr) {
        this.dayNr = dayNr;
    }

    public float getKcals() {
        return kcals;
    }

    public void setKcals(float kcals) {
        this.kcals = kcals;
    }
}
