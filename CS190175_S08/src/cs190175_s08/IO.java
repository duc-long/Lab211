/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s08;

import java.util.Scanner;

/**
 * Convert hexadecimal, octal to binary. Handles user input validation for
 * converting hexadecimal and octal numbers to binary.
 *
 * @author Nguyen Van Duc Long - CS190175 - 16/2/2025
 */
public class IO {

    // Scanner object for reading user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for input and ensures it follows the correct format. The
     * input must be a valid hexadecimal (ending with 'H') or octal number
     * (ending with 'Q').
     *
     * @param msg The prompt message displayed to the user.
     * @return A valid input string in the correct format.
     */
    public static String getValidInput(String msg) {
        String input;

        while (true) {
            System.out.print(msg);  // Display prompt message
            input = sc.nextLine().trim().toUpperCase();  // Read and process user input

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Must not be empty! Please enter again.");
                continue;  // Restart loop to prompt user again
            }

            String value = input.substring(0, input.length() - 1);  // Extract numeric part

            // Validate hexadecimal input (must contain only 0-9 and A-F)
            if (input.endsWith("H")) {
                boolean isValid = true;
                for (char c : value.toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    return input;  // Return valid input
                } else {
                    System.out.println("Invalid Hexadecimal input! Only 0-9 and A-F are allowed.");
                    continue;  // Restart loop
                }
            }

            // Validate octal input (must contain only 0-7)
            if (input.endsWith("Q")) {
                boolean isValid = true;
                for (char c : value.toCharArray()) {
                    if (!(c >= '0' && c <= '7')) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    return input;  // Return valid input
                } else {
                    System.out.println("Invalid Octal input! Only digits 0-7 are allowed.");
                    continue;  // Restart loop
                }
            }

            // If input does not end with 'H' or 'Q', print error and prompt again
            System.out.println("Invalid input format! The number must end with 'H' (Hex) or 'Q' (Octal).");
        }
    }

    /**
     * Prompts the user to press a key and determines if they entered anything.
     *
     * @param msg The prompt message displayed to the user.
     * @return `true` if the user pressed any key, `false` if input was empty.
     */
    public static boolean getPress(String msg) {
        System.out.print(msg);  // Display prompt message
        String input = sc.nextLine().trim();  // Read user input
        return !input.isEmpty();  // Return true if input is not empty, otherwise return false
    }
}
