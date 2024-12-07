// File: chapter3/Chapter3.java
package Chapter;

import db.DatabaseConnection;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chapter3 extends Chapter{

    public Chapter3(int playerId) {
        super(playerId);
    }

    @Override
    public void start() {
        Utility.typeWriter("Chapter 3: Your Journey Continues...", 30);
        // Add specific game logic for Chapter 2 here

        // Example: Update progress in the database for Chapter 2
        updateProgress("Chapter 3 completed.");
    }

    public void updateProgress(String state) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Progress (player_id, chapter, progress_state) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, playerId);
            stmt.setInt(2, 3); // Chapter 3
            stmt.setString(3, state);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error saving progress: " + e.getMessage(), 30);
        }
    }
}
