package com.intellimeal.model;

public class Ingredient {
    private String name;
    private double quantity;
    private String unit;
    private int caloriesPerUnit;

    public Ingredient(String name, double quantity, String unit, int caloriesPerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public void addQuantity(double extra) {
        this.quantity += extra;
    }

    @Override
    public String toString() {
        return quantity + " " + unit + " " + name;
    }
}