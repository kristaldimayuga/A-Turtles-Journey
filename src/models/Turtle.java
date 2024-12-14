package models;

import db.DatabaseConnection;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Turtle {
    private String name; // This is the turtle's name.
    private int age;
    private int health;
    private List<String> items;
    private int playerId; // This will store the playerId to fetch the turtle's name from the database.

    // Constructor
    public Turtle(int playerId) {
        this.playerId = playerId;
        this.age = 1;
        this.health = 100;
        this.items = new ArrayList<>();
    }

    // Method to add an item to inventory
    public void addItem(String itemName) {
        items.add(itemName);
        Utility.typeWriter("You obtain a " + itemName + " and added it to the inventory.", 30);
    }

    // Method to age up (for example, after significant events)
    public void ageUp(int points) {
        age += points;
        Utility.typeWriter(name + " ages up and is now " + age + " years old.", 30);
    }

    // Fetch turtle name from the database based on playerId
    public void getTurtleName() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT turtle_name FROM players WHERE player_id=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, playerId);  // Use the playerId from the constructor
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                this.name = rs.getString("turtle_name"); // Set the turtle's name from DB
            }
        } catch (SQLException e) {
            System.out.println("Error fetching turtle name: " + e.getMessage());
        }
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
