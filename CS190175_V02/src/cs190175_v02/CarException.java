/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v02;

/**
 * V02 - ID: FA21_09 - Car Showroom This exception is thrown when invalid
 * operations occur in the CarManagement system.
 *
 * @author Nguyen Van Duc Long - CS190175 - 9/2/2025
 */
public class CarException extends Exception {

    /**
     * Constructor that accepts an error message and passes it to the parent
     * Exception class.
     *
     * @param message A descriptive error message indicating the cause of the
     * exception.
     */
    public CarException(String message) {
        // Pass the error message to the superclass (Exception) constructor
        super(message);
    }

}
