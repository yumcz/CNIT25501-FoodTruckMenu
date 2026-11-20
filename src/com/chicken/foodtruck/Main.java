package com.chicken.foodtruck;
import com.chicken.foodtruck.model.ItemRepository;
import com.chicken.foodtruck.model.InMemoryItemRepository;
import com.chicken.foodtruck.model.FileItemRepository;
import com.chicken.foodtruck.view.View;
import com.chicken.foodtruck.view.Controller;
import javax.swing.SwingUtilities;
/**
 * Main.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of main
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ItemRepository repository =
                    new FileItemRepository();

            View view = new View();

            new Controller(repository, view);

            view.setVisible(true);
        });
    }
}