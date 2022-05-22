package com.nutriadvisor.foodservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "receipes")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Receipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "receipe_name", nullable = true)
    private String receipeName;

    @Column(name = "ingredients", nullable = true)
    private String ingredients;

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name = "kcals", nullable = true)
    private String kcals;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name="food_menu_id", nullable=false)
    private FoodMenu foodMenu;

    public Receipe() {

    }

    public Receipe(int id, String receipeName, String ingredients, String category,String kcals, byte[] photo) {
        this.id = id;
        this.receipeName = receipeName;
        this.ingredients = ingredients;
        this.category = category;
        this.kcals=kcals;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceipeName() {
        return receipeName;
    }

    public void setReceipeName(String receipeName) {
        this.receipeName = receipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKcals() {
        return kcals;
    }

    public void setKcals(String kcals) {
        this.kcals = kcals;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
