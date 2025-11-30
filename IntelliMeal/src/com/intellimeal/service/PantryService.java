package com.intellimeal.service;

import com.intellimeal.model.PantryItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PantryService {

    private final List<PantryItem> pantryItems;

    public PantryService(List<PantryItem> pantryItems) {
        this.pantryItems = pantryItems;
    }

    public PantryItem addOrUpdateItem(String name, double quantity, String unit,
                                      LocalDate expiration) {
        for (PantryItem item : pantryItems) {
            if (item.getName().equalsIgnoreCase(name)
                    && item.getUnit().equalsIgnoreCase(unit)) {
                item.setQuantity(quantity);
                return item;
            }
        }
        PantryItem newItem = new PantryItem(name, quantity, unit, expiration);
        pantryItems.add(newItem);
        return newItem;
    }

    public List<PantryItem> getAllItems() {
        return new ArrayList<>(pantryItems);
    }

    public List<PantryItem> getExpiredItems() {
        List<PantryItem> result = new ArrayList<>();
        for (PantryItem item : pantryItems) {
            if (item.isExpired()) {
                result.add(item);
            }
        }
        return result;
    }
}