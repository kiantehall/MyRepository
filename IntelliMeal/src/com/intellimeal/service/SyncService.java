package com.intellimeal.service;

import com.intellimeal.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class SyncService {

    private boolean offlineMode = false;
    private List<String> pendingOperations = new ArrayList<>();

    public boolean isOfflineMode() {
        return offlineMode;
    }

    public void setOfflineMode(boolean offlineMode) {
        this.offlineMode = offlineMode;
    }

    public void recordRecipeCreated(Recipe recipe) {
        if (offlineMode) {
            pendingOperations.add("CREATE_RECIPE:" + recipe.getId());
        } else {
            // in a real system we would sync to a server here
            System.out.println("Synced recipe to server: " + recipe.getTitle());
        }
    }

    public void syncNow(List<Recipe> recipes) {
        System.out.println("=== Syncing pending operations ===");
        for (String op : pendingOperations) {
            System.out.println("Processed: " + op);
            // here we would apply operations against a remote API/database
        }
        pendingOperations.clear();
        System.out.println("Sync complete. Pending operations: " +
                pendingOperations.size());
    }
}