// File: models/Environment
package models;

import db.DatabaseConnection;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Environment {
    private String name;
    private String location;
    private String description;
    private List<Obstacle> hazards;
    private List<MarineLife> friendlySpecies;

    // Constructor
    public Environment(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.hazards = new ArrayList<>();
        this.friendlySpecies = new ArrayList<>();
    }

    // Load environment data from database
    public void getLocationInfo(int locationId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM location WHERE location_id=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, locationId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                this.name = rs.getString("name");
                this.location = rs.getString("location");
                this.description = rs.getString("trivia");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching character info: " + e.getMessage());
        }
    }

    // Display environment details in specified format
    public void displayEnvironmentInfo() {
        Utility.typeWriter("Name: " + name, 30);
        Utility.typeWriter("Location: " + location, 30);
        Utility.typeWriter("Description: " + description, 30);
    }

    // Load hazards from the database or define manually
    private void loadHazards() {
        // Example loading from database (implement if hazards are stored in DB)
        // Otherwise, manually add predefined obstacles here
        hazards.add(new Obstacle("Shark", 3, 30));
        hazards.add(new Obstacle("Polluted Water", 2, 20));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
