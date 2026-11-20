package com.chicken.foodtruck;

import com.chicken.foodtruck.model.InMemoryItemRepository;
import com.chicken.foodtruck.model.Item;
import com.chicken.foodtruck.model.ItemRepository;

/**
 * Main.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of the main
 */
public class Main {

    public static void main(String[] args) {
        ItemRepository repository = new InMemoryItemRepository();


        Item wings = repository.save(
                new Item(0, "Chicken Wings", "Buffalo Chicken Wings", 12.00, false)
        );

        Item sandwich = repository.save(
                new Item(0, "Chicken Sandwich", "Spicy Chicken Sandwich", 9.00, false)
        );

        Item breast = repository.save(
                new Item(0, "Chicken Breast", "Plant-Based Chicken Breast", 6.00, true)
        );

        System.out.println("Created: " + wings);
        System.out.println("Created: " + sandwich);
        System.out.println("Created: " + breast);

        System.out.println();

        for (Item item : repository.findAll()) {
            System.out.println(item);
        }

        System.out.println();

        sandwich.setPrice(10.00);
        repository.save(sandwich);
        System.out.println("Updated: " + repository.findById(sandwich.getId()));

        System.out.println();

        repository.deleteById(breast.getId());
        System.out.println("Deleted Chicken Breast.");
        for (Item item : repository.findAll()) {
            System.out.println(item);
        }

        System.out.println();

        try {
            Item invalid = new Item(
                    0, "Invalid Food", "Test", -5.00, false);
            repository.save(invalid);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}