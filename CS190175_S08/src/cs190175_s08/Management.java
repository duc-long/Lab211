/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s08;

/**
 * Convert hexadecimal, octal to binary. This class handles the conversion of
 * hexadecimal and octal numbers to binary.
 *
 * @author Nguyen Van Duc Long - CS190175 - 16/2/2025
 */
public class Management {

    // Stores the input value (hexadecimal or octal)
    private String input;

    /**
     * Constructor that initializes the input value and ensures it is formatted
     * correctly.
     *
     * @param input The input string representing a number followed by its type
     * (H for hex, O for octal).
     */
    public Management(String input) {
        this.input = input.trim().toUpperCase(); // Trim spaces and convert to uppercase for consistency
    }

    /**
     * Determines the input type (hexadecimal or octal) and converts it to
     * binary.
     *
     * @return The binary representation of the input value.
     */
    public String convert() {
        char typeChar = input.charAt(input.length() - 1); // Extract the last character to determine the type
        String value = input.substring(0, input.length() - 1); // Extract the numeric part of the input

        // Perform conversion based on the input type
        return (typeChar == 'H')
                ? convertToBinary(value, "0123456789ABCDEF", new String[]{
            "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        })
                : convertToBinary(value, "01234567", new String[]{
            "000", "001", "010", "011", "100", "101", "110", "111"
        });
    }

    /**
     * Converts a given value from hexadecimal or octal to binary using
     * predefined mappings.
     *
     * @param value The numeric part of the input to be converted.
     * @param digits A string containing valid digits for the numeral system
     * (hex or octal).
     * @param binaryValues An array of binary representations corresponding to
     * the digits.
     * @return A string representing the binary conversion of the input value.
     */
    public String convertToBinary(String value, String digits, String[] binaryValues) {
        StringBuilder binary = new StringBuilder(); // StringBuilder for efficient string concatenation
        for (char c : value.toCharArray()) {
            // Append the corresponding binary value for each digit and add a space separator
            binary.append(binaryValues[digits.indexOf(c)]).append(" ");
        }
        return binary.toString().trim(); // Remove trailing spaces and return the result
    }

    /**
     * Displays the binary representation of the input value.
     */
    public void display() {
        System.out.println("Binary number: " + convert() + "b"); // Append 'b' to indicate binary format
    }
}
