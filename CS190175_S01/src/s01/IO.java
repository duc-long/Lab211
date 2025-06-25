/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

import java.util.Scanner;

/**
 * S01 - Program to insert new element into an existing array.
 *
 * This class provide methods to validate input data in application and show
 * output data It is designed to reduce errors and ensure that input data meets
 * specific standards or constraints before being processed or stored.
 *
 * @author Nguyen Van Duc Long - CS190175 - 7/1/2025
 */
public class IO {

    /**
     * Enter input data and repeat until a valid integer is entered.
     *
     * @param message
     * @return n The integer value is entered by user.
     *
     */
    public static int getInteger(String message) {
        // Initialize a Scanner object to read input from the console.
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print(message); // Display the prompt message to the user
                String input = sc.nextLine(); // Read the entire line of input

                number = Integer.parseInt(input); // Parse the input to an integer

                // Check if the integer is negative or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number <= 0 || input.trim().isEmpty()) {
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
     * @param message
     * @return n The integer value is entered by user.
     *
     */
    public static int getPositiveInteger(String message) {
        // Initialize a Scanner object to read input from the console.
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print(message); // Display the prompt message to the user
                String input = sc.nextLine(); // Read the entire line of input

                number = Integer.parseInt(input); // Parse the input to an integer

                // Check if the integer is less than 0 or empty or just Enter. If so, throw an IllegalArgumentException.
                if (number < 0 || input.trim().isEmpty()) {
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

}
