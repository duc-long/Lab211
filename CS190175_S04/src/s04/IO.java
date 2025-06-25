/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.util.Scanner;

/**
 * S04 - Check student’s data format.
 *
 * This class provides utility methods for validating and retrieving student
 * input, such as names and marks. It ensures data conforms to specified formats
 * and constraints.
 *
 * @author Nguyen Van Duc Long - CS190175 - 13/1/2025
 */
public class IO {

    // Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompt the user to enter a valid name and validate its format.
     *
     * @param name The label or prompt displayed to the user for input.
     * @return A valid name string that meets the format requirements.
     */
    public static String getName(String name) {
        // Declare a variable to store the user's input.
        String input;

        // Continuously prompt the user until a valid name is entered.
        while (true) {
            try {
                // Display the prompt message for name input.
                System.out.print(name + ":");

                // Read the user's input and remove leading/trailing spaces.
                input = sc.nextLine().trim();

                // Validate the input using a regular expression.
                // The name must contain only letters, spaces, or numbers, and must start with a letter.
                if (!input.matches("^[a-zA-Z]+([ a-zA-Z0-9]+)?$")) {
                    // If the input is invalid, throw a generic exception to handle the error.
                    throw new Exception();
                } else if (input.isEmpty()) {
                    // Check if the input is empty, and display an appropriate error message.
                    System.out.println(name + " must not be empty! Please try again!!");
                } else {
                    // If the input is valid, break out of the loop.
                    break;
                }

            } catch (Exception e) {
                // Display an error message if the input does not meet the requirements.
                System.out.println("You must enter letters, but numbers and spaces are allowed. Please try again!!");
            }
        }

        // Return the validated name.
        return input;
    }

    /**
     * Prompt the user to enter marks and validate their range.
     *
     * @param subject The label or prompt displayed to the user for input.
     * @return A valid mark as a double within the range [0, 10].
     */
    public static double getMarks(String subject) {
        // Declare a variable to store the user's input as a double.
        double mark;

        // Continuously prompt the user until a valid mark is entered.
        while (true) {
            try {
                // Display the prompt message for marks input.
                System.out.print(subject + ":");

                // Read the user's input as a string.
                String input = sc.nextLine();

                // Attempt to parse the input into a double.
                mark = Double.parseDouble(input);

                // Check if the mark is less than 0, and display an error message if true.
                if (mark < 0) {
                    System.out.println(subject + " is greater than or equal to zero");
                } // Check if the mark is greater than 10, and display an error message if true.
                else if (mark > 10) {
                    System.out.println(subject + " is less than or equal to ten");
                } // Check if the input is empty, and throw an exception if true.
                else if (input.isEmpty()) {
                    throw new IllegalArgumentException();
                } // If the input is valid, break out of the loop.
                else {
                    break;
                }

            } catch (IllegalArgumentException e) {
                // Display an error message if the input is not a valid number.
                System.out.println(subject + " is digit");
            }
        }

        // Return the validated mark.
        return mark;
    }

    /**
     * Prompts the user for a confirmation (Yes/No) and returns the response.
     *
     * @param msg The message to display as a prompt for user confirmation.
     * @return `true` if the user enters "N" or "No", `false` if the user enters
     * "Y" or "Yes".
     */
    public static boolean checkPress(String msg) {
        String input; // Variable to store the user's input.

        // Continuously prompt the user until a valid response ("Y", "Yes", "N", or "No") is provided.
        while (true) {
            // Display the provided message to prompt the user.
            System.out.print(msg);

            // Read and trim the user's input to remove leading and trailing whitespace.
            input = sc.nextLine().trim();

            // Check if the input matches "N" or "No" (case-insensitive).
            if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")) {
                return true; // Return true to indicate a negative response.
            }

            // Check if the input matches "Y" or "Yes" (case-insensitive).
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {
                return false; // Return false to indicate a positive response.
            }

            // If the input is invalid, the loop will repeat to prompt the user again.
        }
    }
}
