/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s05;

/**
 * S05 - Count the number of the appearance of letters in a string. This class
 * provides functionality for counting letter occurrences in a string and
 * displaying the count letter. It is case-insensitive and ignores
 * non-alphabetic characters.
 *
 * @author Nguyen Van Duc Long - CS190175 - 17/1/2025
 */
public class StringManagement {

    private int[] letter; // Array to store the counts of each letter (a-z)
    private String input; // Input string provided by the user

    /**
     * Constructor to initialize the input string and letter array.
     *
     * @param input The string to be analyzed for letter counts.
     */
    public StringManagement(String input) {
        this.letter = new int[26]; // Create an array with 26 slots to represent the counts of a-z.
        this.input = input;       // Store the input string provided by the user.
    }

    /**
     * Counts the occurrences of each letter in the input string. Ignores case
     * and non-alphabetic characters.
     *
     * @return An array representing the counts of letters.
     */
    public int[] countLetter() {
        // Loop through each character in the input string.
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i); // Get the character at position i in the string.

            // Check if the current character is a letter.
            if (Character.isLetter(curChar)) {
                curChar = Character.toLowerCase(curChar); //Switch to bonus letters to correct the general format.

                // Increment the count for the corresponding letter in the array.
                letter[curChar - 'a']++;
            }
        }
        return letter; // Return the array with letter counts.
    }

    /**
     * Displays the counts of letters in the input string. Only letters with
     * non-zero counts are shown.
     */
    public void displayCount() {
        // Loop through the letter array, which contains counts for a-z.
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > 0) { // Only process letters with non-zero counts.
                char letters = (char) (i + 'a'); // Convert the index to a letter.
                System.out.println(letters + ": " + letter[i]); // Print the letter and letter's count.
            }
        }
    }
}
