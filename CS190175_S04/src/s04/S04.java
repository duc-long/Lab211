/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.util.Scanner;

/**
 * S04 - Check student’s data format.
 *
 * @author Nguyen Van Duc Long - CS190175 - 13/1/2025
 */
public class S04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);
        // Create an instance of StudentDataManagement to manage student data operations.
        StudentDataManagement manager = new StudentDataManagement();
        // Print the program's header.
        System.out.println("====== Management Student Program ======");

        // Variable to control the main loop of the program.
        boolean check = false;

        // Main loop to repeatedly collect student data until the user chooses to stop.
        while (!check) {
            // Prompt the user to enter the student's name.
            String name = IO.getName("Name");

            // Prompt the user to enter the student's class name.
            String className = IO.getName("Classes");

            // Prompt the user to enter the student's Math marks.
            double math = IO.getMarks("Maths");

            // Prompt the user to enter the student's Chemistry marks.
            double chemistry = IO.getMarks("Chemistry");

            // Prompt the user to enter the student's Physics marks.
            double physics = IO.getMarks("Physics");

            // Create a new StudentDataManagement object with the entered details.
            StudentDataManagement sdm = new StudentDataManagement(name, className, math, physics, chemistry);

            // Calculate the average marks and determine the classification type for the student.
            sdm.calAverageType();

            // Add the student object to the shared list of students.
            manager.addStudentToList(sdm);

            // Prompt the user to decide whether to add another student.
            check = IO.checkPress("Do you want to enter another student? (Y/N): ");

            // If the user chooses "N" or "No", the loop exits.
            if (check) {
                break; // Exit the game loop.
            }
        }

        // After exiting the loop, display the details of all students.
        manager.displayAllStudents();

        // Display the percentage distribution of student classifications.
        manager.displayTypePercents();
    }
}
