// File: menu/MainMenu
package menu;

import java.util.Scanner;
import game.Game;
import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controllers.GameFlowControl;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println(
                """
                         _____________________________________________
                        |  ________________________________________  |
                        | |                                        | |
                        | |           A Turtle's Journey           | |
                        | |             [1] New Game               | |
                        | |             [2] Load Game              | |
                        | |             [3] Exit                   | |
                        | |________________________________________| |
                        |____________________________________________|""");
        System.out.print("Enter your choice: ");

        int choice = getChoice();
        switch (choice) {
            case 1:
                newGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
        }
    }

    private static int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return choice;
    }

    private static void newGame() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Initialize new player
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Players (username) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int playerId = rs.getInt(1);
                Game game = new Game(playerId);
                System.out.println("Welcome " + username + "! Your player ID is: " + playerId );
                game.startNewGame();
            }
        } catch (SQLException e) {
            System.out.println("Error initializing game: " + e.getMessage());
        }
    }

    private static void loadGame() {
        System.out.print("Enter your player ID: ");
        int playerId;
        playerId = getChoice();

        // Check if player exists
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Players WHERE player_id = ?");
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                GameFlowControl gameFlowControl = new GameFlowControl(playerId);
                gameFlowControl.loadSavedGame();
            } else {
                System.out.println("No save found for this ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
    }
}
