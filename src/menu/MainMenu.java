package menu;

import java.util.Scanner;
import controllers.Game;
import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controllers.GameFlowControl;
import utility.Utility;

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
                System.out.println("Welcome " + username + "! Your player ID is: " + playerId);
                game.startNewGame();
            }
        } catch (SQLException e) {
            System.out.println("Error initializing game: " + e.getMessage());
        }
    }

    private static void loadGame() {
        System.out.print("Enter your player ID: ");
        int playerId = getChoice();

        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT chapter FROM Progress WHERE player_id = ? ORDER BY chapter DESC LIMIT 1"
            );
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int latestChapter = rs.getInt("chapter");
                Utility.typeWriter("Your current progress is at Chapter " + latestChapter, 30);
                Utility.typeWriter("Would you like to continue?", 30);
                Utility.typeWriter("[1] Yes", 30);
                Utility.typeWriter("[2] No (reset progress)", 30);
                Utility.typeWriter("Enter your choice: ", 30);

                int loadGameChoice = getChoice();

                if (loadGameChoice == 1) {
                    // Load game
                    PreparedStatement playerCheck = conn.prepareStatement("SELECT * FROM Players WHERE player_id = ?");
                    playerCheck.setInt(1, playerId);
                    ResultSet playerResult = playerCheck.executeQuery();

                    if (playerResult.next()) {
                        GameFlowControl gameFlowControl = new GameFlowControl(playerId);
                        gameFlowControl.loadSavedGame();
                    } else {
                        System.out.println("No save found for this ID.");
                    }
                } else if (loadGameChoice == 2) {
                    // Reset progress
                    deleteProgress(playerId);
                    newGame();
                } else {
                    System.out.println("Invalid choice. Returning to main menu.");
                    displayMenu();
                }
            } else {
                System.out.println("No progress found for this player ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
    }

    private static void deleteProgress(int playerId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Delete progress from the Progress table
            PreparedStatement deleteProgressStmt = conn.prepareStatement(
                    "DELETE FROM Progress WHERE player_id = ?"
            );
            deleteProgressStmt.setInt(1, playerId);
            deleteProgressStmt.executeUpdate();

            // Delete player details from the Players table
            PreparedStatement deletePlayerStmt = conn.prepareStatement(
                    "DELETE FROM Players WHERE player_id = ?"
            );
            deletePlayerStmt.setInt(1, playerId);
            deletePlayerStmt.executeUpdate();

            System.out.println("Progress and player data have been reset.");
        } catch (SQLException e) {
            System.out.println("Error resetting progress: " + e.getMessage());
        }
    }
}
