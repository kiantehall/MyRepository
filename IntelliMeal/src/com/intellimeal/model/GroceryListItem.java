package com.intellimeal.model;

public class GroceryListItem {
    private String name;
    private double quantity;
    private String unit;
    private boolean checked;

    public GroceryListItem(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
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

    public boolean isChecked() {
        return checked;
    }

    public void toggleChecked() {
        this.checked = !this.checked;
    }

    public void addQuantity(double extra) {
        this.quantity += extra;
    }

    @Override
    public String toString() {
        return (checked ? "[x] " : "[ ] ") + quantity + " " + unit + " " + name;
    }
}