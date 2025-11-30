package com.intellimeal;

import com.intellimeal.model.PantryItem;
import com.intellimeal.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private List<Recipe> recipes = new ArrayList<>();
    private List<PantryItem> pantryItems = new ArrayList<>();

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<PantryItem> getPantryItems() {
        return pantryItems;
    }
}