/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

/**
 * S02 - Reverse a string. This class provides methods to reverse a string while
 * preserving the relative position of words and delimiters.
 *
 * @author Nguyen Van Duc Long - CS190175 - 10/1/2025
 */
public class StringManagement {

    private String input;    // Original input string
    private String[] strArr; // Array of words split from the input string
    private String[] strDeli; // Array of delimiters split from the input string

    /**
     * Default constructor initializing an empty input string.
     */
    public StringManagement() {
        this.input = ""; // Default input is an empty string
    }

    /**
     * Constructor initializing the input string.
     *
     * @param input The string to be managed.
     */
    public StringManagement(String input) {
        this.input = input; // Assign input string
    }

    /**
     * Gets the input string.
     *
     * @return The original input string.
     */
    public String getInput() {
        return input; // Return the current input string
    }

    /**
     * Splits the input string into two parts: words and delimiters. Words are
     * sequences of alphanumeric characters separated by spaces or underscores.
     * Delimiters are non-alphanumeric characters like spaces or underscores.
     *
     * @param input The input string to be split.
     */
    public void splitString(String input) {
        this.input = input; // Update the input string

        // Split the input string into words using spaces or underscores as delimiters
        strArr = input.split("[_ ]+"); // Matches one or more underscores or spaces

        // Split the input string into delimiters by matching non-word characters
        strDeli = input.split("[^_ ]+"); // Matches one or more non-alphanumeric characters
    }

    /**
     * Reverses the order of words in the string while preserving the positions
     * of delimiters. Words and delimiters are appended alternately in reverse
     * order.
     *
     * @return The reversed string with original delimiters in place.
     */
    public String reversed() {
        StringBuilder reversedString = new StringBuilder(); // Initialize a StringBuilder for the result
        int wordIndex = strArr.length - 1; // Start from the last word in the array
        int deliIndex = strDeli.length - 1; // Start from the last delimiter in the array

        // Append words and delimiters alternately until both arrays are exhausted
//        while (wordIndex >= 0 || deliIndex >= 0) {
//            if (wordIndex >= 0) {
//                reversedString.append(strArr[wordIndex--]); // Append a word
//            }
//            if (deliIndex >= 0) {
//                reversedString.append(strDeli[deliIndex--]); // Append a delimiter
//            }
//        }

    for(int i= wordIndex,j=deliIndex;i>=0||j>=0;i--,j--){
        if(i>=0){
            reversedString.append(strArr[i]);
        }
        if (j >= 0) {
            reversedString.append(strDeli[j]);
    }
    }

        return reversedString.toString(); // Return the resulting reversed string
    }

    /**
     * Displays the original string and its reversed version. The reversed
     * string is created using the reversed() method.
     */
    public void displayData() {
        // Display the original input string
        System.out.println("The old string: " + input);

        // Generate and display the reversed string
        String reversedString = reversed();
        System.out.println("The reversed string: " + reversedString);
    }
}
