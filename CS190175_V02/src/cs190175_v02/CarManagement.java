/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v02;

/**
 * V02 - ID: FA21_09 - Car Showroom. This class manages car data, including
 * available colors, prices, and sale days. It also provides methods to check
 * car availability based on user input.
 *
 * @author Nguyen Van Duc Long - CS190175 - 9/2/2025
 */
public class CarManagement {

    /**
     * Enum representing different car brands with their associated colors,
     * prices, and sale days.
     */
    public enum Car {
        // Define three car brands with their available colors, prices, and sale days
        AUDI("WHITE", "YELLOW", "ORANGE", "5500", "3000", "4500", "FRIDAY", "SUNDAY", "MONDAY"),
        MERCEDES("GREEN", "BLUE", "PURPLE", "5000", "6000", "8500", "TUESDAY", "SATURDAY", "WEDNESDAY"),
        BMW("PINK", "RED", "BROWN", "2500", "3000", "3500", "MONDAY", "SUNDAY", "THURSDAY");

        // Array of available colors for each car brand
        private final String[] colors;
        // Array of available prices for each car brand
        private final String[] prices;
        // Array of sale days for each car brand
        private final String[] saleDays;

        /**
         * Constructor for Car enum.
         */
        Car(String color1, String color2, String color3, String price1, String price2, String price3, String day1, String day2, String day3) {
            this.colors = new String[]{color1, color2, color3}; // Store colors in array
            this.prices = new String[]{price1, price2, price3}; // Store prices in array
            this.saleDays = new String[]{day1, day2, day3}; // Store sale days in array
        }

        /**
         * Retrieves the available colors of the car brand.
         *
         * @return An array of color names.
         */
        public String[] getColors() {
            return colors;
        }

        /**
         * Retrieves the available prices of the car brand.
         *
         * @return An array of price values as strings.
         */
        public String[] getPrices() {
            return prices;
        }

        /**
         * Retrieves the sale days for the car brand.
         *
         * @return An array of days when sales occur.
         */
        public String[] getSaleDays() {
            return saleDays;
        }

    }

    /**
     * Enum representing different available car colors.
     */
    public enum Color {
        WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NONE; // NONE represents no color selected
    }

    /**
     * Enum representing the days of the week.
     */
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    /**
     * Retrieves a Car object based on its name.
     *
     * @param name The name of the car brand.
     * @return The corresponding Car object if found, otherwise null.
     */
    public Car getCar(String name) {
        for (Car car : Car.values()) { // Loop through all car brands
            if (car.name().equalsIgnoreCase(name)) { // Check if the name matches
                return car; // Return the found car
            }
        }
        return null; // Return null if no match is found
    }

    /**
     * Retrieves a Color object based on its name.
     *
     * @param color The name of the color.
     * @return The corresponding Color object if found, otherwise null.
     */
    public Color getColors(String color) {
        if (color.equalsIgnoreCase("No color")) { // Check for No color case
            return Color.NONE; // Return NONE enum
        }
        for (Color c : Color.values()) { // Loop through all colors
            if (c.name().equalsIgnoreCase(color)) { // Check if name matches 
                return c; // Return matched color
            }
        }
        return null; // Return null if no match found
    }

    /**
     * Retrieves a Day object based on its name.
     *
     * @param day The name of the day.
     * @return The corresponding Day object if found, otherwise null.
     */
    public Day getDay(String day) {
        for (Day d : Day.values()) { // Loop through all days of the week
            if (d.name().equalsIgnoreCase(day)) { // Check if name matches
                return d; // Return matched day
            }
        }
        return null; // Return null if no match found
    }

    /**
     * Checks if a car is available for sale based on color, price, and sale
     * day.
     *
     * @param car The car to be checked.
     * @param color The selected color.
     * @param price The selected price.
     * @param day The selected sale day.
     * @return The car object if available, otherwise null.
     * @throws CarException if any condition is not met.
     */
    public Car checkCar(Car car, Color color, String price, Day day) throws CarException {
        try {
            // Check if car is null, throw Exception
            if (car == null) {
                throw new CarException("Car break");
            }

            // Check if color is null, throw Exception
            if (color == null) {
                throw new CarException("Color does not exist");
            }

            // Check if day is null, throw Exception
            if (day == null) {
                throw new CarException("Car can't sell today");
            }

            // Validate if price is a valid number
            if (!price.matches("^-?[0-9]+$")) { // Regular expression to check if price is numeric
                throw new CarException("Price must be a digit");
            }

            // Convert price to integer
            int priceValue = Integer.parseInt(price);
            if (priceValue < 0) { // Ensure price is non-negative
                throw new CarException("Price greater than zero");
            }

            // Check if price is available for the car
            boolean priceMatch = false;
            for (String p : car.getPrices()) { // Loop through available prices
                if (price.equals(p) || (color == Color.NONE // Check if price matches
                        && Integer.parseInt(price) == Integer.parseInt(p) - 100)) { // If input color is no color, price will be minus 100
                    priceMatch = true;
                    break; // Stop checking once a match is found
                }
            }
            if (!priceMatch) { // If no matching price was found, throw exception
                throw new CarException("Price is not available for this car");
            }

            System.out.println("Sell car."); // Print confirmation
            return car; // Return the car

        } catch (CarException e) { // Catch exception if any condition fails
            System.out.println("Can't sell car\n" + e.getMessage()); // Print error message
            return null; // Return null since car cannot be sold
        }
    }
}
