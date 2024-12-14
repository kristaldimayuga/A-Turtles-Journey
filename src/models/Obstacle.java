package models;

import db.DatabaseConnection;
import utility.Utility;
import models.Turtle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Obstacle {
    private int idObstacle;
    private String type;
    private int dangerLevel;
    private int healthImpact;

    // Constructor
    public Obstacle(int idObstacle) {
        this.idObstacle = idObstacle;
    }

    // Load hazards from the database
    public void loadHazards() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM obstacle WHERE idObstacle=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idObstacle);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.type = rs.getString("type");
                this.dangerLevel = rs.getInt("danger_lvl");
                this.healthImpact = rs.getInt("health_impact");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching hazard info: " + e.getMessage());
        }
    }

    public void displayHazards() {
        Utility.typeWriter("\nA " + type + " is approaching!", 30);
        Utility.typeWriter("Danger Level: " + dangerLevel, 30);
    }

    public void afterHazards(Turtle turtle) {
        Utility.typeWriter("\nYou are affected by a " + type, 30);
        turtle.setHealth(turtle.getHealth() - healthImpact);
        Utility.typeWriter("Health reduced to: " + turtle.getHealth(), 30);
    }
}
