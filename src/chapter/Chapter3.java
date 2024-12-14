package chapter;

import db.DatabaseConnection;
import utility.Utility;
import events.Quiz;
import models.MarineLife;
import models.Turtle;
import models.Environment;
import models.Obstacle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chapter3 extends Chapter{
    private Turtle turtle;

    public Chapter3(int playerId) {
        super(playerId);
        this.turtle = new Turtle(playerId); // Pass playerId to Turtle constructor
    }

    @Override
    public void start() {
        Utility.typeWriter("-".repeat(50), 30);
        Utility.typeWriter("\nChapter 3: Lost in the Cold Currents\n", 30);
        Utility.typeWriter("-".repeat(50), 30);

        Utility.typeWriter("\nThe two young turtles, filled with wonder and excitement, ventured further into the vast ocean.", 30 );
        Utility.typeWriter("Their journey led them to the vibrant waters off the coast of Argentina, where the rhythmic sound of waves accompanied their curious gazes. ", 30 );

        Utility.typeWriter("\n\nJake: Look, Jake! What’s that? ", 30 );
        Utility.typeWriter("[1] Whale ", 30 );
        Utility.typeWriter("[2] Shark ", 30 );
        Utility.typeWriter("[3] Dynamite", 30 );

        whatIsThat();

        turtle.getTurtleName();
        Utility.typeWriter(turtle.getName() + ": Let’s follow it! I want to know more about them. ", 30 );

        Utility.typeWriter("\n\nAs the turtles swam closer, the ship suddenly stopped. The once-bright ocean began to turn black, thick, and suffocating. ", 30 );
        Utility.typeWriter("The scent was unbearable, and the water felt heavy. ", 30 );

        Utility.typeWriter("\nJake: (Jittery) What’s happening?! ", 30 );

        Utility.typeWriter("\n\nA black think liquid dropped into your hands. You looked at it and tried to eat it.", 30 );

        Utility.typeWriter(turtle.getName() + "It’s… oil! We have to get out of here! ", 30 );

        Obstacle oilSpill = new Obstacle(2);
        oilSpill.loadHazards();
        oilSpill.displayHazards();

        Utility.typeWriter("QUICK! SWIM AS FAST AS YOU CAN (W)", 0 );
        Utility.charScanner('W','w');

        Utility.typeWriter("SWIM FASTER!! (W) ", 0 );
        Utility.charScanner('W','w');

        Utility.typeWriter("TURN LEFT! (A) ", 0 );
        Utility.charScanner('A','a');

        Utility.typeWriter("TURN RIGHT! (D) ", 0 );
        Utility.charScanner('D','d');

        Utility.typeWriter("THERE'S A LITTLE CAVE AT THE CORNER", 10 );
        Utility.typeWriter("HIDE INSIDE THE CAVE (H) ", 10 );
        Utility.charScanner('H','h');

        Utility.typeWriter("Amid the chaos, the two friends were separated by the spreading oil. Desperately calling out for each other, their voices drowned in the oily currents.", 30 );

        Utility.typeWriter("Whoo! That was close!", 30 );
        Utility.typeWriter("You are now safe ", 30 );

        oilSpill.afterHazards(new Turtle(playerId));

        Utility.typeWriter(turtle.getName() + ": (Screaming) Jake! Jake, where are you?! ", 30 );

        Utility.typeWriter("You looked everywhere and asked some creatures along the way", 30 );
        Utility.typeWriter("A week passed...", 30 );
        Utility.typeWriter("Jake was nowhere to be seen. With no other choice, the turtle swam through the murky water, desperate to find safety. ", 30 );


        Utility.typeWriter("After hours of struggling, the turtle stumbled upon a desolate beach, its shores abandoned and quiet.", 30 );

        Environment beach = new Environment (null, null, null);
        beach.getLocationInfo(3);
        beach.displayEnvironmentInfo();

        Utility.typeWriter("Weak and weary, the turtle crawled onto the sand, where it encountered unexpected allies. ", 30 );

        Utility.typeWriter("Crab: (Startled) Whoa! A turtle? What are you doing here? ", 30 );
        Utility.typeWriter(turtle.getName() + ": Please help me, I'm "+ turtle.getHealth(), 30 );
        Utility.typeWriter("Crab: Don't worry, you're safe now. I'm Seb", 30 );

        MarineLife seb = new MarineLife(null,null,null,null,null,null,null);
        seb.getCharacterInfo(7);
        seb.displayCharacterInfo();

        Utility.typeWriter(turtle.getName() + ": (Coughing) I… I got lost. There was oil everywhere. ", 30 );

        Utility.typeWriter("A dog run towards you and Seb. ", 30 );

        Utility.typeWriter("Dog: : (Bounding in excitement) New friend! New friend! Hey, what’s your name? I'm Lewis!", 30 );

        MarineLife lewis = new MarineLife(null,null,null,null,null,null,null);
        lewis.getCharacterInfo(8);
        lewis.displayCharacterInfo();

        Utility.typeWriter("You told Seb and Lewis about your situation ", 30 );


        Utility.typeWriter("Lewis: That's horrible! I hope your friend is okay", 30 );
        Utility.typeWriter("Seb: Oil spill are accidents, but its increasing number just harm the marine creatures and reefs ", 30 );
        Utility.typeWriter("Lewis: Good thing you did not pass out or die, those chemicals are very harmful to us. Even to humans... ", 30 );
        Utility.typeWriter("Seb: (Looking worried) You don’t look so good. Let’s get you some rest. ", 30 );
        Utility.typeWriter("Lewis: You can stay with us. No one goes here but there are still some food here in the beach. ", 30 );

        Utility.typeWriter("Over the next few days, Seb the crab and Lewis the stray dog helped the turtle recover.  ", 30 );
        Utility.typeWriter("Seb, with his sharp mind, taught the turtle survival tactics, while Lewis brought a sense of joy and playfulness to their island refuge. ", 30 );

        increaseTurtleAge(1);

        Utility.typeWriter("One day, while the three of you are walking across the shore, you asked them their life before inhabiting the abandoned beach. ", 30 );
        Utility.typeWriter(turtle.getName() + ": So tell me, how did you two meet? I feel like it's been a while when you guys are still interacting with humans. ", 30 );
        Utility.typeWriter("Seb: Well for me, I just happen to be born here. Before, this beach is a place for people to spend their vacation in.", 30 );
        Utility.typeWriter("There are still hotels and huts located in some areas. It is not so populated and peaceful enough.", 30 );
        Utility.typeWriter("Whenever they see me and my siblings, they always have two things in mind. That is to run away or eat us. Good thing I was so little back then, they did not even think of making me their dinner. ", 30 );
        Utility.typeWriter("I get it, we usually get defensive but were also scared. Were a very popular delicacy in restaurants. As years went by, the businesses here started to crumble.", 30 );
        Utility.typeWriter("It remained to be visited by some for a while, even without the establishments. It just goes down every year because it was poorly maintained. ", 30 );

        Utility.typeWriter(turtle.getName() + ": What about you Lewis? ", 30 );

        Utility.typeWriter("Seb: Lewis is the real deal", 30 );
        Utility.typeWriter("Lewis: Okay so, my owner was one of the employees in one of the resorts here. After he lost his job he just left me here.", 30 );
        Utility.typeWriter(turtle.getName() + ": He left you? Why did he do that? ", 30 );
        Utility.typeWriter("Lewis: The thing is I memorized the route back home, but after I got there, I saw how sad his family are and I understood that he  can't take care of someone like me anymore. ", 30 );
        Utility.typeWriter("I tried to show myself to him a couple of times but I'm worried of how will he react if he see me again. ", 30 );
        Utility.typeWriter("He was a kind man and I understand that what he did was for the better. ", 30 );
        Utility.typeWriter("I learned how to live on my own, I scavenged food, take a bath on the beach, and make myself happy even if no one wants to play with me anymore.  ", 30 );
        Utility.typeWriter("Last week, I visited his place again, it looks like they're doing great. ", 30 );
        Utility.typeWriter("But I can't help myself to wonder and dream for a world where he and I don't have to worry about money. ", 30 );
        Utility.typeWriter("I miss him and the bond we share, sometimes it hurts to realize that you had been abandoned like this beach. ", 30 );
        Utility.typeWriter("But I guess there's nothing more comforting than seeing abandoned places and things trying to co-exist. ", 30 );
        Utility.typeWriter("This beach is my home while the animals here are my friends. I lost my owner but I gained some new and special ones too you know. ", 30 );
        Utility.typeWriter("Without each other, we would be nothing.", 30 );

        Utility.typeWriter(turtle.getName() + ": Wow that was: ", 30 );
        Utility.typeWriter("[1] Horrific ", 30 );
        Utility.typeWriter("[2] Exciting", 30 );
        Utility.typeWriter("[3] Sad", 30 );

        reaction();

        Utility.typeWriter("Seb: Okay folks, it's getting dark now, we need to head back to our shelter. (S)", 30 );
        Utility.charScanner('S','s');

        Utility.typeWriter("As you, Seb, and Lewis sleep, the danger revealed itself. A group of poachers arrived on the beach, their nets and traps ready for any marine life they could find. ", 30 );

        Utility.typeWriter("Seb: Wake up, it's the poachers, they're coming! ", 30 );
        Utility.typeWriter("Lewis: Turtle, you need to leave. Now! ", 30 );
        Utility.typeWriter("Seb: (Firmly) If you stay, you’ll be caught too. Go! Find safety, find your friend. ", 30 );

        Utility.pressEnter();
        System.out.println();

        Utility.typeWriter("With a heavy heart, the turtle swam back into the cold, unwelcoming sea. The cries of its friends faded as it ventured deeper into the unknown. ", 30 );

        increaseTurtleAge(5);

        Utility.typeWriter(".....🌊🌊🌊🌊🌊..... ", 30 );

        Utility.typeWriter("The temperature dropped with every passing moment. The turtle’s small body shivered in the icy waters of the Drake Passage. Desperate for warmth, it clung to a floating refrigerator, its strength waning with each passing hour. ", 30 );

        Environment drakePassage = new Environment (null, null, null);
        drakePassage.getLocationInfo(4);
        drakePassage.displayEnvironmentInfo();


        Utility.typeWriter("Weak and cold, you noticed a huge whale swimming beside you.", 30 );

        MarineLife judy = new MarineLife(null,null,null,null,null,null,null);
        judy.getCharacterInfo(9);
        judy.displayCharacterInfo();

        Utility.typeWriter("Judy: (A deep, gentle voice) You don’t belong here, little one. These waters are too cold for you. ", 30 );
        Utility.typeWriter("Judy: (Sadly) You won’t last long in this cold. If you stay here, you’ll… ", 30 );

        Utility.typeWriter("Before Judy could finish, the turtle, overwhelmed by exhaustion and hopelessness, collapsed onto the refrigerator. ", 30 );

        Utility.typeWriter(turtle.getName() + ": (Whispering) Jake… I just want to see you one last time… ", 30 );
        Utility.typeWriter("The turtle’s small form lay still on the floating refrigerator, surrounded by the endless white of the Drake Passage. Its journey was far from over, but for now, the vast ocean held its breath. ", 30 );

        updateProgress("Chapter 3 completed.");
    }

    private void reaction(){
        int choice;
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter("Lewis: Yeah I guess...I don't want that to happen to others. It's absolutely difficult! kinda scary too", 30);
                    break;
                case 2:
                    Utility.typeWriter("Lewis: Really, you find that exciting? That's so cool you have a very positive point of vew then", 30);
                    break;
                case 3:
                    Utility.typeWriter("Lewis: A lot of animals said that too, but hey, we gotta keep on  living you know", 30);
                    break;
                default:
                    Utility.typeWriter("That's not a valid choice. Please try again.", 30);
            }
        } while (choice < 1 || choice > 3);
    }

    private void whatIsThat(){
        int choice;
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = Utility.intScanner();

            switch (choice) {
                case 1:
                    Utility.typeWriter("I think it's a huge whale", 30);
                    break;
                case 2:
                    Utility.typeWriter("A huge shark", 30);
                    break;
                case 3:
                    Utility.typeWriter("A big dynamite", 30);
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
