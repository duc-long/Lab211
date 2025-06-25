/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

/**
 * S03 - Convert binary, octal, and hexadecimal to decimal. 
 * This class provides methods to handle conversions from base-N to decimal. It supports binary,
 * octal and hexadecimal.
 *
 * @author Nguyen Van Duc Long - CS190175 - 12/1/2025
 */
public class BaseNManagement {

    private String input; // Input value in base-N format
    private int base;     // Base of the input value (2, 8, 16)

    /**
     * Constructor to initialize the input value and its base.
     *
     * @param input The base-N number in string format.
     * @param base The base of the input value (2, 8, or 16).
     */
    public BaseNManagement(String input, int base) {
        this.input = input;
        this.base = base;
    }

    /**
     * Splits the input string into parts based on the decimal point. Only
     * returns the integer part of the input.
     *
     * @param input The base-N number in string format, potentially containing a
     * decimal point.
     * @return The integer part of the input (before the decimal point).
     */
    public String splitPart(String input) {
        // Split the input string at the decimal point "."
        String[] stringSplit = input.split("\\.");
        // Return the integer part
        return stringSplit[0];
    }

    /**
     * Converts a base-N number (including integer and fractional parts) to its
     * decimal equivalent. Handles the integer and fractional parts separately
     * and combines their results.
     *
     * @param input The base-N number in string format.
     * @param base The base of the input number (2, 8, 16).
     * @return The decimal equivalent of the input number as a string.
     */
    public String convert(String input, int base) {
        // Split the input string into integer and fractional parts
        String[] stringSplit = input.split("\\.");
        String intPart = stringSplit[0]; // Integer part (before the decimal point)
        String fracPart = "";           // Fractional part (after the decimal point)

        // If there is a fractional part, assign it
        if (stringSplit.length > 1) {
            fracPart = stringSplit[1];
        }

        // Convert the integer part to decimal
        int intValue = 0;  // Initialize the result for the integer part
        int power = 0;     // Power starts from 0 (base^0 for the rightmost digit)

        // Loop through the integer part from right to left
        for (int i = intPart.length() - 1; i >= 0; i--) {
            char pos = intPart.charAt(i);      // Get the character at position i
            int value = valueChar(pos, base); // Convert the character to its numeric value
            intValue += value * Math.pow(base, power); // Multiply by base^power and add to the result
            power++;                           // Increment the power for the next digit
        }

        // Convert the fractional part to decimal
        double fracValue = 0.0;              // Initialize the result for the fractional part
        double baseFraction = 1.0 / base;   // The fractional weight starts as base^-1

        // Loop through the fractional part from left to right
        for (int i = 0; i < fracPart.length(); i++) {
            char pos = fracPart.charAt(i);       // Get the character at position i
            int value = valueChar(pos, base);   // Convert the character to its numeric value
            fracValue += value * baseFraction;  // Multiply by the fractional weight and add to the result
            baseFraction /= base;               // Update the weight for the next fractional digit
        }

        // Combine the integer and fractional results and return as a string
        return String.valueOf(intValue + fracValue);
    }

    /**
     * Converts a character in base-N to its integer value. Supports numeric
     * characters (0-9) and alphabetic characters (A-F for hexadecimal).
     *
     * @param pos The character to be converted
     * @param base The base of the input character
     * @return The numeric value of the character in the given base.
     */
    public int valueChar(char pos, int base) {
        int value = 0; // Default value

        // If the character is a digit (0-9), convert it to its number value
        if (pos >= '0' && pos <= '9') {
            value = pos - '0';
        } // If the character is an uppercase letter (A-F), make it equal to its numeric value (10-15)
        else if (pos >= 'A' && pos <= 'F') {
            value = pos - 'A' + 10;
        } // If the character is a lowercase letter (a-f), make it equal to its numeric value (10-15)
        else if (pos >= 'a' && pos <= 'f') {
            value = pos - 'a' + 10;
        }

        return value; // Return the numeric value
    }

    /**
     * Displays the decimal equivalent of the input number to the console.
     *
     * @param decNum The decimal number to be displayed.
     */
    public static void displayDec(String decNum) {
        // Print the decimal equivalent
        System.out.println("Decimal number is: " + decNum);
    }
}
