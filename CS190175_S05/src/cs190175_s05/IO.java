/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s05;

import java.util.Scanner;

/**
 * S05 - Count the number of the appearance of letters in a string. 
 * This class for input operations from user, for getting and validating a string
 * containing only alphabetic characters.
 *
 * @author Nguyen Van Duc Long - CS190175 - 17/1/2025
 */
public class IO {

    /**
     * Prompts the user with a message, validates the input, and ensures that
     * the input contains only alphabetic characters (case insensitive).
     *
     * @param message The message displayed to prompt the user.
     * @return A validated string containing only alphabetic characters.
     */
    public static String getString(String message) {
        // Initialize a Scanner object to read input from the console.
        Scanner sc = new Scanner(System.in);
        String input; // Variable to store user input.
        while (true) {
            try {
                // Display the prompt message.
                System.out.print(message);

                // Read user input
                input = sc.nextLine().trim();

                // Validate the input using a regular expression.
                if (!input.matches("([A-Za-z])+")) {
                    // If the input does not match the format, throw an exception.
                    throw new Exception();
                } else {
                    // If the input is valid, return it.
                    return input;
                }

            } catch (Exception e) {
                // Catch exceptions and display an error message for invalid input.
                System.out.println("Invalid input. Please enter letters");
            }
        }
    }
}
