package com.chicken.foodtruck.model;
import java.util.ArrayList;
import java.util.List;
/**
 * InMemoryMenuItemRepository.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of the in memory menu item repository
 */

public class InMemoryMenuItemRepository implements MenuItemRepository {

    private final List<MenuItem> items = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : items) {
            result.add(copy(item));
        }
        return result;
    }

    @Override
    public MenuItem findById(int id) {
        for (MenuItem item : items) {
            if (item.getId() == id) {
                return copy(item);
            }
        }
        return null;
    }

    @Override
    public MenuItem save(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        if (item.getId() == 0) {
            MenuItem newItem = copy(item);
            newItem.setId(nextId++);
            items.add(newItem);
            return copy(newItem);
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == item.getId()) {
                items.set(i, copy(item));
                return copy(item);
            }
        }
        throw new IllegalArgumentException("Error. Invalid Item ID.");
    }

    @Override
    public void deleteById(int id) {
        boolean removed = items.removeIf(item -> item.getId() == id);

        if (!removed) {
            throw new IllegalArgumentException("Error. Invalid Item ID.");
        }
    }

    private MenuItem copy(MenuItem item) {
        return new MenuItem(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.isVegetarian()
        );
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}
