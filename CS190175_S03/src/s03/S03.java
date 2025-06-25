/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

import java.util.Scanner;

/**
 * S03 - Convert binary, octal, and hexadecimal to decimal.
 *
 * @author Nguyen Van Duc Long - CS190175 - 12/1/2025
 */
public class S03 {

    /**
     * Main method to execute the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize a Scanner object to read input from the console.
        String input = "";                   // Variable to store user's menu choice
        int base = 0;                        // Variable to store the base of the input number
        boolean check = false;               // Flag to control the program's main loop

        // Main loop to keep showing the menu until the user chooses to exit
        while (!check) {
            // Display the menu
            IO.showMenu();
            // Read the user's menu choice and trim whitespace
            input = sc.nextLine().trim();

            // Process the menu choice using a switch statement
            switch (input) {
                case "1":
                    // User chooses to convert binary to decimal
                    System.out.print("Enter binary number: ");
                    base = 2; // Set base to 2 for binary
                    break;
                case "2":
                    // User chooses to convert octal to decimal
                    System.out.print("Enter octal number: ");
                    base = 8; // Set base to 8 for octal
                    break;
                case "3":
                    // User chooses to convert hexadecimal to decimal
                    System.out.print("Enter hexadecimal number: ");
                    base = 16; // Set base to 16 for hexadecimal
                    break;
                case "4":
                    // User chooses to exit the program
                    System.out.println("Exit...");
                    check = true; // Set the flag to true to terminate the loop
                    break;
                default:
                    // User enters an invalid menu choice
                    System.out.println("Please enter 1-4!");
                    continue; // Skip to the next iteration of the loop
            }

            // If the user chooses to exit, end processing
            if (check) {
                break;
            }

            // Get a valid number from the user in the specified base
            String number = IO.getNumber(base);

            // Create an instance of BaseNManagement for the given number and base
            BaseNManagement bnm = new BaseNManagement(number, base);

            // Convert the number from the specified base to decimal
            String decNum = bnm.convert(number, base);

            // If the input number does not contain a fractional part (no '.')
            if (!number.contains(".")) {
                // Extract the integer part of the decimal number
                decNum = bnm.splitPart(decNum);
                // Display the integer part of the decimal number
                BaseNManagement.displayDec(decNum);
            } else {
                // Display the full decimal number (integer and fractional parts)
                BaseNManagement.displayDec(decNum);
            }
        }
    }
}
