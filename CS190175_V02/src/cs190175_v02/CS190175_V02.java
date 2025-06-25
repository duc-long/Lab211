/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v02;

/**
 * V02 - ID: FA21_09 - Car Showroom
 *
 * @author Nguyen Van Duc Long - CS190175 - 9/2/2025
 */
public class CS190175_V02 {

    /**
     * @param args the command line arguments
     * @throws cs190175_v02.CarException If an error occurs while processing the
     * car.
     */
    public static void main(String[] args) throws CarException {
        boolean check = false; // Flag to control the loop, determines when the program should stop.

        // Create an instance of CarManagement to handle car-related operations.
        CarManagement cm = new CarManagement();

        // The loop runs until the user decides to stop searching for cars.
        while (!check) {
            // Prompt the user to enter the name of the car.
            String inputCar = IO.getString("Name: ");
            // Retrieve the Car object based on the entered name.
            CarManagement.Car car = cm.getCar(inputCar);

            // Prompt the user to enter the car color.
            String inputColor = IO.getString("Color: ");
            // Retrieve the Color enum value corresponding to the user input.
            CarManagement.Color color = cm.getColors(inputColor);

            // Prompt the user to enter the price.
            String inputPirce = IO.getNumPrice("Price: ");

            // Prompt the user to enter the current day.
            String inputToday = IO.getString("Today: ");
            // Retrieve the Day enum value corresponding to the user input.
            CarManagement.Day day = cm.getDay(inputToday);

            // Check if the selected car, color, price, and day are valid for sale.
            cm.checkCar(car, color, inputPirce, day);

            // Prompt the user to decide whether to search for more cars.
            check = IO.checkPress("Do you want to find more? (Y/N): ");

            // If the user chooses "N" or "No", the loop exits.
            if (check) {
                break; // Exit the loop.
            }
        }
    }
}
