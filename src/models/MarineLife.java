// File: models/MarineLife.java
package models;

import db.DatabaseConnection;
import utility.Utility;
import java.sql.*;

public class MarineLife {
    private String name;
    private String species;
    private String classification;
    private String kind;
    private String relationship;
    private String location;
    private String educationalFact;

    // Constructor
    public MarineLife(String name, String species, String classification, String kind, String relationship, String location, String educationalFact) {
        this.name = name;
        this.species = species;
        this.classification = classification;
        this.kind = kind;
        this.relationship = relationship;
        this.location = location;
        this.educationalFact = educationalFact;
    }

    // Fetch character info from the database and initialize the object
    public void getCharacterInfo(int characterId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM characters WHERE character_id=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, characterId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                this.name = rs.getString("name");
                this.species = rs.getString("species");
                this.classification = rs.getString("classification");
                this.kind = rs.getString("kind");
                this.relationship = rs.getString("relationship");
                this.location = rs.getString("location");
                this.educationalFact = rs.getString("educationalFact");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching character info: " + e.getMessage());
        }
    }

    // Display character details
    public void displayCharacterInfo() {
        Utility.typeWriter("Name: " + name, 30);
        Utility.typeWriter("Species: " + species, 30);
        Utility.typeWriter("Classification: " + classification, 30);
        Utility.typeWriter("Kind: " + kind, 30);
        Utility.typeWriter("Relationship: " + relationship, 30);
        Utility.typeWriter("Location: " + location, 30);
        Utility.typeWriter("Trivia: " + educationalFact, 30);
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getClassification() {
        return classification;
    }

    public String getKind() {
        return kind;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getLocation() {
        return location;
    }

    public String getEducationalFact() {
        return educationalFact;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setKind(String kind) {this.kind = kind;}

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEducationalFact(String educationalFact) {
        this.educationalFact = educationalFact;
    }
}