/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * S04 - Check student’s data format.
 *
 * This class manages student data, including their marks, average score, and
 * classification type. It also calculates and displays statistics about the
 * student classifications.
 *
 * @author Nguyen Van Duc Long - CS190175 - 13/1/2025
 */
public class StudentDataManagement {

    // Instance variables to store individual student data.
    private String studentName; // The full name of the student.
    private String className;   // The class or group the student belongs to.
    private double markMath;    // Marks obtained in Math.
    private double markPhysical; // Marks obtained in Physics.
    private double markChemistry; // Marks obtained in Chemistry.
    private double average;     // Average marks, calculated from subject scores.
    private String type;        // Classification type (A, B, C, D) based on average marks.

    // Static list to store all students. This allows shared access across instances.
    private List<StudentDataManagement> studentList = new ArrayList<>();

    /**
     * Default constructor for creating a blank student record. Used when no
     * initial data is provided.
     */
    public StudentDataManagement() {
    }

    /**
     * Parameterized constructor to create a student record with specific data.
     *
     * @param studentName Name of the student.
     * @param className Name of the class or section.
     * @param markMath Marks obtained in Math.
     * @param markPhysical Marks obtained in Physics.
     * @param markChemistry Marks obtained in Chemistry.
     */
    public StudentDataManagement(String studentName, String className, double markMath, double markPhysical, double markChemistry) {
        this.studentName = studentName; // Assign provided name to the instance variable.
        this.className = className;     // Assign provided class name to the instance variable.
        this.markMath = markMath;       // Assign provided Math marks to the instance variable.
        this.markPhysical = markPhysical; // Assign provided Physics marks to the instance variable.
        this.markChemistry = markChemistry; // Assign provided Chemistry marks to the instance variable.

        // Initialize default values for average and type.
        this.average = 0.0; // The average marks start at 0.0.
        this.type = "";     // The type is initially an empty string.
    }

    /**
     * Adds a student object to the shared student list.
     *
     * @param student The student object to be added.
     */
    public void addStudentToList(StudentDataManagement student) {
        // Add the student object to the list. This makes the student accessible globally.
        studentList.add(student);
    }

    /**
     * Calculates the average marks and assigns a classification type.
     */
    public void calAverageType() {
        // Calculate the average marks by summing up the subject marks and dividing by 3 (three subjects).
        average = (markMath + markChemistry + markPhysical) / 3.0;

        // Determine the classification type based on the average marks.
        // Type A: (average > 7.5).
        if (average > 7.5) {
            type = "A";
        } // Type B: (6 <= average <= 7.5).
        else if (average >= 6 && average <= 7.5) {
            type = "B";
        } // Type C: (4 <= average < 6).
        else if (average >= 4 && average < 6) {
            type = "C";
        } // Type D: (average < 4).
        else {
            type = "D";
        }
    }

    /**
     * Calculates the percentage of students in each classification type.
     *
     * @return A map containing the classification type as the key and its
     * percentage as the value.
     */
    private Map<String, Double> calculateTypePercent() {
        // Get the total number of students in the list.
        int total = studentList.size();

        // Initialize counters for each type to 0.
        int countA = 0, countB = 0, countC = 0, countD = 0;

        // Iterate over the student list to count the occurrences of each type.
        for (StudentDataManagement student : studentList) {
            // Check the student's type and increment the corresponding counter.
            switch (student.type) {
                case "A": // Increment counter for type A.
                    countA++;
                    break;
                case "B": // Increment counter for type B.
                    countB++;
                    break;
                case "C": // Increment counter for type C.
                    countC++;
                    break;
                case "D": // Increment counter for type D.
                    countD++;
                    break;
            }
        }

        // Create a map to store the percentage of each classification type.
        Map<String, Double> percents = new HashMap<>();
        // Calculate the percentage of students in type A.
        percents.put("A", countA * 100.0 / total);
        // Calculate the percentage of students in type B.
        percents.put("B", countB * 100.0 / total);
        // Calculate the percentage of students in type C.
        percents.put("C", countC * 100.0 / total);
        // Calculate the percentage of students in type D.
        percents.put("D", countD * 100.0 / total);
        // Return the map containing the calculated percentages.
        return percents;
    }

    /**
     * Displays all student information, including name, class, average marks,
     * and classification type.
     */
    public void displayAllStudents() {
        //Count based on number of students displayed
        int count = 0;
        // Iterate through the list of students to display their details.
        for (StudentDataManagement student : studentList) {
            count++; // Increment the student counter.
            // Print a header for the current student's details.
            System.out.println("------ Student" + count + " Info ------");
            // Display the student's name.
            System.out.printf("Name: %s\n", student.studentName);
            // Display the student's class name.
            System.out.printf("Class: %s\n", student.className);
            // Display the student's average marks.
            System.out.printf("Average: %.1f\n", student.average);
            // Display the student's classification type.
            System.out.printf("Type: %s\n", student.type);
        }
    }

    /**
     * Displays the percentage of students in each classification type.
     */
    public void displayTypePercents() {
        // Calculate the percentages of students in each type.
        Map<String, Double> percents = calculateTypePercent();
        // Print a header for the classification percentage display.
        System.out.println("------ Classification Info ------");
        // Iterate through the map of percentages to display each type's percentage.
        for (Map.Entry<String, Double> entry : percents.entrySet()) {
            // Get the classification type (key) and its percentage (value).
            String type = entry.getKey();
            Double percentage = entry.getValue();
            // Display the classification type and percentage in a formatted string.
            System.out.printf("%s: %.1f%%\n", type, percentage);
        }
    }
}
