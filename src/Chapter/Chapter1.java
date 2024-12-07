package Chapter;

import db.DatabaseConnection;
import models.Environment;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Chapter1 extends Chapter{

    public Chapter1(int playerId) {
        super(playerId);
    }

    @Override
    public void start() {
        Utility.typeWriter("\nChapter 1: Birth and Survival", 30);

        Environment costarica = new Environment(null, null, null);
        costarica.getLocationInfo(1);
        costarica.displayEnvironmentInfo();

        Utility.typeWriter("In a warm sunny day in Costa Rica...", 30);
        Utility.typeWriter("A group of green sea turtles are born.", 30 );
        Utility.typeWriter("The white sand and the sunlight blinds you as you open your eyes...", 30);
        Utility.typeWriter("You look around and realize you're the last one to hatch from your nest.", 30);
        Utility.typeWriter("Pushing and waddling, you make your way to the shore...", 30);

        // Ask for player to name the turtle
        Scanner scanner = new Scanner(System.in);
        Utility.typeWriter("\nOne of your siblings turns to you and asks, 'What's your name?' \nEnter your name: ", 70);
        String turtleName = scanner.nextLine();

        updateTurtle_name(turtleName);

        // Sibling dialogue
        Utility.typeWriter("\nYour sibling smiles and says, 'Good luck, " + turtleName + "! See you in 50 years!'", 30 );
        Utility.typeWriter("You wave goodbye and begin your journey into the open ocean.", 30);

        // Seagull encounter
        Utility.typeWriter("\nAs you swim towards the waves, you suddenly notice a shadow passing overhead...", 30);
        Utility.typeWriter("A seagull swoops down, targeting you and your fellow baby turtles!", 30);

        // Escape the seagull
        Utility.typeWriter("QUICK! TURN RIGHT! (D)" , 0);
        Utility.charScanner('D', 'd');

        Utility.typeWriter("TURN LEFT! (A)" , 0);
        Utility.charScanner('A', 'a');

        Utility.typeWriter("\nYou frantically paddle, trying to escape, you swim into the waves to save yourself.", 30);
        Utility.pressEnter();
        Utility.typeWriter("You managed to avoid the seagull and let the waves carry you to safety.", 30);

        Utility.typeWriter("\nWhoo! That was close!.", 30);

        // Choosing a floating home
        Utility.typeWriter("\nExhausted, you look for a place to rest. You spot some floating debris nearby.", 30);
        Utility.typeWriter("Choose a place to rest for the night:", 30);
        Utility.typeWriter("[1] A floating wooden plank", 30);
        Utility.typeWriter("[2] A piece of floating styrofoam", 30);
        Utility.typeWriter("[3] A bed of floating seaweed", 30);

        findShelter();

        // Ending of Chapter 1
        Utility.typeWriter("\nAs you drift off to sleep, you feel the gentle sway of the ocean around you.", 30);
        Utility.typeWriter("When you wake up, you are alone, floating in the vast sea, wondering what lies ahead...", 30);
        Utility.typeWriter("End of Chapter 1.\n", 30);

        updateProgress("Chapter 1 completed.");
    }

    private void updateTurtle_name(String turtleName) {
        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Players SET turtle_name = ? WHERE player_id = ?"
            );
            stmt.setString(1, turtleName);
            stmt.setInt(2, playerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error updating turtle name: " + e.getMessage(), 30);
        }
    }

    private void findShelter() {
        int choice;
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter("You crawl onto the wooden plank and close your eyes, drifting off to sleep...", 30);
                    break;
                case 2:
                    Utility.typeWriter("You cling to the floating styrofoam, finding a cozy spot to rest.", 30);
                    break;
                case 3:
                    Utility.typeWriter("You settle on a bed of seaweed, feeling safe and hidden from predators.", 30);
                    break;
                default:
                    Utility.typeWriter("That's not a valid choice. Please try again.", 30);
            }
        } while (choice < 1 || choice > 3);
    }

    public void updateProgress(String state) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Progress (player_id, chapter, progress_state) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, playerId);
            stmt.setInt(2, 1); // Chapter 1
            stmt.setString(3, state);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving progress: " + e.getMessage());
        }
    }

}

