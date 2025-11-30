package com.intellimeal.service;

import com.intellimeal.model.GroceryList;
import com.intellimeal.model.GroceryListItem;
import com.intellimeal.model.Ingredient;
import com.intellimeal.model.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryListService {

    public GroceryList buildFromRecipes(List<Recipe> recipes) {
        GroceryList list = new GroceryList();

        // key: name+unit -> item
        Map<String, GroceryListItem> map = new HashMap<>();

        for (Recipe r : recipes) {
            for (Ingredient ing : r.getIngredients()) {
                String key = ing.getName().toLowerCase() + "|" + ing.getUnit().toLowerCase();
                GroceryListItem existing = map.get(key);
                if (existing == null) {
                    existing = new GroceryListItem(
                            ing.getName(), ing.getQuantity(), ing.getUnit());
                    map.put(key, existing);
                } else {
                    existing.addQuantity(ing.getQuantity());
                }
            }
        }

        for (GroceryListItem item : map.values()) {
            list.addItem(item);
        }

        return list;
    }
}