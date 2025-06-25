/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

import java.util.Scanner;

/**
 * S02 - Reverse a string. This program allows the user to input a string,
 * reverses it while maintaining the positions of words and delimiters, and
 * displays the result. Users can repeat the process or exit the program.
 *
 * @author Nguyen Van Duc Long - CS190175 - 10/1/2025
 */
public class S02 {

    /**
     * Main method to execute the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for reading user input
        boolean check = false;              // Flag to control the main loop
        boolean condition = false;          // Flag for user choice to continue or exit

        // Main loop to repeatedly process user input until the user chooses to exit
        while (!check) {
            // Prompt the user to enter a valid string
            String input = IO.getString("Please enter string: ");

            // Display the original string (for confirmation)
            System.out.println("Input string: " + input);

            // Create an instance of StringManagement with the user's input
            StringManagement sm = new StringManagement(input);

            // Split the input string into words and delimiters
            sm.splitString(input);

            // Reverse the string
            sm.reversed();

            // Display the original and reversed strings
            sm.displayData();

            // Ask the user if they want to continue or exit
            condition = IO.checkPress("Press Enter to reverse another string, or type ESC to exit: ");

            // If the user chooses to exit (ESC), break the loop
            if (condition) {
                break;
            }
        }
    }
}
