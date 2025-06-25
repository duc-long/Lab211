/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v04;

import java.util.Scanner;

/**
 * V04 - ID: FA21_09 - Doctor Management Program. This class handles input and
 * output operations for the Doctor Management System. It provides methods for
 * Displaying the main menu Validating different types of user input (text,
 * numbers, and formatted data) - Ensuring correct input values before
 * processing
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class IO {

    // Create a Scanner object to read input from the keyboard
    private static Scanner sc = new Scanner(System.in);

    /**
     * Retrieves a valid menu option from the user.
     *
     * @param message The prompt message for input
     * @param errorMessage The error message if input is invalid
     * @return A valid menu option (integer between 1 and 5)
     */
    public static int getMenuOption(String message, String errorMessage) {
        int option;
        while (true) {
            try {
                System.out.print(message); // Prompt user for input
                option = Integer.parseInt(sc.nextLine().trim()); // Parse input to integer

                // Validate input to ensure it is within valid options (1-6)
                if (option > 6 || option < 1) {
                    System.out.println(errorMessage); // If input is invalid, show error message
                } else {
                    break;  // Exit the loop if a valid option is entered.
                }
            } catch (Exception e) {
                System.out.println(errorMessage); // Catch invalid inputs and show error message
            }
        }

        return option; // Return the valid option selected by the user.
    }

    /**
     * Checks if a given string contains at least one letter.
     *
     * @param input The string to check
     * @return true if the string contains a letter, false otherwise
     */
    public static boolean isContainLetter(String input) {
        int inputLength = input.length(); // Get the length of the input string

        for (int i = 0; i < inputLength; ++i) {
            if (Character.isAlphabetic(input.charAt(i))) { // Check if the character is a letter
                return true; // Return true if at least one letter is found
            }
        }

        return false; // Return false if no letter is found
    }

    /**
     * Gets and validates the doctor's code.
     *
     * @param message The prompt message for input.
     * @param errorMessage The error message displayed if input is invalid.
     * @return A valid doctor code.
     */
    public static String getDoctorCode(String message, String errorMessage) {
        String code;
        String regex = "^[A-Za-z0-9 ]+$";   // Allows letters, numbers, and spaces
        while (true) {
            System.out.print(message);
            code = sc.nextLine().trim().toUpperCase();  // Convert input to uppercase
            // Handle empty input
            if (code.isEmpty()) { // Ensure the code contains at least one letter
                System.out.println("Code is empty. Please enter code.");
                continue;
            }

            if (code.matches(regex)) {
                if (!isContainLetter(code)) {  // Ensure at least one letter is present
                    System.out.println("Code must contain at least 1 letter.");
                    continue;
                }
                break; // Exit loop if code is valid
            } else {
                System.out.println(errorMessage);
            }
        }

        return code; // Return the valid doctor code
    }

    /**
     * Gets and validates the doctor's name.
     *
     * @param message The prompt message for input.
     * @param errorMessage The error message displayed if input is invalid.
     * @return A valid doctor name.
     */
    public static String getDoctorName(String message, String errorMessage) {
        String name;
        String regex = "^[a-zA-Z ]+$"; // Regex pattern: Only letters and spaces allowed
        while (true) {
            System.out.print(message);
            name = sc.nextLine().trim();

            // Handle empty input
            if (name.isEmpty()) {
                System.out.println("Name is empty. Please enter name.");
                continue;
            }

            if (name.matches(regex)) {
                break;  // Exit loop if name is valid
            } else {
                System.out.println(errorMessage);
            }
        }

        return name; // Return the valid name
    }

    /**
     * Gets and validates the doctor's specialization.
     *
     * @param message The prompt message for input.
     * @param errorMessage The error message displayed if input is invalid.
     * @return A valid doctor specialization.
     */
    public static String getDoctorSpecialization(String message, String errorMessage) {
        String specialization;
        String regex = "^[a-zA-Z ]+$"; // Only letters and spaces allowed
        while (true) {
            System.out.print(message);
            specialization = sc.nextLine().trim();
            //Check empty
            if (specialization.isEmpty()) {
                System.out.println("Specialization is empty. Please enter specialization.");
                continue;
            }

            // Handle empty input
            if (specialization.matches(regex)) {
                break;  // Exit loop ifF specialization is valid
            } else {
                System.out.println(errorMessage);
            }
        }

        return specialization; // Return the valid specialization
    }

    /**
     * Gets and validates the doctor's availability.
     *
     * @param message The prompt message for input.
     * @param errorMessage The error message displayed if input is invalid.
     * @return A valid number representing availability.
     */
    public static int getDoctorAvailability(String message, String errorMessage) {
        while (true) { // Loop until a valid input is provided
            try {
                System.out.print(message); // Display the prompt message
                String availability = sc.nextLine().trim(); // Read input and trim whitespace

                // Check if input is empty
                if (availability.isEmpty()) {
                    System.out.println("Availability cannot be empty. Please enter a valid number.");
                    continue; // Continue the loop to ask for input again
                }

                // Convert input string to an integer
                int number = Integer.parseInt(availability);

                // Ensure the number is non-negative
                if (number < 0) {
                    System.out.println("Availability must be a non-negative integer.");
                    continue; // Continue the loop to ask for input again
                }

                return number; // Return the valid availability value

            } catch (NumberFormatException e) { // Catch invalid number input
                System.out.println(errorMessage); // Display the error message
            }
        }
    }

    /**
     * Gets an updated doctor's name, allowing an empty input.
     *
     * @param message The prompt message.
     * @param errorMessage The error message if input is invalid.
     * @return A valid doctor name or an empty string.
     */
    public static String getUpdateDoctorName(String message, String errorMessage) {
        String name;
        String regex = "^[a-zA-Z ]+$"; // Regular expression to ensure the input contains only letters and spaces

        while (true) {
            System.out.print(message);
            name = sc.nextLine().trim(); // Read input and remove leading/trailing spaces

            if (name.isEmpty()) {
                return name; // Return an empty string if no input is provided
            }

            if (name.matches(regex)) {
                break; // If input matches the regex, exit the loop
            } else {
                System.out.println(errorMessage); // Print error message for invalid input
            }
        }

        return name; // Return the valid doctor name
    }

    /**
     * Gets an updated doctor's code, allowing an empty input.
     *
     * @param message The prompt message.
     * @param errorMessage The error message if input is invalid.
     * @return A valid doctor code or an empty string.
     */
    public static String getUpdateDoctorCode(String message, String errorMessage) {
        String code;
        String regex = "^[A-Za-z0-9 ]+$"; // Regular expression to allow alphanumeric characters and spaces

        while (true) {
            System.out.print(message);
            code = sc.nextLine().trim().toUpperCase(); // Convert input to uppercase and remove extra spaces

            if (code.isEmpty()) {
                return code; // Return empty string if no input is provided
            }

            if (code.matches(regex)) {
                if (!isContainLetter(code)) { // Ensure the code contains at least one letter
                    System.out.println("Code must contain at least 1 letter.");
                    continue; // Continue prompting if condition is not met
                }
                break; // Exit loop if input is valid
            } else {
                System.out.println(errorMessage); // Print error message for invalid input
            }
        }

        return code; // Return the valid doctor code
    }

    /**
     * Prompts the user to enter a doctor's specialization and validates the
     * input.
     *
     * @param message The prompt message displayed to the user.
     * @param errorMessage The error message displayed if the input is invalid.
     * @return A valid specialization (only letters and spaces) or an empty
     * string if no input is provided.
     */
    public static String getUpdateDoctorSpecialization(String message, String errorMessage) {
        String specialization;
        String regex = "^[a-zA-Z ]+$"; // Regular expression to allow only letters and spaces

        while (true) {
            System.out.print(message);
            specialization = sc.nextLine().trim(); // Read input and remove leading/trailing spaces

            if (specialization.isEmpty()) {
                return specialization; // Return an empty string if no input is provided
            }

            if (specialization.matches(regex)) {
                break; // Exit loop if input is valid
            } else {
                System.out.println(errorMessage); // Print error message for invalid input
            }
        }

        return specialization; // Return the valid specialization
    }

    /**
     * Gets an updated doctor's availability, allowing an empty input.
     *
     * @param message The prompt message.
     * @param errorMessage The error message if input is invalid.
     * @return A valid availability number as a string (or empty if skipped).
     */
    public static int getUpdateDoctorAvailability(String message, String errorMessage) {
        int availability = -1;

        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim(); // Read input and remove leading/trailing spaces

                if (input.isEmpty()) {
                    return availability; // Return an empty string if no input is provided
                }
                availability = Integer.parseInt(input); // Convert input to integer
                if (availability < 0) {
                    System.out.println("Availability must be a positive integer number.");
                    continue; // Continue prompting if input is negative
                }

                break; // Exit loop if input is valid

            } catch (NumberFormatException e) {
                System.out.println(errorMessage); // Print error message if input is not a number
            }
        }

        return availability; // Return the valid availability value
    }

    /**
     * Gets and validates the doctor's search code.
     *
     * @param message The prompt message for input.
     * @param errorMessage The error message displayed if input is invalid.
     * @return A valid doctor code.
     */
    public static String getSearchDoctorCode(String message, String errorMessage) {
        String code;
        String regex = "^[A-Za-z0-9 ]+$";   // Allows letters, numbers, and spaces

        while (true) {
            System.out.print(message);
            code = sc.nextLine().trim().toUpperCase();  // Convert input to uppercase and remove extra spaces

            // If input is empty, return immediately
            if (code.isEmpty()) {
                return code;
            }

            // Check if the input matches the regex pattern
            if (code.matches(regex)) {
                // Ensure the input contains at least one letter
                if (!isContainLetter(code)) {
                    System.out.println("Code must contain at least 1 letter.");
                    continue;  // Prompt the user to enter the code again if no letter is found
                }
                break; // Exit the loop when input is valid
            } else {
                System.out.println(errorMessage);  // Display an error message if input is invalid
            }
        }

        return code; // Return the valid doctor code
    }

}
