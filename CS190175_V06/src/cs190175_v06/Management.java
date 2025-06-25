/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Array and string manipulations. Management class that handles student
 * operations such as adding, removing, searching, and sorting students.
 *
 * @author Nguyen Van Duc Long - CS190175 - 2/3/2025
 */
public class Management {

    // A list to store student objects
    private final List<Student> studentList = new LinkedList<>();

    /**
     * Default constructor to initialize an empty student list.
     */
    public Management() {
    }

    /**
     * Checks if a student with the given name already exists in the list.
     *
     * @param name The name of the student to check.
     * @return true if a student with the same name exists, false otherwise.
     */
    private boolean isExistStudent(String name) {
        // Iterate through the student list
        for (Student student : studentList) {
            // Check if the student's name matches the input name
            if (student.getName().equals(name)) {
                return true; // Student exists in the list
            }
        }
        return false; // Student not found
    }

    /**
     * Adds a new student to the list, ensuring that the list does not exceed
     * the limit and that the student's name is unique.
     */
    public void addStudent() {
        // Check if the student list has reached the maximum allowed size (100 students)
        if (studentList.size() >= 100) {
            System.out.println("The list is full. Cannot add a new student.");
            return; //Exit when list is full
        }

        while (true) {
            // Prompt the user to enter a student name
            String name = IO.checkInputName("Enter new student name: ");

            // Check if the student name already exists in the list
            if (!isExistStudent(name)) {
                // Create a new Student object with the given name
                Student student = new Student(name);

                // Add the student to the list
                studentList.add(student);

                // Display success message
                System.out.println("Student has been added to the list successfully!");

                // Exit the loop after successfully adding a student
                break;
            } else {
                // Display an error message if the student name is already in the list
                System.out.println("Student's name already exists. Please enter another name.");
            }
        }
    }

    /**
     * Removes a student from the list by name.
     */
    public void removeStudent() {
        // Check if the student list is empty before attempting removal
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty.");
            return; //Exit when student list is empty
        }

        // Prompt the user to enter the name of the student to be removed
        String studentName = IO.checkInputName("Enter student name to remove: ");

        // Iterate through the list to find the student
        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                // Remove the student from the list
                studentList.remove(student);

                // Display success message
                System.out.println("Student has been removed successfully!");
                return; // Exit method after removing the student
            }
        }

        // If student is not found in the list
        System.out.println("Student does not exist in the system.");
    }

    /**
     * Searches for students by name and returns their indices in the list.
     *
     * @param name The name of the student to search for.
     * @return A list of indices where students with matching names are found.
     */
    public List<Integer> searchStudentByName(String name) {
        List<Integer> indices = new ArrayList<>(); // List to store indices of matching students
        // Iterate through the student list
        for (int i = 0; i < studentList.size(); i++) {
            // Convert both student name and search query to lowercase for case-insensitive search
            if (studentList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                indices.add(i); // Add the index of the matching student to the list
            }
        }

        return indices; // Return the list of found indices (empty if no match is found)
    }

    /**
     * Handles the search functionality for a student.
     */
    public void searchStudent() {
        // Check if the student list is empty before searching
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty."); // Notify if no students exist
            return; // Exit the function early
        }

        String name = IO.getSearchName("Enter student name to search: "); // Read the student's name input from the user

        // Get a list of indices where students with the given name are found
        List<Integer> indices = searchStudentByName(name);

        // Check if any students were found
        if (indices.isEmpty()) {
            System.out.println("Student not found."); // Print message if no match is found
        } else {
            System.out.println("Student found at indices: " + indices); // Display matching indices
        }
    }

    /**
     * Sorts the student list alphabetically and displays the sorted students.
     */
    public void displaySortedStudents() {
        // Check if the list is empty before sorting
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty.");
            return; //Exit when student list is empty
        }

        // Sort students alphabetically based on their names (A-Z)
        Collections.sort(studentList, Comparator.comparing(Student::getName, String::compareToIgnoreCase));

        // Display the total number of students
        System.out.println("Total students: " + studentList.size());

        // Display the sorted list of students
        int index = 1; //Initialize index is 1
        for (Student student : studentList) {
            System.out.println(index + ". " + student.getName());
            index++; //Increase index of number of student in list
        }
    }
}
