/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s09;

/**
 * Remove unnecessary blank in a string.
 *
 * @author Nguyen Van Duc Long - CS190175 - 24/2/2025
 */
public class CS190175_S09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the Management class to handle string operations
        Management management = new Management();

        while (true) {
            // Prompt the user to enter a string
            String input = IO.getString("Please enter a string: ");

            // Process and remove unnecessary spaces from the input string
            management.removeString(input);

            // Ask if the user wants to continue; exit if they choose 'N' or 'No'
            if (IO.checkInputYN("Do you want to continue? (Y/N) ")) {
                break; // Exit the loop if the user chooses not to continue
            }
        }

        // Print a farewell message before terminating the program
        System.out.println("Bye! Program exited...");
    }
}
