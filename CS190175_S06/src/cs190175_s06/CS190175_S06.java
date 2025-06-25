/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s06;

import java.util.Scanner;

/**
 * S06 -Array Manipulations.
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class CS190175_S06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize a Scanner object to read input from the console.
        String input; // Variable to store the user's menu choice.
        boolean check = false; // Flag to control the program's main loop.
        ArrayManagement am = new ArrayManagement(); // Create an instance of ArrayManagement to perform array operations.

        // Main loop to keep displaying the menu until the user chooses to exit.
        while (!check) {
            // Display the menu options.
            IO.displayMenu();

            // Read the user's menu choice, removing any leading or trailing whitespace.
            input = sc.nextLine().trim();

            // Handle the user's choice using a switch-case statement.
            switch (input) {
                case "1": // Case for adding a new value to the array.
                    System.out.println("== Add a value ==");
                    int number = IO.getInteger("Please enter a value: "); // Prompt user for a number.
                    am.addValue(number); // Add the value to the array.
                    break;

                case "2": // Case for searching for a value in the array.
                    System.out.println("== Search a value ==");
                    int value = IO.getInteger("Please enter a value to search: "); // Prompt user for a value to search.
                    am.searchValue(value); // Call method to search value.
                    break;

                case "3": // Case for displaying all elements of the array.
                    System.out.println("== Display array ==");
                    am.displayArray(); // Call method to display the array.
                    break;

                case "4": // Case for filtering array values within a specified range.
                    System.out.println("== Array between min and max ==");
                    am.valueRange(); // Call method to filter values within a given range.
                    break;

                case "5": // Case for sorting the array in ascending order.
                    System.out.println("== Ascending array ==");
                    am.bubbleSort(); // Sort the array using the Bubble Sort algorithm.
                    am.displayArray(); // Display the sorted array.
                    break;

                case "6": // Case for exiting the program.
                    System.out.println("Exiting...");
                    check = true; // Set the flag to true to terminate the loop.
                    break;

                default: // Handle invalid input (if the user enters anything other than 1-6).
                    System.out.println("You must enter a number between 1 and 6."); // User enters an invalid menu choice
                    continue; // Skip to the next iteration of the loop
            }
        }

    }
}
