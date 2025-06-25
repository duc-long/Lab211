/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

import java.util.Scanner;

/**
 * S02 - Reverse a string. This class handles user input and provides validation
 * methods for string processing. Includes methods to get valid strings and
 * handle user decisions like exiting or continuing.
 *
 * @author Nguyen Van Duc Long - CS190175 - 10/1/2025
 */
public class IO {
// Global scanner for user input

    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter a valid string and validates the input. The
     * string must match a specific format: words separated by underscores or
     * spaces.
     *
     * @param messenger The message to display when prompting the user for
     * input.
     * @return A valid input string matching the required format.
     */
    public static String getString(String messenger) {
        String input; // Variable to store user input
        while (true) {
            try {
                // Display the prompt message
                System.out.print(messenger);

                // Read user input
                input = sc.nextLine();

                // Validate the input using a regular expression
                if (!input.matches("(([_ ]*[A-Za-z])+([_ ][A-Za-z]+)*)[_ ]*")) {
                    // If the input does not match the format, throw an exception
                    throw new Exception();
                } else {
                    // If the input is valid, return it
                    return input;
                }

            } catch (Exception e) {
                // Catch exceptions and display an error message for invalid input
                System.out.println("Invalid input. Please enter words separated by underscores or spaces.");
            }
        }
    }

    /**
     * Prompts the user to decide whether to continue or exit. If the user
     * enters "ESC", the method returns true to indicate an exit. If the user
     * presses Enter (empty input), the method returns false to continue.
     *
     * @param messenger The message to display when prompting the user for a
     * decision.
     * @return True if the user decides to exit (by entering "ESC"), false
     * otherwise.
     */
    public static boolean checkPress(String messenger) {
        String input; // Variable to store user input
        while (true) {
            // Display the prompt message
            System.out.print(messenger);

            // Read user input and trim any surrounding whitespace
            input = sc.nextLine().trim();

            // If the user enters "ESC" (case-insensitive), return true
            if (input.equalsIgnoreCase("ESC")) {
                return true;
            }

            // If the input is empty, return false to indicate continuation
            if (input.isEmpty()) {
                return false;
            }

            // If the input is invalid (not "ESC" or empty), prompt again
        }
    }
}
