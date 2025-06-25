/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s09;

import java.util.Scanner;

/**
 * Remove unnecessary blank in a string. The IO class provides methods for user
 * input validation. It includes functions to read and validate user input,
 * ensuring correct formatting and preventing unwanted characters.
 *
 * @author Nguyen Van Duc Long - CS190175 - 24/2/2025
 */
public class IO {

    //Global scanner input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter a valid string and validates the input. The
     * string must not contain special characters such as @, #, !, [, ], {, },
     * (, ).
     *
     * @param messenger The message to display when prompting the user for
     * input.
     * @return A valid input string that does not contain special characters.
     */
    public static String getString(String messenger) {
        String input; // Variable to store user input
        while (true) {
            try {
                // Display the prompt message
                System.out.print(messenger);

                // Read user input
                input = sc.nextLine().trim();

                // Validate the input using a regular expression
                if (input.matches(".*[@#!\\[\\]{}()]+.*")) {
                    // If the input contains forbidden characters, throw an exception
                    throw new Exception();
                } else {
                    // If the input is valid, return it
                    return input;
                }

            } catch (Exception e) {
                // Display an error message for invalid input
                System.out.println("Error: Special characters such as @, #, !, [, ], {, }, (, ) are not allowed.");
            }
        }
    }

    /**
     * Prompts the user for a confirmation (Yes/No) and returns the response.
     *
     * @param msg The message to display when prompting the user.
     * @return `true` if the user enters "N" or "No", `false` if the user enters
     * "Y" or "Yes".
     */
    public static boolean checkInputYN(String msg) {
        String input; // Variable to store the user's input.

        // Continuously prompt the user until a valid response ("Y", "Yes", "N", or "No") is provided.
        while (true) {
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

            // If the input is invalid, prompt the user again.
            System.out.println("Invalid input! Please enter Y/Yes or N/No.");
        }
    }
}
