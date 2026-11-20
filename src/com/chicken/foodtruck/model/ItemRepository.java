package com.chicken.foodtruck.model;
import java.util.List;
/**
 * ItemRepository.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of the item repository
 */

public interface ItemRepository {
    List<Item> findAll();
    Item findById(int id);
    Item save(Item item);
    void deleteById(int id);

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}
