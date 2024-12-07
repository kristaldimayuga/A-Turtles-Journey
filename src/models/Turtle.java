// File: models/Turtle
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
    private int level;
    private int lifePoints;
    private List<String> friends;
    private List<String> items;
    private int playerId; // This will store the playerId to fetch the turtle's name from the database.

    // Constructor
    public Turtle(int playerId) {
        this.playerId = playerId;
        this.age = 1;
        this.health = 100;
        this.level = 1;
        this.lifePoints = 0;
        this.friends = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // Method to add an item to inventory
    public void addItem(String itemName) {
        items.add(itemName);
        Utility.typeWriter("You obtain a " + itemName + " and added it to the inventory.", 30);
    }

    // Level-up method
    public void levelUp() {
        level++;
        lifePoints += 5;
        Utility.typeWriter(name + " has leveled up! Level: " + level, 30);
    }

    // Method to age up (for example, after significant events)
    public void ageUp(int points) {
        age += points;
        Utility.typeWriter(name + " ages up and is now " + age + " years old.", 30);
    }

    // Increase health with bounds check
    public void increaseHealth(int increment) {
        health = Math.min(health + increment, 100);  // Max health is 100
        Utility.typeWriter(name + "'s health is now " + health + "%.", 30);
    }

    // Decrease health and handle possible consequences
    public void decreaseHealth(int decrement) {
        health -= decrement;
        if (health <= 0) {
            health = 0;
            Utility.typeWriter(name + " has lost all health and needs to restart the current challenge.", 30);
            // Possible restart logic for game challenges here
        } else {
            Utility.typeWriter(name + "'s health dropped to " + health + "%.", 30);
        }
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

    // Display turtle name
    public void displayTurtleName() {
        if (name != null) {
            System.out.println("Turtle Name: " + name);
        } else {
            System.out.println("Turtle name not set.");
        }
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
