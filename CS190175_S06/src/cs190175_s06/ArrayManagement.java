/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_s06;

/**
 * S06 - Array Manipulations. This class provides various operations for
 * managing an integer array, including adding values, searching, displaying,
 * filtering by range, and sorting.
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class ArrayManagement {

    private int[] arr; // Array to store integer values.
    private int size;  // Variable to store the current number of elements in the array.

    /**
     * Default constructor that initializes an array with a maximum size of 100.
     * Initially, the number of elements in the array is set to 0.
     */
    public ArrayManagement() {
        this.arr = new int[100]; // Allocate memory for an array with a capacity of 100 elements.
        this.size = 0;           // Initialize the size of the array to zero.
    }

    /**
     * Method to add a new value to the array. The new value is stored at the
     * current `size` index, then `size` is incremented by 1.
     *
     * @param input The integer value to be added to the array.
     */
    public void addValue(int input) {
        arr[size++] = input; //Assign value to array.
        System.out.println("Value added successfully!"); // Display success message.
    }

    /**
     * Method to search for a specific value in the array. If found, the method
     * prints all the indexes where the value appears.
     *
     * @param valueSearch The value to search for in the array.
     * @return The number of occurrences of the searched value.
     */
    public int searchValue(int valueSearch) {
        int count = 0; // Counter for occurrences.
        int[] searchArr = new int[100]; // Array to store indexes of found values.

        // Check if the array is empty before searching.
        if (size == 0) {
            System.out.println("Array is empty"); // Display a message if the array has no elements.
            return -1; // Return -1 to indicate that no value was found.
        }

        // Iterate through the array to find matching values.
        for (int i = 0; i < size; i++) {
            if (arr[i] == valueSearch) { // Check if the element at index matches the search value.
//                searchArr[count++] = i; // Store the index of the found value in searchArr.
                    System.out.println("Index: "+i);
                    return i;
            }
        }

        // Check if no matching value was found in the array.
        if (count == 0) {
            System.out.println("Not found value in array!"); // Display a message if no matches are found.
//        } else {
//            // Print the list of indexes of found values.
//            for (int i = 0; i < count; i++) {
//                System.out.println("Value's index is: " + searchArr[i]); // Display the index of the found value.
//            }
        }
        return count; // Return the number of times the value appears in the array.
    }

    /**
     * Method to display all elements of the array. If the array is empty, a
     * message is displayed instead.
     */
    public void displayArray() {
        // Check if the array contains no elements.
        if (size == 0) {
            System.out.println("Array is empty"); // Display a message if the array is empty.
            return; // End the method execution.
        }

        // Print all elements in the array.
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  "); // Print each element, separated by two spaces.
        }
        System.out.println(); // Move to a new line after printing the array.
    }

    /**
     * Method to filter and display values within a specified range. The user
     * must input valid min and max values (min <= max).
     */
    public void valueRange() {
        // Check if the array is empty before proceeding.
        if (size == 0) {
            System.out.println("Array is empty"); // Display a message if the array is empty.
            return; // End the method execution.
        }

        int min, max; // Variables to store the minimum and maximum values entered by the user.

        // Loop to validate user input, ensuring that min is not greater than max.
        while (true) {
            min = IO.getInteger("Please enter min value: "); // Get the min value from the user.
            max = IO.getInteger("Please enter max value: "); // Get the max value from the user.

            if (min > max) { // Check if min is greater than max.
                System.out.println("Min value must be less than or equal to Max value!");
            } else {
                break; // Exit the loop if the input is valid.
            }
        }

        // Find and display values within the range [min, max].
        boolean found = false; // Flag to indicate if at least one value is found.
        System.out.print("Values in range [" + min + ", " + max + "]: ");
        for (int i = 0; i < size; i++) {
            if (arr[i] >= min && arr[i] <= max) { // Check if the value is within the range.
                System.out.print(arr[i] + "  "); // Print the value.
                found = true; // True when at least one value was found.
            }
        }

        // Check if no values input were found within the range.
        if (!found) {
            System.out.println("No values found in the specified range.");
        }
        System.out.println(); // Move to a new line after printing.
    }

    /**
     * Method to sort the array using the Bubble Sort algorithm. It compares
     * adjacent elements and swaps them if they are in the wrong order.
     */
    public void bubbleSort() {
        // Outer loop for the number of passes (size - 1 passes needed).
        for (int i = 0; i < size - 1; i++) {
            // Inner loop for comparing adjacent elements.
            for (int j = 0; j < size - i - 1; j++) {
                // Swap elements if they are in the wrong order.
                if (arr[j] > arr[j + 1]) {
                    // Temporary variable to hold one element during the swap.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
