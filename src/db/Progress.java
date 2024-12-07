// File: db/Progress.java
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Progress {
    public static int getPlayerChapterProgress(int playerId) {
        String query = "SELECT chapter FROM progress WHERE player_id = ? ORDER BY progress_id DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("chapter"); // Return last completed/current chapter
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1; // Default to chapter 1 if no progress found
    }
}
