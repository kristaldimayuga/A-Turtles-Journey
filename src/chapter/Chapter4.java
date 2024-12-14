package chapter;

import db.DatabaseConnection;
import utility.Utility;
import events.Quiz;
import models.MarineLife;
import models.Turtle;
import models.Environment;
import models.Obstacle;

import java.sql.*;
import java.util.Arrays;

public class Chapter4 extends Chapter {
    private Turtle turtle;
    private Quiz quiz;

    public Chapter4(int playerId) {
        super(playerId);
        this.turtle = new Turtle(playerId);
        this.quiz = new Quiz();
    }

    @Override
    public void start() {
        Utility.typeWriter("-".repeat(50), 30);
        Utility.typeWriter("Chapter 4: Healing Waters and New Bonds", 30);
        Utility.typeWriter("-".repeat(50), 30);

        Obstacle freezingTemp = new Obstacle(4); // ID of the seagull hazard in the database
        freezingTemp.loadHazards();
        freezingTemp.displayHazards();

        freezingTemp.afterHazards(new Turtle(playerId));

        Utility.typeWriter("You woke up slowly, warmth spreading through its body. Blinking groggily, it realized it was inside a strange, glowing contraption. The soft hum of the incubator surrounded it, and the chill of the icy waters was now a distant memory.", 30 );

        Utility.typeWriter("Through the clear walls of the incubator, you saw a human—a gentle-looking woman with kind eyes. ", 30 );

        turtle.getTurtleName();
        Utility.typeWriter(turtle.getName() + ": Where....where am I? ", 30 );

        Utility.typeWriter("Woman: (Softly) Hey there, little one. You’re safe now. ", 30 );
        MarineLife carrie = new MarineLife(null, null, null, null,null,null,null);
        carrie.getCharacterInfo(10);
        carrie.displayCharacterInfo();

        Utility.typeWriter("You shied away, unsure of what to think about the towering figure. But Carrie’s gentle voice and careful movements put you at ease. ", 30 );

        Utility.typeWriter("Carrie: (To herself, while inspecting you) Frostbite… poor thing. You must’ve been through so much. Don’t worry, I’ll take care of you. ", 30 );

        Utility.typeWriter("Suddenly you remembered, Seb and Lewis in the abandoned beach. ", 30 );
        Utility.typeWriter(turtle.getName() + ": It's been a while, I miss them so much ", 30 );

        Utility.typeWriter("Let's take a quiz to test our knowledge. ", 30 );
        Utility.typeWriter("Take Quiz (Q) ", 30 );
        Utility.charScanner('Q','q');

        quiz.playQuiz(turtle, Arrays.asList(7, 8, 9));
        Utility.typeWriter("Over the next few days, Carrie tended to the your wounds with patience and care. She talked to you, explaining her actions as she worked. ", 30 );

        Utility.typeWriter("Carrie: When marine animals suffer from frostbite, it’s important to raise their temperature slowly. Too much warmth too quickly can hurt them even more. We also need to keep them hydrated and monitor for infections. ", 30 );
        Utility.typeWriter(turtle.getName() + ": Carrie seems so kind...she's been taking of me this whole time...", 30 );

        Utility.typeWriter("Though you was shy at first, you gradually began to trust Carrie. Her warm touch and soothing voice made you feel safe, even in this unfamiliar place. ", 30 );
        Utility.typeWriter("Two weeks later, you had regained its strength and was ready to move around.", 30 );

        Utility.typeWriter("Carrie opened the door and head towards you, she seems very excited about something. ", 30 );

        Utility.typeWriter("Carrie: Today, you're gonna meet new friends and awesome people ", 30 );

        Utility.typeWriter("You were transported from the ship to explore your new and temporary home—a near Ocean Conservation Facility where rescued marine animals were given a second chance at life. ", 30 );

        Utility.typeWriter("Carrie: Ready for a little tour, buddy? Let’s meet some of your new neighbors! ", 30 );

        Environment oceanFacility = new Environment(null, null, null);
        oceanFacility.getLocationInfo(5);
        oceanFacility.displayEnvironmentInfo();

        Utility.typeWriter("Carrie guided you through the facility, where it encountered its first new friend. ", 30 );

        Utility.typeWriter("Penguin: (With a gruff voice) Who’s the new guy? ", 30 );
        Utility.typeWriter("Carrie: This is Ricky, our one-eyed penguin. He’s a bit of a grump, but don’t let that scare you. ", 30 );

        MarineLife ricky = new MarineLife(null, null, null, null,null,null,null);
        ricky.getCharacterInfo(11);
        ricky.displayCharacterInfo();

        Utility.typeWriter("You greeted Ricky. ", 30 );
        Utility.typeWriter(turtle.getName() + ": Hi, Ricky… ", 30 );
        Utility.typeWriter("Ricky: (Huffs) Don’t get too comfortable, kid.", 30 );

        Utility.typeWriter("Things are awkward between you and Ricky, why not try to ask him a question? ", 30 );
        Utility.typeWriter("So Ricky... ", 30 );
        Utility.typeWriter("[1] Do penguins fly? ", 30 );
        Utility.typeWriter("[2] What is your favorite food?", 30 );

        askRicky();

        Utility.typeWriter(turtle.getName() + ": Sorry, I was just trying to be friends with you.", 30 );
        Utility.typeWriter("Ricky: Well I don't need friends. I can survive on my own. ", 30 );

        Utility.typeWriter("You looked at him. Even though he's making himself look mad, you can sense that this penguin is still a good person. So you tried again and asked: ", 30 );
        Utility.typeWriter(turtle.getName() + "What happened to your eye?", 30 );

        Utility.typeWriter("Ricky looks at you, he looks like he's really going to get mad! ", 30 );
        Utility.typeWriter("Ricky: Look, how dare you ask that thing to me. Are you underestimating me? ", 30 );
        Utility.typeWriter(turtle.getName() + ": No, no...I was just wondering what happened to you ", 30 );
        Utility.typeWriter("Ricky: Why do you care? ", 30 );
        Utility.typeWriter(turtle.getName() + ": I care because I lost my friends too! I care because I lost my best friends because of humans! ", 30 );

        Utility.typeWriter("Ricky was startled. He toned down his voice and said:", 30 );
        Utility.typeWriter("Ricky: I...I was hunting food with my family. We spotted two men from the distance....At first, my sister thought that it was just one of those photographers that documents life at the Arctic; but we're wrong. ", 30 );
        Utility.typeWriter("One of them shot her with a crossbow. I rushed to help her but she was already dead. I saw my brothers dive into the water. Before I knew, I was shot as well ", 30 );
        Utility.typeWriter("It was so painful but I kept on crawling to reach another ice. Luckily, after they got my sister, they left me alone with the bow still in my eye.", 30 );
        Utility.typeWriter("It was so painful that I passed out. When Carrie and her friends saw me passed out, they took me and treated my wound. The infection spread through my right eye that they had to remove it. ", 30 );
        Utility.typeWriter("Now that you know my story, I think you can now leave me alone.", 30 );

        Utility.typeWriter("Overtime you and Ricky grew closer along with the other animals in the facility. But in quiet moments, you often thought about the ones it lost—Jake, Seb, and Lewis.  ", 30 );

        increaseTurtleAge(3);

        Utility.typeWriter("The day finally came for you to be released back into the wild. Carrie, who had become your guardian and friend, carried it gently to the shore. ", 30 );

        Utility.typeWriter("Carrie: (With a warm smile) Goodbye, little one. Live a happy life out there. And don’t forget to visit me someday, okay? ", 30 );

        Utility.typeWriter("You looked back at Carrie and its friends, grateful for their kindness and support. ", 30 );

        Utility.typeWriter("Ricky: (Teasing) Don’t get eaten out there, kid! ", 30 );

        Utility.typeWriter("With a final wave of your flipper, you swam back into the open ocean. The warmth of its new friends and the lessons it learned carried it forward, closer to its dream of the Bahamas. ", 30 );

        increaseTurtleAge(10);

        updateProgress("Chapter 4 completed.");
    }

    private void askRicky() {
        int choice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter("Ricky: Why do you care? Do turtles like you fly? Why ask that question to someone like me, how about you ask those birds instead?!", 30);
                    break;
                case 2:
                    Utility.typeWriter("Ricky: My favorite food is a cooked turtle who won't shut up and mind its own business", 30);
                    break;
                default:
                    Utility.typeWriter("That's not a valid choice. Please try again.", 30);
            }
        } while (choice < 1 || choice > 2);
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
            stmt.setInt(2, 4); // Chapter 4
            stmt.setString(3, state);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Utility.typeWriter("Error saving progress: " + e.getMessage(), 30);
        }
    }
}
