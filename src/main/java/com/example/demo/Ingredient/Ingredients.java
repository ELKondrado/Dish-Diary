package com.example.demo.Ingredient;


import java.util.LinkedList;

public class Ingredients {
    private String name;
    private double quantity;

    public Ingredients( String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredients() {

    }

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








