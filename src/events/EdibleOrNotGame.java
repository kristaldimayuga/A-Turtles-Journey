package events;

import db.DatabaseConnection;
import models.Turtle;
import utility.Utility;

import java.sql.*;
import java.util.*;

public class EdibleOrNotGame {
    private List<String> items; // Unified list of items with their edibility

    public EdibleOrNotGame() {
        items = new ArrayList<>();
        loadItemsFromDatabase();
    }

    private void loadItemsFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, isEdible FROM edibleitem");

            while (rs.next()) {
                String itemName = rs.getString("name");
                boolean isEdible = rs.getBoolean("isEdible");
                items.add(itemName + ":" + isEdible); // Store item as "name:isEdible"
            }

            Collections.shuffle(items); // Shuffle to ensure randomness
        } catch (SQLException e) {
            System.out.println("Error loading items: " + e.getMessage());
        }
    }

    public void playGame(Turtle turtle) {
        // Select a maximum of 10 random items from the list
        List<String> selectedItems = items.subList(0, Math.min(10, items.size()));
        Collections.shuffle(selectedItems); // Shuffle again for extra randomness

        for (String itemData : selectedItems) {
            String[] itemSplit = itemData.split(":");
            String itemName = itemSplit[0];
            boolean isEdible = Boolean.parseBoolean(itemSplit[1]);

            Utility.typeWriter("Is " + itemName + " edible? (yes/no)", 30);

            // Loop until the user provides valid input
            String answer = "";
            while (true) {
                answer = Utility.getUserInput().trim().toLowerCase(); // Clean up input
                if (answer.equals("yes") || answer.equals("no")) {
                    break; // Exit loop if valid input
                } else {
                    Utility.typeWriter("Wrong input, yes or no only.", 30); // Error message
                }
            }

            // Check if the answer is correct
            boolean correct = (isEdible && answer.equals("yes")) || (!isEdible && answer.equals("no"));

            if (!correct) {
                turtle.setHealth(turtle.getHealth() - 20);
                Utility.typeWriter("Wrong! Health reduced to " + turtle.getHealth(), 30);
                if (turtle.getHealth() <= 0) {
                    Utility.typeWriter("You fainted! Restarting the game...", 30);
                    turtle.setHealth(100); // Reset health and restart game
                    playGame(turtle);
                    return;
                }
            }
        }

        Utility.typeWriter("You completed the Edible-or-Not game successfully!", 30);
    }
}
