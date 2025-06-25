/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_l02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * L02 - Manage students
 *
 * @author Nguyen Van Duc Long - CS190175 -18/2/2025
 */
public class CS190175_L02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object to read user input.
        ArrayList<Student> ls = new ArrayList<>(); // Initialize an empty list to store students.
        Management mn = new Management(ls); // Create a Management object to handle operations.
        String choice; // Variable to store user's menu selection.

        // Infinite loop to continuously display the menu until the user chooses to exit.
        while (true) {
            IO.displayMenu(); // Display the menu options.
            choice = sc.nextLine().trim(); // Read user input and remove leading/trailing spaces.

            // Process user choice using a switch statement.
            switch (choice) {
                case "1":
                    // Option 1: Create a new student record. 
                    mn.createStudent();  // Try to add a student and check if it was successful

                    break;

                case "2":
                    // Option 2: Find and sort students based on their names.
                    mn.findAndSort();
                    break;

                case "3":
                    // Option 3: Update or delete a student record.
                    mn.updateOrDelete();
                    break;

                case "4":
                    // Option 4: Generate and display the student report.
                    mn.report();
                    break;

                case "5":
                    // Option 5: Exit the program.
                    System.out.println("Bye! Exiting program...");
                    return;  // Terminate the program.

                default:
                    // Handle invalid menu selections.
                    System.out.println("Invalid option! Please enter a number between 1-5.");
            }
        }
    }
}
