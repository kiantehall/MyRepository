package com.intellimeal.service;

import com.intellimeal.model.Ingredient;
import com.intellimeal.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    private final List<Recipe> recipes;

    public RecipeService(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe createRecipe(String title, String instructions) {
        Recipe recipe = new Recipe(title, instructions);
        recipes.add(recipe);
        return recipe;
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
    }

    public List<Recipe> searchByIngredient(String ingredientName) {
        String term = ingredientName.toLowerCase();
        return recipes.stream()
                .filter(r -> r.getIngredients().stream()
                        .anyMatch(i -> i.getName().toLowerCase().contains(term)))
                .collect(Collectors.toList());
    }

    public Recipe getRecipeByIndex(int index) {
        if (index < 0 || index >= recipes.size()) {
            return null;
        }
        return recipes.get(index);
    }

    public void addIngredientToRecipe(Recipe recipe, String name, double qty,
                                      String unit, int caloriesPerUnit) {
        Ingredient ingredient = new Ingredient(name, qty, unit, caloriesPerUnit);
        recipe.addIngredient(ingredient);
    }
}