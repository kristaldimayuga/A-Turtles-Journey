// File: game/Game.java
package game;

import menu.MainMenu;
import Chapter.Chapter1;
import Chapter.Chapter2;
import Chapter.Chapter3;
import Chapter.Chapter4;
import Chapter.Chapter5;
import utility.Utility;

public class Game {
    private int playerId;

    public Game(int playerId) {
        this.playerId = playerId;
    }

    public void startNewGame() {
        System.out.println("\nStarting game...\n");
        System.out.println("\n🐢   🐢   🐢\n");

        boolean continueGame = true;

        // Start chapter 1
        Chapter1 chapter1 = new Chapter1(playerId);
        chapter1.start();

        continueGame = askToContinue();

        if (continueGame) {
            Chapter2 chapter2 = new Chapter2(playerId);
            chapter2.start();
            System.out.println("Proceeding to Chapter 2...");

            continueGame = askToContinue();

            if (continueGame) {
                Chapter3 chapter3 = new Chapter3(playerId);
                chapter3.start();
                System.out.println("Proceeding to Chapter 3...");

                continueGame = askToContinue();

                if (continueGame){
                    Chapter4 chapter4 = new Chapter4(playerId);
                    chapter4.start();
                    System.out.println("Proceeding to Chapter 4...");

                    continueGame = askToContinue();

                    if (continueGame){
                        Chapter5 chapter5 = new Chapter5(playerId);
                        chapter5.start();
                        System.out.println("Proceeding to Chapter 5...");
                    }
                }
            }
        }
        if (!continueGame) {
            returnToMainMenu();
        }
    }

    public static boolean askToContinue() {
        while (true) {
            Utility.typeWriter("Would you like to continue to the next chapter? (Y/N): ", 30);
            char choice = Utility.charScanner('Y', 'N');
            if (choice == 'Y') {
                return true;
            } else if (choice == 'N') {
                return false;
            } else {
                Utility.typeWriter("Invalid choice. Please enter 'Y' for Yes or 'N' for No.", 30);
            }
        }
    }

    public static void returnToMainMenu() {
        Utility.typeWriter("Returning to the main menu...\n", 30);
        MainMenu.displayMenu();
    }
}
