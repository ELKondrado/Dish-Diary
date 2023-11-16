package com.example.demo.Ingredient;


public class Ingredient {
    private String name;
    private double quantity;

    public Ingredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }
}








