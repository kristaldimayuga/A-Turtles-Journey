package chapter;

import db.DatabaseConnection;
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
        Utility.typeWriter("-".repeat(50), 30);
        Utility.typeWriter("\nChapter 2: Meeting New Friends\n", 30);
        Utility.typeWriter("-".repeat(50), 30);

        Utility.typeWriter("\nYou continue your journey alone, but soon you spot another turtle nearby.", 30);
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

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("Jake: So...what are you up to?", 30);
        Utility.typeWriter(turtle.getName() + ": I don't know yet. I just want to learn how to do things.", 30);

        Utility.typeWriter("\n\nYou and Jake quickly become friends, and he joins you on your adventure.", 30);

        Utility.typeWriter("\n\nLet's test your knowledge on your new found friend Jake",30);
        Utility.pressEnter();

        // Execute Quiz for specific questions (IDs 1-3)
        quiz.playQuiz(turtle, Arrays.asList(1, 2, 3));

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
        System.out.println();

        // Display Ecuador environment info (location_id [2])
        Environment ecuador = new Environment(null, null, null);
        ecuador.getLocationInfo(2);
        ecuador.displayEnvironmentInfo();

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("\nAs you and Jake enter the place, a friendly octopus approaches and offers to teach you about the reef.", 30);

        Utility.typeWriter("\n\nOctopus: So what do we have here?",30);
        Utility.typeWriter("Jake: Hi mister! we're friends traveling across the sea! I'm Jake.", 30);
        Utility.typeWriter(turtle.getName() + ": And I'm " + turtle.getName() +" !", 30);
        Utility.typeWriter("\nThe Octopus swim towards you and Jake",30);

        // Oscar introduces himself
        Utility.typeWriter("\nOctopus: I'm Oscar, nice to meet you young folks!", 30);
        MarineLife oscar = new MarineLife(null, null, null, null, null, null, null);
        oscar.getCharacterInfo(3);
        oscar.displayCharacterInfo();

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

        //Asking jake
        Utility.typeWriter("\n\nYou wandered around and spotted other marine life in the reef, you wanted to meet them and ask the life under the ocean.", 30);
        Utility.typeWriter("Let's ask Jake to accompany you in meeting new species! (A)", 30);
        Utility.charScanner('A','a');

        Utility.typeWriter("\nJake: Sure, I would love to! Let's go!", 30);
        Utility.typeWriter("But before that, Let's test our knowledge on how we know our new friend Oscar!", 30);

        Utility.typeWriter("\nTake quiz (Q)", 30);
        Utility.charScanner('Q', 'q');
        quiz.playQuiz(turtle, Arrays.asList(4, 5, 6));
        System.out.println();

        Utility.typeWriter("You and Jake explored the different sections and stumbled upon new creatures in the reef.", 30);
        Utility.pressEnter();
        System.out.println();

        //Meeting more people in the reef
        Utility.typeWriter("\n\nThe two of you spotted a yellow fish.", 30);

        Utility.typeWriter("\n\nJake: Hi!", 30);
        Utility.typeWriter("Fish: Oh. hello there! You guys are new here?", 30);
        Utility.typeWriter("Jake: Yes, I'm Jake, and this is my friend " +turtle.getName() +" .", 30);
        Utility.typeWriter("You waved at her and smiled. (W)", 30);
        Utility.charScanner('W','w');

        Utility.typeWriter("\n\nFish: Nice to meet you guys! I'm Milly.", 30 );
        MarineLife milly = new MarineLife(null, null, null, null, null, null, null);
        milly.getCharacterInfo(4);
        milly.displayCharacterInfo();

        Utility.pressEnter();
        System.out.println();

        //Milly will ask a question
        Utility.typeWriter("Milly: So what are you guys up to?", 30);
        Utility.typeWriter("[1] We just wanted to find a place to stay", 30);
        Utility.typeWriter("[2] We wanted to learn about different marine species", 30);
        Utility.typeWriter("[3] We wanted to explore the vast oceans", 30);

        tellPurpose();
        System.out.println();

        //Say goodbye to Milly
        Utility.typeWriter("Jake: Thank you Milly!", 30);
        Utility.typeWriter("Come on " + turtle.getName() + " let's meet the others!", 30 );
        Utility.typeWriter("Milly: See ya!", 30);

        Utility.typeWriter("\n\nYou and Jake swam to the next section of the reef. You spotted a red-orange starfish chilling alone.", 30);

        //Meeting Roy
        Utility.typeWriter("\n\nJake: Look, it's a star-shaped creature!", 30);
        Utility.typeWriter("Starfish: Hey there! New comers eh?", 30);
        Utility.typeWriter("By the way, I'm not just a star-shaped creature. I'm Roy, a starfish", 30 );
        MarineLife roy = new MarineLife(null, null, null, null, null, null, null);
        roy.getCharacterInfo(5);
        roy.displayCharacterInfo();

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("Jake: I love the patterns on your body, you look so unique compared to others", 30);
        Utility.typeWriter("Roy: I appreciate it lad, but, you clearly haven't seen my girlfriend", 30);

        Utility.typeWriter("\n\nA beautiful umbrella-like creature approach the three of you.", 30);

        Utility.typeWriter("\n\nRoy: Here she is", 30);
        Utility.typeWriter("Moon Jelly: Hi guys! It looks like we have some new faces in here", 30);
        Utility.typeWriter("Roy: Meet my girlfriend, Julia", 30);
        MarineLife julia = new MarineLife(null, null, null, null, null, null, null);
        julia.getCharacterInfo(6);
        julia.displayCharacterInfo();

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("\nRoy: This is Jake and " + turtle.getName(), 30);
        Utility.typeWriter("Jake: Nice to meet you Ma'am", 30);

        Utility.typeWriter("\n\nYou looked at Julia and observed her beautiful blue and orange colour as she floats gracefully with her light body", 30 );

        Utility.typeWriter("\n\n" + turtle.getName() + ": You are indeed very pretty", 30);
        Utility.typeWriter("Julia: Thank you so much", 30);
        Utility.typeWriter("Roy: Hold up right there, stop making moves on her", 30 );
        Utility.typeWriter("Jake: Come on Roy, we're just appreciating her looks, plus, we don't like to be in other creatures' business", 30);

        Utility.typeWriter("\n\nYou, Roy, and Julia laugh it off, knowing how overprotective Roy is", 30 );

        Utility.typeWriter("\n\nJake: By the way, how are you two a couple? Are we suppose to mate with our own kind?", 30);
        Utility.typeWriter("Roy: Nothing is impossible kid", 30);
        Utility.typeWriter("Julia: Roy is a very sweet man, I'm sure if you guys know him better, you'll like him too", 30);
        Utility.typeWriter("Jake: No thanks, I'll stick  with what I want", 30);
        Utility.typeWriter("Julia: Well, good luck on your journey kids! Me and Roy will get going", 30);

        Utility.typeWriter("\n\nRoy and Julia left.", 30);

        //Take a quiz
        Utility.typeWriter("\n\nJake: Phew! that's funny", 30);
        Utility.typeWriter("Who knew a starfish has a moon jelly girlfriend? That's crazy!", 30 );
        Utility.typeWriter("[1] I know right!", 30);
        Utility.typeWriter("[2] That's weird", 30);
        Utility.typeWriter("[3] I think it's just normal", 30);

        replyToJake();

        Utility.typeWriter("\n\nJake: By the way, now that we already done meeting our new friends, Let's see how good is our memory", 30);
        Utility.typeWriter("Did you remember all of them? Let's test ourselves to find out!", 30);

        Utility.typeWriter("Take quiz (Q)", 30);
        Utility.charScanner('Q', 'q');
        quiz.playQuiz(turtle, Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14));
        System.out.println();

        Utility.typeWriter("You saw Oscar approaching the two of you", 30);
        Utility.typeWriter("Octopus: Well done kids! As a reward, take this bottle.", 30);
        turtle.addItem("Bottle");

        Utility.pressEnter();
        System.out.println();

        //Reading the letter
        Utility.typeWriter(turtle.getName() + ": What’s this? A letter?",30);
        Utility.typeWriter("Jake: A letter? Let me see! What does it say?",30);

        Utility.typeWriter("\n\nYou opened the letter and read it out loud.",30);

        Utility.typeWriter("\nTo my dearest love,",30);
        Utility.typeWriter("Today, the ocean sparkles as if it holds the stars themselves.",30);
        Utility.typeWriter("The crystal blue waters of the Bahamas are beyond anything I’ve ever seen—a true paradise on Earth. ",30);
        Utility.typeWriter("Every wave carries a melody, every breeze a whisper of peace.",30);
        Utility.typeWriter("I dream of the day we visit this place together, to feel the warmth of its sands and the beauty of its coral reefs. ",30);

        Utility.typeWriter("\nUntil that day, I’ll carry its memory in my heart, and I hope this letter carries my love to you across the seas.",30);
        Utility.typeWriter("\nYours forever, ",30);
        Utility.typeWriter("Sebastian ",30);

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("Jake: Wow... That’s beautiful. ",30);
        Utility.typeWriter(turtle.getName() + "The Bahamas… A paradise on Earth. I want to see it, Jake. I want to see the world beyond the reefs, beyond everything we know.",30);
        Utility.typeWriter("Jake: You want to leave? What about our safety?",30);

        Utility.typeWriter("\nYou want to convince Jake to come with you. (C)",30);
        Utility.charScanner('C','c');
        System.out.println();

        Utility.typeWriter(turtle.getName() + ": This letter, Jake—it’s like it’s calling to me. I’ve always wondered what’s out there. Don’t you? Let’s find out together ",30);
        Utility.typeWriter("Jake: Well… I can’t let you have all the fun without me. Alright, let’s do it. Let’s find this paradise! ",30);

        //Saying goodbye to Oscar
        Utility.typeWriter("\n\nOscar, who had been listening quietly, approached the two young turtles with a warm smile.  ",30);

        Utility.typeWriter("\n\nOscar: So, you’re heading out into the big wide ocean, eh? ",30);
        Utility.typeWriter(turtle.getName() + ": Yes, Oscar. We’re going to find the Bahamas and discover the world! ",30);
        Utility.typeWriter("Oscar: It’s a big ocean out there, full of wonders and challenges. But I believe in you both.  ",30);
        Utility.typeWriter("Stick together, stay brave, and never forget where you came from. Good luck, little ones",30);
        Utility.typeWriter("Jake: Thank you, Oscar. We’ll never forget you!",30);
        Utility.typeWriter(turtle.getName() + ": Goodbye Oscar!",30);
        Utility.typeWriter("Oscar: Goodbye, kids. And remember, the ocean is as kind as it is vast—respect it, and it’ll guide you well",30);

        Utility.typeWriter("\n\nWith the sparkling bottle in their satchel and dreams in their hearts, the two young turtles set off into the endless blue.",30);
        Utility.typeWriter("The journey ahead was unknown, but they carried a newfound hope and determination.",30);
        Utility.typeWriter("The waves sang their song, and the horizon whispered of adventure.",30);

        // Update progress in the database for Chapter 2
        updateProgress("Chapter 2 completed.");
    }

    private void replyToJake(){
        int choice;
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter(turtle.getName() + ": I know right! Who would have thought that jellyfish is related to a starfish.", 30);
                    Utility.typeWriter("There are really some unexpected things here in the ocean. I'm curious to see more", 30);
                    break;
                case 2:
                    Utility.typeWriter(turtle.getName() + ": That's weird, how are gonna do that- you know", 30);
                    Utility.typeWriter("Jake: Silly! Who knows, as Roy said, nothing is impossible", 30);
                    Utility.typeWriter(turtle.getName() + ": HAHAHAHA goodluck to them I guess...", 30);
                    break;
                case 3:
                    Utility.typeWriter(turtle.getName() + ": I think it's just normal", 30);
                    Utility.typeWriter("Jake: Are you for real? Well guess I'm the only one sane here", 30);
                    break;
                default:
                    Utility.typeWriter("That's not a valid choice. Please try again.", 30);
            }
        } while (choice < 1 || choice > 3);
    }
    private void tellPurpose() {
        int choice;
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter("Milly: I see, well make yourself at home. We're always here to welcome new people and visitors!", 30);
                    break;
                case 2:
                    Utility.typeWriter("Milly: That's interesting! Smart and curious, you guys still have a lot to learn", 30);
                    break;
                case 3:
                    Utility.typeWriter("Milly: Ahoy adventurers! Hope you like your stay here. Tell me about your next adventures if we ever stumble upon them next time", 30);
                    break;
                default:
                    Utility.typeWriter("That's not a valid choice. Please try again.", 30);
            }
        } while (choice < 1 || choice > 3);
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
