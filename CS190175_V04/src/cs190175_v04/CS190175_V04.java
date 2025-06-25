/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v04;

/**
 * V04 - ID: FA21_09 - Doctor Management Program
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class CS190175_V04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating an instance of DoctorManagement to handle doctor operations
        DoctorManagement dm = new DoctorManagement();

        // Infinite loop to continuously display the menu until the user chooses to exit
        while (true) {
            // Displaying the menu options for the user
            System.out.println("========= Doctor Management =========");
            System.out.println("1. Add Doctor\n"
                    + "2. Update Doctor\n"
                    + "3. Delete Doctor\n"
                    + "4. Search Doctor\n"
                    + "5. Exit");

            // Getting user input for menu selection with validation
            int option = IO.getMenuOption("Your option: ", "Please choose an option between 1 and 5.");

            try {
                // Switch statement to handle different menu choices
                switch (option) {
                    case 1: // Adding a new doctor
                        System.out.println("--------- Add Doctor ---------");

                        String code;
                        while (true) {
                            // Getting and validating the doctor's unique code
                            code = IO.getDoctorCode("Enter Code: ", "Code can only contain letters and positive integers number.");

                            // Checking if the code already exists
                            if (!dm.isExistDoctorCode(code)) {
                                break; // Code is unique, proceed with adding
                            } else {
                                System.out.println("Doctor code: " + code + " is duplicate. Please enter another code.");
                            }
                        }

                        // Getting doctor's details (name, specialization, availability) with validation
                        String name = IO.getDoctorName("Enter Name: ", "Name can only contain letters.");
                        String specialization = IO.getDoctorSpecialization("Enter Specialization: ", "Specialization can only contain letters.");
                        int availability = IO.getDoctorAvailability("Enter Availability: ", "Availability accept positive integer number only.");

                        // Creating a Doctor object with user input
                        Doctor doctor = new Doctor(code, name, specialization, availability);

                        // Adding doctor to the system
                        if (dm.addDoctor(doctor)) {
                            System.out.println("Add doctor successfully.");
                        } else {
                            System.out.println("Add doctor failed. Please check your doctor information again.");
                        }
                        break;

                    case 2:  // Updating an existing doctor
                        System.out.println("--------- Update Doctor ---------");

                        // Check if there is data to perform the update doctor information
                        if (dm.isEmptyData()) {
                            System.out.println("Database does not exist.");
                            break;
                        }

                        // Getting and validating doctor code for update
                        String codeUpdate;
                        // Ensuring the doctor code exists before updating
                        while (true) {
                            codeUpdate = IO.getUpdateDoctorCode("Enter Code: ", "Code can only contain letters and positive integers number.");
                            if (!dm.isExistDoctorCode(codeUpdate)) {
                                System.out.println("Doctor code: " + codeUpdate + " is not exist. Please enter again.");
                            } else {
                                break; // Code exists, proceed with update
                            }
                        }

                        // Prompting user to enter new details for the doctor
                        System.out.println("=== Enter new Doctor information ===");
                        String nameUpdate = IO.getUpdateDoctorName("Enter Name: ", "Name can only contain letters.");
                        String specializationUpdate = IO.getUpdateDoctorSpecialization("Enter Specialization: ", "Specialization can only contain letters.");
                        int availabilityUpdate = IO.getUpdateDoctorAvailability("Enter Availability: ", "Availability accept positive integer number only.");

                        // Updating doctor information in the system
                        if (dm.updateDoctor(codeUpdate, nameUpdate, specializationUpdate, availabilityUpdate)) {
                            System.out.println("Update Doctor information successfully.");
                        }

                        break;
                    case 3:  // Deleting a doctor
                        System.out.println("--------- Delete Doctor ---------");

                        // Check if there is data to perform the delete doctor
                        if (dm.isEmptyData()) {
                            System.out.println("Database does not exist.");
                            break;
                        }

                        String deleteCode = IO.getDoctorCode("Enter Code: ", "Code can only contain letters and positive integers.");

                        // Removing the doctor from the system
                        if (dm.deleteDoctor(deleteCode)) {
                            System.out.println("Delete Doctor successfully.");
                        }

                        break;
                    case 4:
                        //Search for a doctor.
                        System.out.println("--------- Search Doctor ---------");
                        try {
                            // Check if there are any doctors in the system.
                            if (dm.isEmptyData()) {
                                System.out.println("Database does not exist.");
                                break; // Exit the search process if the database is empty.
                            }

                            // Prompt the user to enter search text.
                            String searchValue = IO.getSearchDoctorCode("Enter Code: ", "Code can only contain letters and positive integers.");

                            // Declare a flag to check if any doctors were found.
                            boolean found;

                            // If the search input is not empty, search for the doctor.
                            if (!searchValue.isEmpty()) {
                                found = dm.searchDoctor(searchValue);

                                // If no doctors were found, display a message.
                                if (!found) {
                                    System.out.println("No doctors found matching the search criteria.");
                                }
                            } else {
                                // If the search input is empty, display all doctors.
                                dm.display(dm.getDoctorData());
                            }
                        } catch (Exception e) {
                            // Catch and display any exceptions.
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5: // Exiting the program
                        System.out.println("Bye! Exiting...");
                        return; // Exit the program.
                }
            } catch (Exception e) {
                // Handling any unexpected exceptions
                System.out.println(e.getMessage());
            }
        }
    }
}
