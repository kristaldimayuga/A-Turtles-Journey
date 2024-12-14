package controllers;

import db.Progress;
import chapter.Chapter1;
import chapter.Chapter2;
import chapter.Chapter3;
import chapter.Chapter4;
import chapter.Chapter5;
import models.Environment;
import models.Turtle;

import static controllers.Game.askToContinue;
import static controllers.Game.returnToMainMenu;


public class GameFlowControl {
    private int playerId;
    private boolean continueGame = true;
    private Turtle turtle;
    private Environment currentEnvironment;
    private int chapter;

    public GameFlowControl(int playerId) {
        this.playerId = playerId;
        this.turtle = turtle;
        this.chapter = 1;
    }

    public void loadSavedGame() {
        Progress progress = new Progress();
        int lastChapter = progress.getPlayerChapterProgress(playerId);

        switch (lastChapter) {
            case 1:
                this.greetings();
                startChapter1();
                break;
            case 2:
                this.greetings();
                startChapter2();
                break;
            case 3:
                this.greetings();
                startChapter3();
                break;
            case 4:
                this.greetings();
                startChapter4();
                break;
            case 5:
                this.greetings();
                startChapter5();
                break;
            default:
                new Game(playerId).startNewGame(); // This will now resolve correctly
                break;
        }
    }

    private void greetings() {
        System.out.println("\nStarting game...\n");
        System.out.println("\n🐢   🐢   🐢\n");
    }

    private void startChapter1() {
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

    private void startChapter2() {
        Chapter2 chapter2 = new Chapter2(playerId);
        chapter2.start();

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
        if (!continueGame) {
            returnToMainMenu();
        }
    }

    private void startChapter3() {
        Chapter3 chapter3 = new Chapter3(playerId);
        chapter3.start();

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
        if (!continueGame) {
            returnToMainMenu();
        }
    }

    private void startChapter4() {
        Chapter4 chapter4 = new Chapter4(playerId);
        chapter4.start();

        continueGame = askToContinue();

        if (continueGame){
            Chapter5 chapter5 = new Chapter5(playerId);
            chapter5.start();
            System.out.println("Proceeding to Chapter 5...");
        }
        if (!continueGame) {
        returnToMainMenu();
        }

    }

    private void startChapter5() {
        Chapter5 chapter5 = new Chapter5(playerId);
        chapter5.start();
        System.out.println("Proceeding to Chapter 5...");
    }


}
