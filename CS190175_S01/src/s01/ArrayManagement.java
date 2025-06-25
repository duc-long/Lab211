/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

/**
 * S01 - Program to insert a new element into an existing array.
 *
 * This class manages an array and provides methods to: - Input elements into
 * the array. - Display the array. - Sort the array using Bubble Sort. - Insert
 * a new value into a sorted array.
 *
 * @author Nguyen Van Duc Long - CS190175  - 7/1/2025
 */
public class ArrayManagement {

    private int[] arr;  // Array to store integer elements.
    private int size;   // Current number of valid elements in the array.

    /**
     * Default constructor. Initializes the array to null and size to 0.
     */
    public ArrayManagement() {
        // Default constructor, no array is initialized.
    }

    /**
     * Constructor to initialize the array with a specific capacity.
     *
     * @param capacity The maximum number of elements the array can hold.
     */
    public ArrayManagement(int capacity) {
        // Create an array with the given capacity and initialize size to 0.
        this.arr = new int[capacity];
        this.size = 0;
    }

    /**
     * Method to input elements into the array. Prompts the user to enter
     * elements one by one using the `IO.getInteger` method. Stops if the array
     * is already full.
     */
    public void getElement() {
        // Check if the array is already full.
        if (size >= arr.length) {
            System.out.println("Array is already full");
        } else {
            // Loop through the array to fill all elements.
            for (int i = 0; i < arr.length; i++) {
                // Prompt the user for input and add it to the array.
                arr[size++] = IO.getPositiveInteger("Enter element[" + i + "]: ");
            }
        }
    }

    /**
     * Method to display the elements of the array. Outputs all valid elements
     * separated by a space.
     */
    public void displayData() {
        // Loop through the array up to the current size.
        for (int i = 0; i < size; i++) {
            // Print each element followed by a space.
            System.out.print(arr[i] + " ");
        }
        // Move to a new line after printing all elements.
        System.out.println();
    }

    /**
     * Sorts the array in ascending order using the Bubble Sort algorithm.
     * Operates only on the valid elements of the array (up to `size`).
     */
    public void bubbleSort() {
        // Outer loop for the number of passes (size - 1 passes needed).
        for (int i = 0; i < size - 1; i++) {
            // Inner loop for comparing adjacent elements.
            for (int j = 0; j < size - i - 1; j++) {
                // Swap elements if they are in the wrong order.
                if (arr[j] < arr[j + 1]) {
                    // Temporary variable to hold one element during the swap.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Inserts a new value into the array while maintaining its sorted order. If
     * the array is full, a new array with increased capacity is created.
     *
     * @param newValue The new value to insert into the array.
     */
    public void insertArray(int newValue) {
        // Check if the array is full. If so, create a new array with increased capacity.
        if (size >= arr.length) {
            // Create a new array with one additional slot.
            int[] newArr = new int[arr.length + 1];
            // Copy all elements from the old array to the new array.
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            // Replace the old array with the new array.
            arr = newArr;
        }

        // Find the correct position for the new value in the sorted array.
        int i;
        for (i = size - 1; i >= 0; i--) {
            // Shift elements to the right if they are greater than the new value.
            if (arr[i] < newValue) {
                arr[i + 1] = arr[i];
            } else {
                // Stop shifting when a smaller or equal element is found.
                break;
            }
        }

        // Insert the new value at the correct position.
        arr[i + 1] = newValue;

        // Increase the size to reflect the addition of a new element.
        size++;
    }
}
