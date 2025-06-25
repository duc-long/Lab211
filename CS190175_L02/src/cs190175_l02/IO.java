/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_l02;

import java.util.Scanner;

/**
 * L02 - Manage students. This class provides validation methods for user input,
 * ensuring correct data format and constraints. The class includes: Menu
 * display, Input validation for names, IDs, semesters, and courses.
 * Confirmation checks for Yes/No and Update/Delete prompts, Range validation
 * for number inputs
 *
 * @author Nguyen Van Duc Long - CS190175 -18/2/2025
 */
public class IO {

    //Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Displays the main menu options for student management.
     */
    public static void displayMenu() {
        System.out.println(" 1. Create");
        System.out.println(" 2. Find and Sort");
        System.out.println(" 3. Update/Delete");
        System.out.println(" 4. Report");
        System.out.println(" 5. Exit");
        System.out.print(" Enter your choice: ");
    }

    /**
     * Prompts the user for a confirmation (Yes/No) and returns the response.
     *
     * @return `true` if the user enters "N" or "No", `false` if the user enters
     * "Y" or "Yes".
     */
    public static boolean checkInputYN() {
        String input; // Variable to store the user's input.

        // Continuously prompt the user until a valid response ("Y", "Yes", "N", or "No") is provided.
        while (true) {

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

    /**
     * Prompts the user for Update/Delete confirmation.
     *
     * @return `true` for "U" (Update), `false` for "D" (Delete).
     */
    public static boolean checkInputUD() {
        String input; // Variable to store the user's input.

        while (true) {

            // Read and trim the user's input to remove leading and trailing whitespace.
            input = sc.nextLine().trim();
            // Check if the input matches "" or "Update" (case-insensitive).
            if (input.equalsIgnoreCase("U") || input.equalsIgnoreCase("Update")) {
                return true; // Return true to indicate a negative response.
            }
            // Check if the input matches "D" or "Delete" (case-insensitive).
            if (input.equalsIgnoreCase("D") || input.equalsIgnoreCase("Delete")) {
                return false; // Return false to indicate a positive response.
            }

            // If the input is invalid, the loop will repeat to prompt the user again.
        }
    }

    /**
     * Checks if a given string contains at least one letter.
     *
     * @param input The string to check.
     * @return `true` if at least one letter is found, `false` otherwise.
     */
    public static boolean isContainLetter(String input) {
        int inputLength = input.length(); // Get the length of the input string
        // Iterate through each character in the string.   
        for (int i = 0; i < inputLength; ++i) {
            if (Character.isAlphabetic(input.charAt(i))) { // Check if the character is a letter
                return true; // Return true if at least one letter is found
            }
        }
        return false; // Return false if no letter is found
    }

    /**
     * Validates and returns a student ID that must contain only letters,
     * numbers, and spaces.
     *
     * @param message The prompt message for user input.
     * @param errorMessage The error message to display if validation fails.
     * @return A valid student ID.
     */
    public static String getID(String message, String errorMessage) {
        String id;
        String regex = "^[A-Za-z0-9 ]+$";   // Regex pattern to allow letters, numbers, and spaces.

        while (true) {
            System.out.print(message);
            id = sc.nextLine().trim().toUpperCase(); // Read and trim user input uppercase.

            // Check if the input matches the allowed pattern.
            if (id.matches(regex)) {
                if (!isContainLetter(id)) {  // Ensure at least one letter is present in ID.
                    System.out.println("ID must contain at least 1 letter.");
                    continue; // Repeat input prompt.
                }
                break; // Exit loop if ID is valid.
            } else {
                System.out.println(errorMessage);  // Display error message for invalid input.
            }
        }
        return id; // Return the valid ID.
    }

    /**
     * Ensures the input name contains only letters and spaces. This method
     * repeatedly prompts the user until a valid name is entered.
     *
     * @return A valid student name containing only letters and spaces.
     */
    public static String checkInputName() {
        String result; // Variable to store user input.

        // Loop indefinitely until the user enters a valid name.
        while (true) {
            result = sc.nextLine().trim(); // Read input from the user and remove extra spaces.

            // Check if the input consists only of letters (uppercase/lowercase) and spaces.
            if (result.matches("^[a-zA-Z ]+$")) {
                // Standardize the name by capitalizing the first letter of each word.
                result = result.toLowerCase(); // Convert the whole name to lowercase.
                String[] words = result.split("\\s+"); // Split the name into words, handling multiple spaces.

                // Capitalize the first letter of each word.
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].isEmpty()) {
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                    }
                }

                // Join the words back together with a single space and return the result.
                return String.join(" ", words);
            } else {
                // Display an error message and prompt the user to re-enter the name.
                System.out.println("Name can only contain letters and spaces.");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Ensures that the input semester is a valid numeric value. This method
     * continuously prompts the user until they enter a valid number.
     *
     * @return A valid semester as a numeric string.
     */
    public static String checkInputSemester() {
        String result; // Variable to store user input.

        // Loop indefinitely until the user enters a valid numeric semester.
        while (true) {
            result = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.

            // Check if the input consists only of numeric digits (0-9). Semester 0-9
            if (result.matches("^[0-9]$")) {
                break; // Exit the loop if the input is valid.
            } else {
                // Display an error message and prompt the user to re-enter a valid semester.
                System.out.println("Semester must be a number (0-9).");
                System.out.print("Enter again: ");
            }
        }
        return result; // Return the validated semester.
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
                // Ensure the input contains at least one letter
                break; // Exit the loop when input is valid
            } else {
                System.out.println("Name can only contain letters");  // Display an error message if input is invalid
            }
        }

        return name; // Return the valid student name
    }

