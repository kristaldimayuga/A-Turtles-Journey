// File: models/Environment
package models;

import db.DatabaseConnection;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Environment {
    private String name;
    private String location;
    private String description;

    // Constructor
    public Environment(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
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

}
