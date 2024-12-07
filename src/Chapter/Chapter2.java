// File: chapter2/Chapter2.java
package Chapter;

import db.DatabaseConnection;
import jdk.jshell.execution.Util;
import utility.Utility;
import events.EdibleOrNotGame;
import events.Quiz;
import models.MarineLife;
import models.Turtle;
import models.Environment;

import java.sql.*;
import java.util.Arrays;

public class Chapter2 extends Chapter {
    private Turtle turtle;
    private EdibleOrNotGame edibleGame;
    private Quiz quiz;

    // Constructor initializing playerId and turtle
    public Chapter2(int playerId) {
        super(playerId);
        this.turtle = new Turtle(playerId); // Pass playerId to Turtle constructor
        this.edibleGame = new EdibleOrNotGame();
        this.quiz = new Quiz();
    }

    @Override
    public void start() {
        Utility.typeWriter("\n\nChapter 2: Meeting New Friends", 30);
        Utility.typeWriter("You continue your journey alone, but soon you spot another turtle nearby.", 30);
        Utility.typeWriter("He was shouting for help, it seems like he does not have any shelter to rest on.", 30);
        Utility.typeWriter("While shouting he saw you and tried to talk to you.", 30);

        Utility.typeWriter("\n\nTurtle: Hey! Can you hear me? I need your help, can you let me share your shelter with you?", 30);
        Utility.typeWriter("Asked the turtle.", 30);
        Utility.typeWriter("You looked at him", 30);
        turtle.getTurtleName();
        Utility.typeWriter(turtle.getName() + ": Hi! I'm new here. Sure, we can share because I don't have any siblings with me. ", 30);

        Utility.typeWriter("Help the turtle swim towards you (S)",30);
        Utility.charScanner('S','s');

        Utility.typeWriter("\n\nThis turtle seems friendly and introduces himself.", 30);
        Utility.typeWriter("Turtle: Hi, I'm Jake!", 30);

        System.out.println();

        MarineLife jake = new MarineLife(null, null, null, null, null, null, null); // Create an empty MarineLife object
        jake.getCharacterInfo(2); // Fetch Jake's details from the database
        jake.displayCharacterInfo(); // Display Jake's information

        Utility.typeWriter("\nPress 'Enter' to continue",30 );
        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("Jake: So...what are you up to?", 30);
        Utility.typeWriter(turtle.getName() + ": I don't know yet. I just want to learn how to do things.", 30);

        Utility.typeWriter("\n\nYou and Jake quickly become friends, and he joins you on your adventure.", 30);

        Utility.typeWriter("\n\nLet's test your knowledge on your new found friend Jake, Press 'Enter' to continue",30);
        Utility.pressEnter();

        // Execute Quiz for specific questions (IDs 1-3)
        quiz.playQuiz(turtle, Arrays.asList(1, 2, 3));

        Utility.typeWriter("\nPress 'Enter' to continue",30 );
        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("Suddenly, you and Jake hear something growling...", 30);
        Utility.typeWriter("I'm hungry, but I don't know what to eat, you said.", 30);
        Utility.typeWriter("Don't worry, I'll teach you how, Jake says.\n\n", 30);

        // Execute EdibleOrNotGame
        edibleGame.playGame(turtle);

        System.out.println();

        // Update age (+5 years) in the player's database
        increaseTurtleAge(5);

        System.out.println();

        Utility.typeWriter("Years passed, and you and Jake grow older. You are now approaching a new location.", 30);

        System.out.println();

        Utility.typeWriter("Jake: " + turtle.getName() + " We're finally here!",30);
        Utility.typeWriter(turtle.getName() + ": Wow, what is this place?",30);

        // Display Ecuador environment info (location_id [2])
        Environment ecuador = new Environment(null, null, null);
        ecuador.getLocationInfo(2);
        ecuador.displayEnvironmentInfo();

        Utility.typeWriter("Press 'Enter' to continue",30 );
        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("\nAs you and Jake enter the place, a friendly octopus approaches and offers to teach you about the reef.", 30);

        Utility.typeWriter("\n\nOctopus: So what do we have here?",30);
        Utility.typeWriter("Jake: Hi mister! we're friends traveling across the sea! I'm Jake.", 30);
        Utility.typeWriter(turtle.getName() + ": And I'm " + turtle.getName() +" !", 30);
        Utility.typeWriter("\nThe Octopus swim towards you and Jake",30);

        // Oscar introduces himself
        Utility.typeWriter("\n\nOctopus: I'm Oscar, nice to meet you young folks!", 30);
        MarineLife oscar = new MarineLife(null, null, null, null, null, null, null);
        oscar.getCharacterInfo(3);
        oscar.displayCharacterInfo();

        Utility.typeWriter("Press 'Enter' to continue",30 );
        Utility.pressEnter();
        System.out.println();

        //The turtles will ask Oscar what is a reef and why is it important
        Utility.typeWriter("Jake: A day octopus? It's our first time meeting someone like you.",30 );
        Utility.typeWriter("Oscar: Well, as you can see, there's a lot of fishes in here, I'm sure you'll find very interesting ones.", 30 );
        Utility.typeWriter("Jake: This place is quite huge, everything is so colorful!", 30);
        Utility.typeWriter("Oscar: This is what you call a reef kid. Here you can find the most diverse and valuable ecosystems on the planet.", 30 );
        Utility.typeWriter("This is home to over 4,000 species of fishes, corals, and marine life.", 30 );
        Utility.typeWriter("Jake: Wow, that's so cool!", 30);
        Utility.typeWriter(turtle.getName() + ": Sir, may I ask, why coral reefs are important?", 30 );
        Utility.typeWriter("Oscar: 'Reefs are important ecosystems. They protect coastlines and provide homes for many creatures.'", 30);
        Utility.typeWriter("Coal reefs only cover 1% of the world's ocean but provide habitat for 25% of world's marine life.", 30 );

        //asking jake
        Utility.typeWriter("\n\nYou wandered around and spotted other marine life in the reef, you wanted to meet them and ask the life under the ocean.", 30);
        Utility.typeWriter("Let's ask Jake to accompany you in meeting new species! (A)", 30);
        Utility.charScanner('A','a');
        Utility.typeWriter("Jake: Sure, I would love to! Let's go!", 30);
        Utility.typeWriter("But before that, Let's test our knowledge on how we know our new friend Oscar!", 30);
        Utility.typeWriter("Take quiz (Q)", 30);
        Utility.charScanner('Q', 'q');
        quiz.playQuiz(turtle, Arrays.asList(4, 5, 6));
        System.out.println();

        Utility.typeWriter("You and Jake explored the different sections and stumbled upon new creatures in the reef.", 30);
        Utility.typeWriter("Press 'Enter' to continue", 30 );
        Utility.pressEnter();
        System.out.println();

        //meeting more people in the reef
        Utility.typeWriter("The two of you spotted a yellow fish.", 30);

        Utility.typeWriter("Jake: Hi!", 30);
        Utility.typeWriter("Fish: Oh. hello there! You guys are new here?", 30);
        Utility.typeWriter("Jake: Yes, I'm Jake, and this is my friend " +turtle.getName() +" .", 30);
        Utility.typeWriter("You waved at her and smiled. (W)", 30);
        Utility.charScanner('W','w');

        Utility.typeWriter("Fish: Nice to meet you guys! I'm Milly.", 30 );
        MarineLife milly = new MarineLife(null, null, null, null, null, null, null);
        milly.getCharacterInfo(4);
        milly.displayCharacterInfo();

        System.out.println();

        //milly will ask them questions
        Utility.typeWriter("Milly: So what are you guys up to?", 30);

        MarineLife roy = new MarineLife(null, null, null, null, null, null, null);
        roy.getCharacterInfo(5);
        roy.displayCharacterInfo();

        System.out.println();

        MarineLife julia = new MarineLife(null, null, null, null, null, null, null);
        julia.getCharacterInfo(6);
        julia.displayCharacterInfo();

        System.out.println();

        Utility.typeWriter("Jake: Did you remember all of them? Let's test ourselves to find out!", 30);

        quiz.playQuiz(turtle, Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

        Utility.typeWriter("Octopus: As a reward, take this bottle.", 30);
        turtle.addItem("Bottle");

        // Update progress in the database for Chapter 2
        updateProgress("Chapter 2 completed.");
    }

    // Method to update turtle's age in the database
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

    // Method to update player's progress in the database
    public void updateProgress(String state) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO progress (player_id, chapter, progress_state) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, playerId);
            stmt.setInt(2, 2); // Chapter 2
            stmt.setString(3, state);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error saving progress: " + e.getMessage(), 30);
        }
    }
}
