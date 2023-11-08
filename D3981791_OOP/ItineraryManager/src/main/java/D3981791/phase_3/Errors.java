package D3981791.phase_3;

import java.util.Scanner;

import static java.lang.System.out;

public class Errors {

    static Scanner scanner = new Scanner(System.in);

    public static int IntOnly(String prompt) {
        int input = 0;
        boolean validInput = false;
        do {
            try {
                out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());
                validInput = true;
            } catch (NumberFormatException e) {
                out.println("Error: Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }



    public static String EmptyInput(String prompt) {
        String input = "";
        do {
            out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                out.println("Error: Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }
}