    /**
     * Ensures that the updated input name contains only letters and spaces. If
     * the user enters an empty input, the current name is retained. The method
     * continuously prompts until a valid name is provided.
     *
     * @param currentName The current student name that will be retained if no
     * new input is given.
     * @return A valid updated name containing only letters and spaces, or the
     * original name if no input is provided.
     */
    public static String checkUpdateInputName(String currentName) {
        String result; // Variable to store user input.

        // Loop indefinitely until the user enters a valid name or chooses to keep the existing name.
        while (true) {
            result = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.

            // If the user presses Enter without providing input, return the existing name.
            if (result.isEmpty()) {
                return currentName;
            }

            // Check if the input consists only of letters (uppercase/lowercase) and spaces.
            if (result.matches("^[a-zA-Z ]+$")) {
                // Standardize the name by capitalizing the first letter of each word.
                result = result.toLowerCase(); // Convert the whole name to lowercase.
                String[] words = result.split("\\s+"); // Split the name into words, handling multiple spaces.

                // Capitalize the first letter of each word.
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].isEmpty()) {
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                    }
                }

                // Join the words back together with a single space and return the result.
                return String.join(" ", words);
            } else {
                // Display an error message and prompt the user to re-enter a valid name.
                System.out.println("Name can only contain letters and spaces.");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Ensures that the updated input semester is a valid numeric value. If the
     * user enters an empty input, the current semester is retained. The method
     * continuously prompts until a valid semester number is provided.
     *
     * @param currentSemester The current semester that will be retained if no
     * new input is given.
     * @return A valid updated semester as a numeric string, or the original
     * semester if no input is provided.
     */
    public static String checkUpdateInputSemester(String currentSemester) {
        String result; // Variable to store user input.

        // Loop indefinitely until the user enters a valid semester or chooses to keep the existing semester.
        while (true) {
            result = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.

            // If the user presses Enter without providing input, return the existing semester.
            if (result.isEmpty()) {
                return currentSemester;
            }

            // Check if the input consists only of numeric digits (0-9). Semester 0-9
            if (result.matches("^[0-9]$")) {
                break; // Exit the loop if the input is valid.
            } else {
                // Display an error message and prompt the user to re-enter a valid semester.
                System.out.println("Semester must be a number (0-9).");
                System.out.print("Enter again: ");
            }
        }
        return result; // Return the valid updated semester.
    }

    /**
     * Ensures that the input course is one of the predefined valid course
     * names. The method continuously prompts the user until a valid course is
     * provided.
     *
     * @return A valid course name ("Java", ".Net", or "C/C++").
     */
    public static String checkInputCourse() {
        // Loop indefinitely until the user enters a valid course name.
        while (true) {
            String result = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.

            // Check if the input matches one of the three allowed course names (case-insensitive).
            if (result.equalsIgnoreCase("Java")) {
                return "Java"; // Return "Java" in the correct format.
            } else if (result.equalsIgnoreCase(".Net")) {
                return ".Net"; // Return ".Net" in the correct format.
            } else if (result.equalsIgnoreCase("C/C++")) {
                return "C/C++"; // Return "C/C++" in the correct format.
            }

            // Display an error message and prompt the user to enter a valid course name.
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Ensures that the input course is one of the predefined valid course
     * names. The method continuously prompts the user until a valid course is
     * provided.
     *
     * @param currenCourse The current course that will be retained if no new
     * input is given.
     * @return A valid course name ("Java", ".Net", or "C/C++"). or the original
     * course if no input is provided.
     */
    public static String checkUpdateInputCourse(String currenCourse) {
        // Loop indefinitely until the user enters a valid course name.
        while (true) {
            String result = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.
            // If the user presses Enter without providing input, return the existing course.
            if (result.isEmpty()) {
                return currenCourse;
            }
            // Check if the input matches one of the three allowed course names (case-insensitive).
            if (result.equalsIgnoreCase("Java")) {
                return "Java"; // Return "Java" in the correct format.
            } else if (result.equalsIgnoreCase(".Net")) {
                return ".Net"; // Return ".Net" in the correct format.
            } else if (result.equalsIgnoreCase("C/C++")) {
                return "C/C++"; // Return "C/C++" in the correct format.
            }

            // Display an error message and prompt the user to enter a valid course name.
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Ensures that the user inputs a number within a specified range. This
     * method continuously prompts the user until a valid number is entered.
     *
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return A valid integer within the specified range.
     */
    public static int getRange(int min, int max) {
        int result; // Variable to store the user's input.

        // Loop indefinitely until the user enters a valid number within the range.
        while (true) {
            try {
                String input = sc.nextLine().trim(); // Read user input and remove extra spaces.
                result = Integer.parseInt(input); // Convert input string to an integer.

                // Check if the number is within the specified range and is not empty.
                if (result < min || result > max || input.isEmpty()) {
                    throw new NumberFormatException(); // Force an exception if input is invalid.
                }

                return result; // Return the valid number.
            } catch (NumberFormatException e) {
                // Display an error message if the input is not a valid integer within range.
                System.out.println("Please input a number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

}
