/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

/**
 * S01 - Program to insert a new element into an existing array.
 *
 * @author Nguyen Van Duc Long - CS190175 - 7/1/2025
 */
public class S01 {

    /**
     * Main method to execute the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Get the size of the array from the user.
        int size = IO.getInteger("Please enter size of array: ");

        //Create an instance of ArrayManagement with the specified size.
        ArrayManagement am = new ArrayManagement(size);

        //Prompt the user to input elements into the array.
        am.getElement();

        //Sort the array using Bubble Sort.
        am.bubbleSort();

        //Display the array after sorting.
        System.out.println("The array after sorting: ");
        am.displayData();

        //Prompt the user to input a new value to be inserted into the array.
        int newValue = IO.getInteger("Please enter new value: ");

        //Insert the new value into the array while maintaining sorted order.
        am.insertArray(newValue);

        //Display the updated array with the new element inserted.
        System.out.println("New array:");
        am.displayData();
    }

}
