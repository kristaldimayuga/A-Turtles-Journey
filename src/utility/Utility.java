package utility;

import java.util.Scanner;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    public static void typeWriter(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static char charScanner(char validOption1, char validOption2) {
        char input = '\0';
        while (true) {
            System.out.print("Enter [" + validOption1 + "/" + validOption2 + "]: ");
            input = scanner.nextLine().trim().toUpperCase().charAt(0);
            if (input == validOption1 || input == validOption2) {
                break;
            } else {
                typeWriter("Invalid input. Please try again.", 30);
            }
        }
        return input;
    }

    public static void pressEnter() {
        System.out.print("\nPress 'Enter' to continue...");
        scanner.nextLine();
    }

    public static int intScanner() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                typeWriter("Invalid number. Please enter a valid integer.", 30);
            }
        }
    }

    // New method to capture any user input as a string
    public static String getUserInput() {
        System.out.print("Your answer: ");
        return scanner.nextLine().trim();
    }
}
