package chapter;

import db.DatabaseConnection;
import events.EdibleOrNotGame;
import utility.Utility;
import events.Quiz;
import models.MarineLife;
import models.Turtle;
import models.Environment;
import models.Obstacle;

import java.sql.*;
import java.util.Arrays;

public class Chapter5 extends Chapter {
    private Turtle turtle;
    private EdibleOrNotGame edibleGame;
    private Quiz quiz;

    public Chapter5(int playerId) {
        super(playerId);
        this.turtle = new Turtle(playerId);
        this.edibleGame = new EdibleOrNotGame();
        this.quiz = new Quiz();
    }

    @Override
    public void start() {
        Utility.typeWriter("-".repeat(50), 30);
        Utility.typeWriter("Chapter 5: Dreams Come True", 30);
        Utility.typeWriter("-".repeat(50), 30);

        Utility.typeWriter("The ocean stretched endlessly, a shimmering expanse of blue and green. You swam with determination, the memory of its long-lost friend and their shared dream of reaching the Bahamas guiding its every stroke. ", 30 );

        Utility.typeWriter("You felt your tummy growling, It's time to eat! ", 30 );
        edibleGame.playGame(turtle);

        Environment brazil = new Environment(null, null, null);
        brazil.getLocationInfo(6);
        brazil.displayEnvironmentInfo();

        Utility.typeWriter("While traveling along the vibrant coast of Brazil, the your sharp eyes caught sight of a struggle near the surface. A group of turtles flailed helplessly, trapped in a massive plastic bag tangled around a sharp rock. ", 30 );

        Utility.typeWriter("Help the turtles!(H) ", 30 );
        Utility.charScanner('H','h');

        turtle.getTurtleName();
        Utility.typeWriter(turtle.getName() + ": (Alarmed) Hang on! I’m coming!", 30 );

        Utility.typeWriter("With a burst of energy, you darted toward them, biting through the suffocating plastic and pushing the rock away with all its strength. ", 30 );


        Utility.typeWriter("Rescued Turtle: (Gratefully) Thank you… we thought we were goners! ", 30 );
        Utility.typeWriter("A turtle seemed to know you... ", 30 );
        Utility.typeWriter("Jake: " + turtle.getName() + " ? Is that you?", 30 );

        Utility.typeWriter("The two turtles swam toward each other, and the moment their shells touched, it was as if no time had passed. ", 30 );

        Utility.typeWriter("Jake: (Laughing) You’re still as dramatic as ever! ", 30 );
        Utility.typeWriter(turtle.getName() + ": (Laughing through tears) And you’re still terrible at staying out of trouble! ", 30 );
        Utility.typeWriter("Jake: (Grinning) I’ve missed you, buddy. You won’t believe it, but I’ve been trying to find the Bahamas too! ", 30 );

        Utility.typeWriter("With renewed spirits, the two friends set off, their bond stronger than ever. Along the way, they met a vivacious young turtle as your mate, whose playful demeanor brought laughter to their journey. ", 30 );

        Utility.typeWriter("As days turned into weeks, their bond deepened, and you and your mate became inseparable. One evening, under the glow of a silver moon, they made a promise. ", 30 );

        Utility.typeWriter("Mate: (Softly) When we reach the Bahamas, let’s make it our home. And someday, we’ll lay our eggs there, so our children can see its beauty too. ", 30 );
        Utility.typeWriter(turtle.getName() + ": (Touched) I’d love nothing more than to share that dream with you. ", 30 );

        Utility.typeWriter("Finally, after months of travel, the turtles reached the fabled Bahamas. The sight stole their breath—crystal-clear waters, vibrant coral reefs, and a dazzling array of marine life. ", 30 );

        Environment bahamas = new Environment(null, null, null);
        bahamas.getLocationInfo(7);
        bahamas.displayEnvironmentInfo();

        Utility.typeWriter("Jake: (Astonished) It’s even more beautiful than I imagined… ", 30 );
        Utility.typeWriter("Shelly: (Spinning excitedly) This is it! We made it! ", 30 );

        Utility.typeWriter("Years passed, standing at the water’s edge, you and your mate waved goodbye to their children, their hearts full of hope and pride. ", 30 );
        Utility.typeWriter("The ocean stretched endlessly before you—a reminder that every ending is just the beginning of a new adventure. ", 30 );

        updateProgress("Chapter 5 completed.");
    }


    private void increaseTurtleAge(int years) {
        turtle.ageUp(years);
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE players SET age = ? WHERE player_id = ?"
            );
            stmt.setInt(1, turtle.getAge());
            stmt.setInt(2, playerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error updating age: " + e.getMessage(), 30);
        }
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
