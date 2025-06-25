/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s05;

/**
 * S05 - Count the number of the appearance of letters in a string.
 *
 * @author Nguyen Van Duc Long - CS190175 - 17/1/2025
 */
public class CS190175_S05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Prompt the user to input String.
        String input = IO.getString("Enter a string: ");

        // Create an instance of StringManagement with the user input.
        StringManagement sm = new StringManagement(input);

        // Method to calculate letter occurrences.
        sm.countLetter();

        // Display the letters and letter's counts.
        sm.displayCount();
    }

}
