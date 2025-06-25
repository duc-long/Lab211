/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v06;

import java.util.Scanner;

/**
 * Array and string manipulations.
 *
 * @author Nguyen Van Duc Long - CS190175 -2/3/2025
 */
public class CS190175_V06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Management object to handle student operations.
        Management management = new Management();
        Scanner sc = new Scanner(System.in); // Scanner for user input.

        // Infinite loop to keep showing the menu until the user exits.
        while (true) {
            // Display menu options to the user.
            System.out.println("===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Print student list in ascending order");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Read the user's choice and remove any extra spaces.
            String choice = sc.nextLine().trim();

            // Perform actions based on the user's choice.
            switch (choice) {
                case "1":
                    // Option to add a student.
                    management.addStudent();
                    break;
                case "2":
                    // Option to remove a student.
                    management.removeStudent();
                    break;
                case "3":
                    // Option to search for a student.
                    management.searchStudent();
                    break;
                case "4":
                    // Option to display the sorted student list.
                    management.displaySortedStudents();
                    break;
                case "5":
                    // Exit the program.
                    System.out.println("Exiting program...");
                    return;
                default:
                    // Handle invalid input.
                    System.out.println("Invalid option! Please enter a number from 1 to 5.");
            }
        }
    }
}
