package com.intellimeal.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroceryList {
    private final String id;
    private LocalDateTime createdAt;
    private List<GroceryListItem> items = new ArrayList<>();

    public GroceryList() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public List<GroceryListItem> getItems() {
        return items;
    }

    public void addItem(GroceryListItem item) {
        items.add(item);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Grocery List (" + createdAt + ")\n");
        for (GroceryListItem i : items) {
            sb.append(" - ").append(i.toString()).append("\n");
        }
        return sb.toString();
    }
}