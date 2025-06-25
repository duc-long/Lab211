/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s09;

/**
 * Remove unnecessary blank in a string. Class for managing string operations.
 * This class provides a method to remove unnecessary spaces from a string.
 *
 * @author Nguyen Van Duc Long - CS190175 - 24/2/2025
 */
public class Management {

    /**
     * Removes unnecessary blank spaces in a string. Consecutive spaces are
     * replaced with a single space.
     *
     * @param input The input string.
     * @return The modified string with extra spaces removed.
     */
    public String removeString(String input) {
        // Replace multiple spaces with a single space
        input = input.replaceAll("\\s+", " ");

        // Check if the resulting string is empty
        if (input.isEmpty()) {
            System.out.println("Replace All! No String in here!");
        } else {
            System.out.println("The string after removing: " + input);
        }

        return input; // Return the modified string
    }
}
