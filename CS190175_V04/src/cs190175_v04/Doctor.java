/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v04;

/**
 * V04 - ID: FA21_09 - Doctor Management Program This class represents a Doctor
 * entity with attributes (code, name,specicalization, availability of Doctor)
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class Doctor {

    // Declare instance variables for doctor details.
    private String code;              // Unique identifier for the doctor.
    private String name;              // Doctor's full name.
    private String specicalization;   // Doctor's area of specialization.
    private int availability;         // Number of available hours or shifts.

    /**
     * Constructor to initialize a new Doctor object with provided values.
     *
     * @param code The unique identifier for the doctor.
     * @param name The full name of the doctor.
     * @param specicalization The area of specialization of the doctor.
     * @param availability The availability (number of shifts/hours).
     */
    public Doctor(String code, String name, String specicalization, int availability) {
        this.code = code; // Assign the provided code to the doctor object.
        this.name = name; // Assign the provided name to the doctor object.
        this.specicalization = specicalization; // Assign the provided specialization.
        this.availability = availability; // Assign the provided availability.
    }

    /**
     * Getter method to retrieve the doctor's unique code.
     *
     * @return The unique code of the doctor.
     */
    public String getCode() {
        return code; // Return the doctor code.
    }

    /**
     * Setter method to update the doctor's unique code.
     *
     * @param code The new unique code to set.
     */
    public void setCode(String code) {
        this.code = code; // Assign the new code to the doctor object.
    }

    /**
     * Getter method to retrieve the doctor's full name.
     *
     * @return The name of the doctor.
     */
    public String getName() {
        return name; // Return the doctor's name.
    }

    /**
     * Setter method to update the doctor's full name.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name; // Assign the new name to the doctor object.
    }

    /**
     * Getter method to retrieve the doctor's specialization.
     *
     * @return The specialization of the doctor.
     */
    public String getSpecicalization() {
        return specicalization; // Return the doctor's specialization.
    }

    /**
     * Setter method to update the doctor's specialization.
     *
     * @param specicalization The new specialization to set.
     */
    public void setSpecicalization(String specicalization) {
        this.specicalization = specicalization; // Assign the new specialization to the doctor object.
    }

    /**
     * Getter method to retrieve the doctor's availability.
     *
     * @return The number of available shifts/hours for the doctor.
     */
    public int getAvailability() {
        return availability; // Return the doctor's availability.
    }

    /**
     * Setter method to update the doctor's availability.
     *
     * @param availability The new availability to set.
     */
    public void setAvailability(int availability) {
        this.availability = availability; // Assign the new availability to the doctor object.
    }

}
