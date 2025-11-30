package com.intellimeal.model;

import java.time.LocalDate;

public class PantryItem {
    private String name;
    private double quantity;
    private String unit;
    private LocalDate expirationDate;

    public PantryItem(String name, double quantity, String unit, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return expirationDate != null && expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " " + unit +
                " (exp: " + expirationDate + ")";
    }
}