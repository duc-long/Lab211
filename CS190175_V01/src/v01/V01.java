/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

/**
 * V01 - LuckyGame - ID: FA21_03
 *
 * @author Nguyen Van Duc Long - CS190175 -15/1/2025
 */
public class V01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of LuckyNumberManagement to manage game logic and statistics.
        LuckyNumberManagement lnm = new LuckyNumberManagement();

        // Boolean flag to control the main game loop.
        boolean check = false;

        // Main game loop: Repeats the game until the user decides to quit.
        while (!check) {
            // Display the game title.
            System.out.println("=== LUCKY NUMBER GAME ===");

            //Generate a random lucky number for the current game.
            int luckyNumber = lnm.random();

            // Prompt the user to guess the lucky number.
            int input = IO.getInteger("Enter the number you guessed: ");

            //Play the game by comparing the user's guesses to the lucky number.
            lnm.play(input, luckyNumber);

            // Ask the user if they want to play another game.
            check = IO.checkPress("Do you want to play again? (Y/N): ");

            // If the user chooses "N" or "No", the loop exits.
            if (check) {
                break; // Exit the game loop.
            }
        }

        //After exiting the loop, display the summary report of all games played.
        lnm.report();

        // Display a thank-you message to the player.
        System.out.println("Thank you for playing!");
    }
}
