/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v06;

import java.util.Scanner;

/**
 * Array and string manipulations. The IO class handles input validation and
 * ensures proper formatting of student names. It includes methods to check if a
 * name is valid and properly formatted.
 *
 * @author Nguyen Van Duc Long - CS190175 - 2/3/2025
 */
public class IO {

    // A static Scanner object to handle user input.
    private static Scanner sc = new Scanner(System.in);

    /**
     * Validates if a name meets the required conditions: 1. The name must
     * contain at least two words. 2. Each word must have at least two
     * characters.
     *
     * @param name The input name string from the user.
     * @return true if the name is valid, false otherwise.
     */
    private static boolean isValidName(String name) {
        // Split the name into words based on spaces.
        String[] words = name.split(" ");

        // Check if the name has at least two words.
        if (words.length < 2) {
            System.out.println("Name must contain at least 2 words. Please enter again.");
            return false; // Invalid if fewer than 2 words.
        }
        return true; // Valid if the conditions are met.
    }

    /**
     * Ensures the input name contains only letters and spaces. This method
     * repeatedly prompts the user until a valid name is entered.
     *
     * @param msg The message to display when prompting the user.
     * @return A valid student name with proper capitalization.
     */
    public static String checkInputName(String msg) {
        String result; // Variable to store user input.

        // Loop until a valid name is entered.
        while (true) {
            System.out.print(msg); // Display prompt message.
            result = sc.nextLine().trim(); // Read user input and remove extra spaces.

            // Check if the input consists only of letters and spaces.
            if (result.matches("^[a-zA-Z ]+$")) {
                if (isValidName(result)) {
                    // Convert the entire name to lowercase for standardization.
                    result = result.toLowerCase();
                    String[] words = result.split("\\s+"); // Split the name into words.

                    // Capitalize the first letter of each word.
                    for (int i = 0; i < words.length; i++) {
                        if (!words[i].isEmpty()) {
                            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                        }
                    }

                    // Join words with a single space and return the formatted name.
                    return String.join(" ", words);
                }
            } else {
                // Display error and prompt the user to re-enter.
                System.out.println("Name can only contain letters and spaces.");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Gets and validates the student's search name.
     *
     * @param msg The prompt message for input.
     * @return The valid student name.
     */
    public static String getSearchName(String msg) {
        String name;
        String regex = "^[A-Za-z ]+$";   // Allows letters, spaces

        while (true) {
            System.out.print(msg);
            name = sc.nextLine().trim();  // Convert input to remove extra spaces

            // If input is empty, return immediately
            if (name.isEmpty()) {
                return name;
            }

            // Check if the input matches the regex pattern
            if (name.matches(regex)) {
                break; // Exit the loop when input is valid
            } else {
                System.out.println("Name can only contain letters");  // Display an error message if input is invalid
            }
        }

        return name; // Return the valid student name
    }
}
