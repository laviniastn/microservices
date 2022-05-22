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
    private String dayNr;

    @Column(name = "kcals", nullable = true)
    private String kcals;

    @OneToMany(mappedBy="foodMenu")
    private List<Receipe> receipes;

    @ManyToOne
    @JoinColumn(name="nutrition_plan_id", nullable=false)
    private NutritionPlan nutritionPlan;

    public FoodMenu(){

    }

    public FoodMenu(int id, String dayNr, String kcals){
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

    public String getDayNr() {
        return dayNr;
    }

    public void setDayNr(String dayNr) {
        this.dayNr = dayNr;
    }

    public String getKcals() {
        return kcals;
    }

    public void setKcals(String kcals) {
        this.kcals = kcals;
    }
}
