package com.chicken.foodtruck.model;
import java.util.List;
/**
 * MenuItemRepository.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of the menu item repository
 */

public interface MenuItemRepository {
    List<MenuItem> findAll();
    MenuItem findById(int id);
    MenuItem save(MenuItem item);
    void deleteById(int id);

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}
