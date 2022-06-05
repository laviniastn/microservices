package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "food_menu")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
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
    private List<Recipe> receipes;

    @ManyToOne
    @JoinColumn(name="nutrition_plan_id", nullable=false)
    private NutritionPlan nutritionPlan;

    public FoodMenu(int id, int dayNr, float kcals){
        this.id=id;
        this.dayNr=dayNr;
        this.kcals=kcals;

    }

}
