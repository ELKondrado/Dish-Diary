package com.example.demo.Recipe;

import java.util.LinkedList;

public class Recipe {
    private long id;
    private String name;
    private LinkedList<String> ingredients;
    private String stepsOfPreparation;

    public Recipe(long id, String name, LinkedList<String> ingredients, String stepsOfPreparation) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.stepsOfPreparation = stepsOfPreparation;
    }

    public Recipe() {
    }

    public Recipe(String name, LinkedList<String> ingredients, String stepsOfPreparation) {
        this.name = name;
        this.ingredients = ingredients;
        this.stepsOfPreparation = stepsOfPreparation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getStepsOfPreparation() {
        return stepsOfPreparation;
    }

    public void setStepsOfPreparation(String stepsOfPreparation) {
        this.stepsOfPreparation = stepsOfPreparation;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", stepsOfPreparation='" + stepsOfPreparation + '\'' +
                '}';
    }
}
