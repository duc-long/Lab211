/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v03;

import java.util.Scanner;

/**
 * V03 - ID: FA21_05 - Grade Student. This class provides utility methods for
 * user input validation. It includes methods to read integers, doubles, and
 * strings with validation to ensure valid inputs.
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class IO {

    // Global scanner for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Display introduction to user is using app.
     */
    public static void begin() {
        //Display introduction
        System.out.println("This program reads exam/homework scores and report your overall course grade\n");
    }

    /**
     * Enter input data and repeat until a valid integer is entered.
     *
     * @param msg The prompt message displayed to the user
     * @return number The integer value is entered by user.
     *
     */
    public static int getInteger(String msg) {
        int number;
        while (true) {
            try {
                System.out.print(msg); // Display the prompt message to the user
                String input = sc.nextLine().trim(); // Read the entire line of input

                number = Integer.parseInt(input); // Parse the input to an integer

                // Check if the integer is negative or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number <= 0 || input.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                return number; // Return a valid number
            } catch (NumberFormatException e) {
                // If the input string cannot be converted to an integer, catch the exception
                // and print an error message, force user re-input
                System.out.println("You must enter an integer!");
            } catch (IllegalArgumentException e) {
                // If a negative number is entered, catch the exception, 
                // print an error message, force user re-input
                System.out.println("You must enter a positive integer!");
            }
        }
    }

    /**
     * Enter input data and repeat until a valid integer is entered. Prompts the
     * user for input and validates the input to ensure it is a non-negative
     * integer (>= 0).
     *
     * @param msg The prompt message displayed to the user
     * @return number The integer value is entered by user.
     *
     */
    public static int getPositiveInteger(String msg) {
        // Initialize a Scanner object to read input from the console.
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print(msg); // Display the prompt message to the user
                String input = sc.nextLine().trim(); // Read the entire line of input

                number = Integer.parseInt(input); // Parse the input to an integer

                // Check if the integer is less than 0 or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number < 0 || input.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                return number; // Return a valid number
            } catch (NumberFormatException e) {
                // If the input string cannot be converted to an integer, catch the exception
                // and print an error message, force user re-input
                System.out.println("You must enter an integer!");
            } catch (IllegalArgumentException e) {
                // If a negative number is entered, catch the exception, 
                // print an error message, force user re-input
                System.out.println("You must enter a number greater than 0!");
            }
        }
    }

    /**
     * Reads a double input from the user and ensures it is valid. Keeps
     * prompting until a valid positive double is entered.
     *
     * @param msg The prompt message displayed to the user
     * @return number A valid positive double entered by the user
     */
    public static double getDouble(String msg) {
        double number;
        while (true) {
            try {
                System.out.print(msg); // Display the prompt message to the user
                String input = sc.nextLine().trim(); // Read the entire line of input

                number = Double.parseDouble(input); // Parse the input to an Double number

                // Check if the integer is negative or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number <= 0.0 || input.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                return number; // Return a valid number
            } catch (NumberFormatException e) {
                // If the input string cannot be converted to an double number, catch the exception
                // and print an error message, force user re-input
                System.out.println("You must enter an number!");
            } catch (IllegalArgumentException e) {
                // If a negative number is entered, catch the exception, 
                // print an error message, force user re-input
                System.out.println("You must enter a positive number!");
            }
        }
    }

    /**
     * Reads a properly formatted string input from the user. Ensures that the
     * input follows the format: "<score> <max>".
     *
     * @param msg The prompt message displayed to the user
     * @return A valid string input following the required format
     */
    public static String getString(String msg) {
        String input = "";
        while (true) {
            try {
                System.out.print(msg); // Prompt user for input
                input = sc.nextLine().trim(); // Read input and remove extra spaces

                // Validate input format (two numbers separated by space)
                if (!input.matches("^[0-9]+\\s+[0-9]+$")) {
                    throw new Exception();
                }

                // Ensure input is not empty
                if (input.isEmpty()) {
                    System.out.println("Must not be empty! Please input again!");
                } else {
                    break; // Valid input, exit loop
                }
            } catch (Exception e) {
                //Catch if input format not correct (two numbers separated by space)
                // print an error message
                System.out.println("Invalid input. Enter in format: <score> <max>");
            }
        }
        return input; // Return valid string input
    }
}
