package com.intellimeal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recipe {
    private final String id;
    private String title;
    private String instructions;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String title, String instructions) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}