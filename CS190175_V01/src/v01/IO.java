/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

import java.util.Scanner;

/**
 * V01 - LuckyGame - ID: FA21_03 This class provides utility methods for
 * validating and retrieving user input, ensuring that the input meets specific
 * constraints before it is processed.
 *
 * @author Nguyen Van Duc Long - CS190175 -15/1/2025
 */
public class IO {

    // Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Enter input data and repeat until a valid integer is entered.
     *
     * @param message
     * @return n The integer value is entered by user.
     *
     */
    public static int getInteger(String message) {
        int number;
        while (true) {
            try {
                System.out.print(message); // Display the prompt message to the user
                String input = sc.nextLine(); // Read the entire line of input

                number = Integer.parseInt(input); // Parse the input to an integer

                // Check if the integer is negative or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number < 0 || input.trim().isEmpty()) {
                    throw new IllegalArgumentException();
                } else if (number > 100) {
                    System.out.println("You must enter an integer(0-100)!");
                }

                return number; // Return a valid number
            } catch (NumberFormatException e) {
                // If the input string cannot be converted to an integer, catch the exception
                // and print an error message, force user re-input
                System.out.println("You must enter an integer(0-100)!");
            } catch (IllegalArgumentException e) {
                // If a negative number is entered, catch the exception, 
                // print an error message, force user re-input
                System.out.println("You must enter a positive integer!");
            }
        }
    }

    /**
     * Prompts the user for a confirmation (Yes/No) and returns the response.
     *
     * @param msg The message to display as a prompt for user confirmation.
     * @return true if the user enters "N" or "No", `false` if the user enters
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
