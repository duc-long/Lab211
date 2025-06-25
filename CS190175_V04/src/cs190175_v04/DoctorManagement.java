/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * V04 - ID: FA21_09 - Doctor Management Program. This class manages a
 * collection of doctors. Features include: - Adding new doctors - Updating
 * existing doctor details - Deleting doctors - Searching for doctors -
 * Displaying doctors in a structured format
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class DoctorManagement {

    // Declare a HashMap to store doctor data.
    // The key is a unique doctor code (String), and the value is a Doctor object.
    private HashMap<String, Doctor> doctorData = new HashMap<>();

    /**
     * Method to retrieve the entire doctor list.
     *
     * @return A HashMap containing all doctor data.
     */
    public HashMap<String, Doctor> getDoctorData() {
        return doctorData; // Return the doctor data HashMap.
    }

    /**
     * Method to check if the doctor list is empty.
     *
     * @return true if the doctor list is empty, false otherwise.
     */
    public boolean isEmptyData() {
        return doctorData.isEmpty(); // Return true if the HashMap has no doctors, otherwise return false.
    }

    /**
     * Checks if a doctor code already exists in the system.
     *
     * @param code The doctor code to check.
     * @return true if the doctor code exists, false otherwise.
     */
    public boolean isExistDoctorCode(String code) {
        return doctorData.containsKey(code.toUpperCase()); //return data contain code uppercase in 
    }

    /**
     * Adds a new doctor to the system.
     *
     * @param doctor The Doctor object to add.
     * @return true if the doctor was successfully added.
     */
    public boolean addDoctor(Doctor doctor) {
        // Store doctor object in the map using its unique code as the key
        doctorData.put(doctor.getCode().toUpperCase(), doctor);
        return true; // return true when add doctor is sucess
    }

    /**
     * Method to update an existing doctor's details.
     *
     * @param name
     * @param code
     * @param specialization
     * @param availability
     * @return true if the update is successful.
     * @throws Exception if the doctor does not exist or if required fields are
     * empty.
     */
    public boolean updateDoctor(String code, String name, String specialization, int availability) throws Exception {
        // Check if at least one field is provided for update
        if (name.isEmpty() && specialization.isEmpty() && availability == -1) {
            throw new Exception("No data to update!!");
        }

        // Retrieve the existing doctor object
        Doctor updateDoctorInfo = doctorData.get(code.toUpperCase());
        if (updateDoctorInfo == null) {
            throw new Exception("Doctor does not exist!");
        }
        // Update name if provided
        if (!name.trim().isEmpty()) {
            updateDoctorInfo.setName(name);
        }
        // Update specialization if provided
        if (!specialization.trim().isEmpty()) {
            updateDoctorInfo.setSpecicalization(specialization);
        }
        // Update availability if provided
        if (availability != -1) {
            updateDoctorInfo.setAvailability(availability);
        }

        return true; // return true when update success
    }

    /**
     * Method to delete a doctor from the list.
     *
     * @param code The unique doctor code.
     * @return true if the deletion is successful.
     * @throws IllegalArgumentException if the doctor code does not exist.
     */
    public boolean deleteDoctor(String code) throws IllegalArgumentException {
        // Check if the doctor exists in the HashMap.
        if (!doctorData.containsKey(code)) {
            throw new IllegalArgumentException("Doctor code doesn't exist"); // Throw an exception if doctor does not exist.
        }

        // Remove the doctor from the HashMap.
        doctorData.remove(code);
        return true; // Return true indicating success.
    }

    /**
     * Method to search for a doctor by their code.
     *
     * @param searchValue The doctor code to search for.
     * @return true if a doctor is found, false otherwise.
     */
    public boolean searchDoctor(String searchValue) {
        // Create a new HashMap to store search results.
        HashMap<String, Doctor> searchResults = new HashMap<>();
        boolean check = false; // Flag to check if any doctor was found.

        // Iterate through the doctor list to find a match.
        for (Map.Entry<String, Doctor> entry : doctorData.entrySet()) {
            Doctor doctor = entry.getValue();
            if (doctor.getCode().contains(searchValue.toUpperCase())) { // Check if the doctor's code matches the search value.
                searchResults.put(entry.getKey(), doctor); // Add matched doctor to results.
                check = true; // Mark that a match was found.
            }
        }

        // If no doctor is found, return false.
        if (!check) {
            return false;
        } else {
            // Display the search results.
            display(searchResults);
            return true; // Return true indicating that a doctor was found.
        }
    }

    /**
     * Method to display a list of doctors in a structured table format. It
     * dynamically adjusts column widths based on the longest data in each
     * column to ensure a clean and readable table.
     *
     * @param doctors A HashMap containing doctor data to be displayed.
     */
    public void display(HashMap<String, Doctor> doctors) {
        // Initialize default column widths.
        int maxCodeLength = 4;      // Default width for the "Code" column.
        int maxNameLength = 17;     // Default width for the "Name" column.
        int maxSpecLength = 14;     // Default width for the "Specialization" column.
        int maxAvailLength = 12;    // Default width for the "Availability" column.

        // Iterate through the doctor list to determine the maximum required column widths.
        for (Doctor doctor : doctors.values()) {
            // Update maxCodeLength if the doctor's code is longer than the current maximum.
            maxCodeLength = Math.max(maxCodeLength, doctor.getCode().length());

            // Update maxNameLength if the doctor's name is longer than the current maximum.
            maxNameLength = Math.max(maxNameLength, doctor.getName().length());

            // Update maxSpecLength if the doctor's specialization is longer than the current maximum.
            maxSpecLength = Math.max(maxSpecLength, doctor.getSpecicalization().length());

            // Update maxAvailLength if the availability number is longer than the current maximum.
            maxAvailLength = Math.max(maxAvailLength, String.valueOf(doctor.getAvailability()).length());
        }

        // Adjust the column width for "Code" based on its maximum length.
        int newCodeLength;
        if (maxCodeLength > 4) {
            if (maxCodeLength % 2 == 0) {
                newCodeLength = maxCodeLength + 2; // If even, increase by 2.
            } else {
                newCodeLength = maxCodeLength + 1; // If odd, increase by 1.
            }
        } else {
            newCodeLength = maxCodeLength; // Keep the default width.
        }

        // Adjust the column width for "Name" if its length exceeds 18 characters.
        int newNameLength;
        if (maxNameLength > 17) {
            if (maxNameLength % 2 == 0) {
                newNameLength = maxNameLength + 2; // If even, increase by 2.
            } else {
                newNameLength = maxNameLength + 1; // If odd, increase by 1.
            }
        } else {
            newNameLength = maxNameLength; // Keep the default width.
        }

        // Adjust the column width for "Specialization" if its length exceeds 14 characters.
        int newSpecLength;
        if (maxSpecLength > 14) {
            if (maxSpecLength % 2 == 0) {
                newSpecLength = maxSpecLength + 1; // If even, increase by 1.
            } else {
                newSpecLength = maxSpecLength + 2; // If odd, increase by 2.
            }
        } else {
            newSpecLength = maxSpecLength; // Keep the default width.
        }

        // Adjust the column width for "Availability" if its length exceeds 12 characters.
        int newAvailLength;
        if (maxAvailLength > 12) {
            if (maxAvailLength % 2 == 0) {
                newAvailLength = maxAvailLength + 2; // If even, increase by 2.
            } else {
                newAvailLength = maxAvailLength + 1; // If odd, increase by 1.
            }
        } else {
            newAvailLength = maxAvailLength; // Keep the default width.
        }

        // Calculate the total width of the table to ensure proper formatting.
        // The extra 12 accounts for align.
        int totalColumnWidth = newCodeLength + newNameLength + newSpecLength + newAvailLength + 12;

        // Print the table title centered with dashes on both sides.
        String title = " RESULTS ";
        String dash = String.join("", Collections.nCopies((totalColumnWidth - title.length()) / 2, "-"));
        System.out.println("\n" + dash + title + dash);

        // Construct the table header row with dynamically adjusted column widths.
        String header = "| " + String.join("| ",
                Arrays.asList(
                        String.format("%-" + (newCodeLength + 1) + "s", "Code"),
                        String.format("%-" + newNameLength + "s", "Name"),
                        String.format("%-" + (newSpecLength + 1) + "s", "Specialization"),
                        String.format("%-" + (newAvailLength + 1) + "s", "Availability")
                )) + "|";
        System.out.println(header); // Print the formatted header row.

        // Generate a horizontal divider line based on column widths.
        String divideLine = "+" + String.join("+",
                String.join("", Collections.nCopies(newCodeLength + 2, "-")),
                String.join("", Collections.nCopies(newNameLength + 1, "-")),
                String.join("", Collections.nCopies(newSpecLength + 2, "-")),
                String.join("", Collections.nCopies(newAvailLength + 2, "-"))) + "+";
        System.out.println(divideLine); // Print the divider line.

        // Iterate through the doctor list and print each doctor's details in the formatted table.
        for (Doctor doc : doctors.values()) {
            // Print a formatted row for each doctor.
            System.out.printf("| %-" + (newCodeLength) + "s | %-" + newNameLength + "s| %-" + newSpecLength + "s | %" + newAvailLength + "d |\n",
                    doc.getCode(), doc.getName(), doc.getSpecicalization(), doc.getAvailability());

            // Print a divider line after each row.
            System.out.println(divideLine);
        }
    }

}
