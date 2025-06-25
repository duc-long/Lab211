/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s08;

/**
 * Convert hexadecimal, octal to binary.
 *
 * @author Nguyen Van Duc Long - CS190175 -16/2/2025
 */
public class CS190175_S08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean check = true; // Flag to control the loop

        while (check) {
            // Prompt the user to enter a hexadecimal or octal number
            String input = IO.getValidInput("Enter a Hexadecimal (H) / Octal (Q) number: ");

            // Create a Management object to handle the conversion
            Management mn = new Management(input);

            // Display the binary conversion result
            mn.display();

            // Ask the user if they want to continue or exit
            check = IO.getPress("Press any key to do another conversion. (Enter to exit) ");
        }
    }

}
