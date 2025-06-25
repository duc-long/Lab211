/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

import java.util.Scanner;

/**
 * S03 - Convert binary, octal, and hexadecimal to decimal. 
 * This class handles input-related tasks such as displaying a menu, validating input, and managing
 * user interactions for base conversions.
 *
 * @author Nguyen Van Duc Long - CS190175 - 12/1/2025
 */
public class IO {

    // Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Displays a menu of options for the user.
     */
    public static void showMenu() {
        // Print menu options to the console
        System.out.println("1. Convert binary number to decimal number");
        System.out.println("2. Convert octal number to decimal number");
        System.out.println("3. Convert hexadecimal number to decimal number");
        System.out.println("4. Exit");
        // Prompt user to choose an option
        System.out.print("Please choose number (1 – 4): ");
    }

    /**
     * Prompts the user to enter a number in the specified base. Validates the
     * input using the checkNumber() method to ensure correctness.
     *
     * @param base The base of the number to be entered (2, 8, or 16).
     * @return A valid number as a string.
     */
    public static String getNumber(int base) {
        String input; // Variable to store user input
        while (true) {
            // Read the user's input and trim whitespace
            input = sc.nextLine().trim();
            // Check if the input is valid for the specified base
            if (checkNumber(input, base)) {
                // Break the loop if input is valid
                break;
            } else {
                // If input is invalid, prompt the user to re-enter
                System.out.println("Invalid input. Please enter a valid number in base " + base + ":");
            }
        }
        return input; // Return the validated input
    }

    /**
     * Validates whether the input string matches the format for base. Have base
     * 2 (binary), 8 (octal), and 16 (hexadecimal).
     *
     * @param input The input string to validate.
     * @param base The base to validate against (2, 8, or 16).
     * @return True if the input is valid for the base, otherwise false.
     */
    public static boolean checkNumber(String input, int base) {
        String baseCheck; // Regular expression for validation
        switch (base) {
            case 2:
                // Binary numbers can only contain 0 or 1, with an optional fractional part
                baseCheck = "^[01]+(\\.[01]+)?$";
                break;
            case 8:
                // Octal numbers can only contain digits from 0 to 7, with an optional fractional part
                baseCheck = "^[0-7]+(\\.[0-7]+)?$";
                break;
            case 16:
                // Hexadecimal numbers can contain digits 0-9 and letters A-F/a-f, with an optional fractional part
                baseCheck = "^[0-9A-Fa-f]+(\\.[0-9A-Fa-f]+)?$";
                break;
            default:
                // Return false if the base is not supported
                return false;
        }
        // Check if the input matches the regular expression for the specified base
        return input.matches(baseCheck);
    }

}
