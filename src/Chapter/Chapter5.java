// File: chapter5/Chapter5.java
package Chapter;

import db.DatabaseConnection;
import utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chapter5 extends Chapter{

    public Chapter5(int playerId) {
        super(playerId);
    }

    @Override
    public void start() {
        Utility.typeWriter("Chapter 5: Your Journey Continues...", 30);
        // Add specific game logic for Chapter 5 here

        // Example: Update progress in the database for Chapter 5
        updateProgress("Chapter 5 completed.");
    }

    public void updateProgress(String state) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Progress (player_id, chapter, progress_state) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, playerId);
            stmt.setInt(2, 5); // Chapter 5
            stmt.setString(3, state);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error saving progress: " + e.getMessage(), 30);
        }
    }
}
