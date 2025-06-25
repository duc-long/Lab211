/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v06;

/**
 * Array and string manipulations. The Student class represents a student with a
 * name. It provides a constructor to initialize the student and a getter method
 * to retrieve the student's name.
 *
 * @author Nguyen Van Duc Long - CS190175 - 2/3/2025
 */
public class Student {

    // A private field to store the student's name
    private String name;

    /**
     * Constructor to create a new Student object.
     *
     * @param name The name of the student.
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the student's name.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }
}
