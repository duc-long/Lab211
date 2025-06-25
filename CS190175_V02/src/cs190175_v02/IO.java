/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v02;

import java.util.Scanner;

/**
 * V02 - ID: FA21_09 - Car Showroom. This class provides methods for handling
 * user input. It includes methods for getting string inputs, numerical prices,
 * and confirming user choices.
 *
 * @author Nguyen Van Duc Long - CS190175 - 9/2/2025
 */
public class IO {

    // Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter a string and validates that it contains only
     * letters.
     *
     * @param msg The message to display before user input.
     * @return The validated string input, converted to uppercase.
     */
    public static String getString(String msg) {
        String input; // Variable to store user input
        while (true) {
            try {
                // Display the prompt message to guide the user
                System.out.print(msg);

                // Read user input and remove leading/trailing spaces
                input = sc.nextLine().trim();

                // Validate input: it must only contain letters (single or double-word format , case Name car 
                //or color is no color)
                if (!input.matches("^[A-Za-z]+( [A-Za-z]+)?$")) {
                    throw new Exception(); // If invalid, throw an exception
                }

                // Ensure input is not empty
                if (input.isEmpty()) {
                    System.out.println("Must not be empty! Please input again!");
                } else {
                    // Convert valid input to uppercase and return it
                    return input.toUpperCase();
                }

            } catch (Exception e) {
                // Display an error message when input is invalid and prompt again
                System.out.println("Invalid input. Please input again!.");
            }
        }
    }

    /**
     * Prompts the user to enter a numeric price and ensures it is not empty.
     *
     * @param msg The message displayed to the user before input.
     * @return The inputted price as a string.
     */
    public static String getNumPrice(String msg) {
        String input; // Variable to store user input
        while (true) {
            // Display the prompt message to guide the user
            System.out.print(msg);

            // Read user input and remove leading/trailing spaces
            input = sc.nextLine().trim();

            // Ensure input is not empty
            if (input.isEmpty()) {
                System.out.println("Must not be empty! Please input again!");
            } else {
                // Return the valid input
                return input;
            }
        }
    }

    /**
     * Checks the user's response to a Yes/No question.
     *
     * @param msg The message displayed to the user before input.
     * @return true if the user inputs "N" or "No", false if they input "Y" or
     * "Yes".
     */
    public static boolean checkPress(String msg) {
        String input; // Variable to store user input.

        // Continuously prompt the user until they enter a valid response ("Y", "Yes", "N", or "No").
        while (true) {
            // Display the prompt message to guide the user
            System.out.print(msg);

            // Read user input and remove leading/trailing spaces
            input = sc.nextLine().trim();

            // Check if the input matches "N" or "No" (case-insensitive)
            if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")) {
                return true; // Return true to indicate a negative response.
            }

            // Check if the input matches "Y" or "Yes" (case-insensitive)
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {
                return false; // Return false to indicate a positive response.
            }

            // If the input is invalid, the loop will repeat to prompt the user again.
        }
    }
}
