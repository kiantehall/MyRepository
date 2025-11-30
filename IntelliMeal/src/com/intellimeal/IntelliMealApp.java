package com.intellimeal;

import com.intellimeal.model.GroceryList;
import com.intellimeal.model.PantryItem;
import com.intellimeal.model.Recipe;
import com.intellimeal.service.GroceryListService;
import com.intellimeal.service.PantryService;
import com.intellimeal.service.RecipeService;
import com.intellimeal.service.SyncService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntelliMealApp {

    private final DataStore dataStore = new DataStore();
    private final RecipeService recipeService =
            new RecipeService(dataStore.getRecipes());
    private final PantryService pantryService =
            new PantryService(dataStore.getPantryItems());
    private final GroceryListService groceryListService =
            new GroceryListService();
    private final SyncService syncService = new SyncService();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IntelliMealApp app = new IntelliMealApp();
        app.seedSampleData();
        app.runMenu();
    }

    private void seedSampleData() {
        // Optionally pre-load a couple of recipes for demo/testing
        Recipe r = recipeService.createRecipe(
                "Chicken Alfredo",
                "Boil pasta, cook chicken, add sauce, mix.");
        recipeService.addIngredientToRecipe(r, "Chicken breast", 1, "lb", 200);
        recipeService.addIngredientToRecipe(r, "Pasta", 8, "oz", 100);
        recipeService.addIngredientToRecipe(r, "Alfredo sauce", 1, "jar", 150);
    }

    private void runMenu() {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> addRecipe();
                case 2 -> listRecipes();
                case 3 -> generateGroceryList();
                case 4 -> updatePantry();
                case 5 -> listPantry();
                case 6 -> searchByIngredient();
                case 7 -> toggleOfflineMode();
                case 8 -> syncService.syncNow(dataStore.getRecipes());
                case 0 -> System.out.println("Exiting IntelliMeal. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== IntelliMeal Main Menu ===");
        System.out.println("1. Add Recipe");
        System.out.println("2. List Recipes");
        System.out.println("3. Generate Grocery List from Recipes");
        System.out.println("4. Add/Update Pantry Item");
        System.out.println("5. View Pantry");
        System.out.println("6. Search Recipes by Ingredient");
        System.out.println("7. Toggle Offline Mode (current: "
                + (syncService.isOfflineMode() ? "OFFLINE" : "ONLINE") + ")");
        System.out.println("8. Sync Now");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void addRecipe() {
        System.out.println("\n=== Add Recipe ===");
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title is required.");
            return;
        }

        System.out.print("Instructions: ");
        String instructions = scanner.nextLine().trim();
        if (instructions.isEmpty()) {
            System.out.println("Instructions are required.");
            return;
        }

        Recipe recipe = recipeService.createRecipe(title, instructions);

        boolean addMore = true;
        while (addMore) {
            System.out.print("Ingredient name (or blank to finish): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) break;

            System.out.print("Quantity: ");
            double qty;
            try {
                qty = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid quantity. Skipping ingredient.");
                continue;
            }

            if (qty <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }

            System.out.print("Unit (e.g., oz, lb, cup): ");
            String unit = scanner.nextLine().trim();
            if (unit.isEmpty()) {
                System.out.println("Unit is required.");
                continue;
            }

            System.out.print("Calories per unit (integer): ");
            int calories;
            try {
                calories = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid calories. Using 0.");
                calories = 0;
            }

            recipeService.addIngredientToRecipe(recipe, name, qty, unit, calories);
        }

        syncService.recordRecipeCreated(recipe);
        System.out.println("Recipe added: " + recipe.getTitle());
    }

    private void listRecipes() {
        System.out.println("\n=== Recipes ===");
        List<Recipe> recipes = recipeService.getAllRecipes();
        if (recipes.isEmpty()) {
            System.out.println("No recipes yet.");
            return;
        }
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            System.out.println((i + 1) + ". " + r.getTitle()
                    + " (" + r.getIngredients().size() + " ingredients)");
        }
    }

    private void generateGroceryList() {
        System.out.println("\n=== Generate Grocery List ===");
        List<Recipe> recipes = recipeService.getAllRecipes();
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        System.out.println("Select recipes by number (comma separated), e.g., 1,2");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i).getTitle());
        }
        System.out.print("Your selection: ");
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        List<Recipe> selected = new ArrayList<>();
        for (String p : parts) {
            try {
                int idx = Integer.parseInt(p.trim()) - 1;
                Recipe r = recipeService.getRecipeByIndex(idx);
                if (r != null) {
                    selected.add(r);
                }
            } catch (NumberFormatException ignored) {
            }
        }

        if (selected.isEmpty()) {
            System.out.println("No valid recipes selected.");
            return;
        }

        GroceryList list = groceryListService.buildFromRecipes(selected);
        System.out.println(list);
    }

    private void updatePantry() {
        System.out.println("\n=== Add/Update Pantry Item ===");
        System.out.print("Item name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name is required.");
            return;
        }

        System.out.print("Quantity: ");
        double qty;
        try {
            qty = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid quantity.");
            return;
        }
        if (qty < 0) {
            System.out.println("Quantity must be non-negative.");
            return;
        }

        System.out.print("Unit (e.g., oz, lb, cup): ");
        String unit = scanner.nextLine().trim();
        if (unit.isEmpty()) {
            System.out.println("Unit is required.");
            return;
        }

        System.out.print("Expiration date (YYYY-MM-DD or blank for none): ");
        String dateStr = scanner.nextLine().trim();
        LocalDate date = null;
        if (!dateStr.isEmpty()) {
            try {
                date = LocalDate.parse(dateStr);
            } catch (Exception ex) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
                return;
            }
        }

        PantryItem item = pantryService.addOrUpdateItem(name, qty, unit, date);
        System.out.println("Pantry updated: " + item);
    }

    private void listPantry() {
        System.out.println("\n=== Pantry Items ===");
        List<PantryItem> items = pantryService.getAllItems();
        if (items.isEmpty()) {
            System.out.println("Pantry is empty.");
            return;
        }
        for (PantryItem item : items) {
            System.out.println(" - " + item + (item.isExpired() ? " [EXPIRED]" : ""));
        }

        List<PantryItem> expired = pantryService.getExpiredItems();
        if (!expired.isEmpty()) {
            System.out.println("\nExpired items:");
            for (PantryItem item : expired) {
                System.out.println(" * " + item.getName());
            }
        }
    }

    private void searchByIngredient() {
        System.out.println("\n=== Search Recipes by Ingredient ===");
        System.out.print("Ingredient name: ");
        String term = scanner.nextLine().trim();
        if (term.isEmpty()) {
            System.out.println("Search term is required.");
            return;
        }
        List<Recipe> result = recipeService.searchByIngredient(term);
        if (result.isEmpty()) {
            System.out.println("No recipes found containing '" + term + "'.");
        } else {
            System.out.println("Found recipes:");
            for (Recipe r : result) {
                System.out.println(" - " + r.getTitle());
            }
        }
    }

    private void toggleOfflineMode() {
        boolean newMode = !syncService.isOfflineMode();
        syncService.setOfflineMode(newMode);
        System.out.println("Offline mode is now: "
                + (newMode ? "ON - operations will sync later" : "OFF - operations sync immediately"));
    }
}