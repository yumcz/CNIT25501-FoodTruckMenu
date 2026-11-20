package com.chicken.foodtruck.model;
import java.util.ArrayList;
import java.util.List;
/**
 * InMemoryItemRepository.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of the in memory menu item repository
 */
public class InMemoryItemRepository implements ItemRepository {

    private final List<Item> items = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            result.add(copy(item));
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return copy(item);
            }
        }
        return null;
    }

    @Override
    public Item save(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        if (item.getId() == 0) {
            Item newItem = copy(item);
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

    private Item copy(Item item) {
        return new Item(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.isVegetarian()
        );
    }

    public void loadItem(Item item) {
        items.add(item);
        nextId = Math.max(nextId, item.getId() + 1);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}
