package D3981791.phase_2;

import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

public class Errors {

    private Errors() {

    }

    static Scanner scanner = new Scanner(System.in);

    public static int intOnly(String prompt) {
        int input = 0;
        boolean validInput = false;
        do {
            try {
                out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());
                validInput = true;
            } catch (NumberFormatException e) {
                err.println("Error: Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }

    public static int intBetween(String prompt, int min, int max) {
        int input = 0;
        boolean validInput = false;
        do {
            try {
                out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    err.println("Error: Invalid input. Please enter an integer between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                err.println("Error: Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }




    public static String emptyInput(String prompt) {
        String input;
        do {
            out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                err.println("Error: Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }
}
