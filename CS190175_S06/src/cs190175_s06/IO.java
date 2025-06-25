/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s06;

import java.util.Scanner;

/**
 * S06 -Array Manipulations. This class provide methods to validate input data
 * in application. And display the menu
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class IO {

    //Global scanner user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * Method to display the main menu. It prints the available options for the
     * user to choose from.
     */
    public static void displayMenu() {
        System.out.println("====== MENU ======");
        System.out.println("1- Add a value");
        System.out.println("2- Search a value");
        System.out.println("3- Print out the array");
        System.out.println("4- Print out values in a range of inputted min and max values, inclusively");
        System.out.println("5- Sort the array in ascending order");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }

    /**
     * Method to get a valid integer input from the user. It continuously
     * prompts the user until a valid integer is entered.
     *
     * @param msg The message displayed to prompt the user.
     * @return A valid integer entered by the user.
     */
    public static int getInteger(String msg) {
        int number; // Variable to store the parsed integer.

        // Infinite loop to keep asking for input until a valid integer is provided.
        while (true) {
            try {
                System.out.print(msg); // Display the prompt message to the user.
                String input = sc.nextLine().trim(); // Read the entire input line and remove leading/trailing spaces.

                number = Integer.parseInt(input); // Attempt to convert the input into an integer.

                // Check if the input is empty (user just pressed Enter without typing anything).
                if (input.isEmpty()) {
                    throw new IllegalArgumentException(); // Throw an exception to indicate invalid input.
                }

                return number; // Return the valid integer.
            } catch (NumberFormatException e) {
                // Handle the case where the input cannot be converted to an integer.
                // Display an error message and prompt the user to enter the input again.
                System.out.println("You must enter an integer!");
            } catch (IllegalArgumentException e) {
                // Handle the case where the input is empty.
                // Display an error message and prompt the user to enter a valid integer.
                System.out.println("Empty! You must enter an integer!");
            }
        }
    }
}
