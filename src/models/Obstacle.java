//File: models/Obstacle
package models;

import db.DatabaseConnection;

public class Obstacle {
    private String type;
    private int dangerLevel;
    private int healthImpact;

    // Constructor
    public Obstacle(String type, int dangerLevel, int healthImpact) {
        this.type = type;
        this.dangerLevel = dangerLevel;
        this.healthImpact = healthImpact;
    }

    // Method to harm the turtle
    public void harmTurtle(Turtle turtle) {
        turtle.setHealth(turtle.getHealth() - healthImpact);
    }
}

