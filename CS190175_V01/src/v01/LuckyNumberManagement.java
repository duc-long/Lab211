/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

import java.util.Random;

/**
 * V01 - LuckyGame - ID: FA21_03
 *
 * This class manages the core functionality of a "Lucky Number Game," including
 * generating random numbers, processing player guesses, and providing a game
 * summary.
 *
 * @author Nguyen Van Duc Long - CS190175 - 15/1/2025
 */
public class LuckyNumberManagement {

    // Maximum possible value for the random lucky number.
    private static final int MAXNUM = 10;

    // Instance variables to keep track of game statistics.
    private int totalGame; // Total number of games played.
    private int totalGuess; // Total number of guesses across all games.
    private int guessAvg; // Average number of guesses per game.
    private int bestGame; // Fewest guesses in a single game.

    /**
     * Default constructor initializes the game statistics.
     */
    public LuckyNumberManagement() {
        this.totalGame = 0; // No games have been played initially.
        this.totalGuess = 0; // No guesses have been made initially.
        this.guessAvg = 0; // Average guesses start at 0.
        this.bestGame = Integer.MAX_VALUE; // Best game initialized to maximum (no games yet).
    }

    /**
     * Generates a random lucky number within the range 0 -> Maximum
     * number(100).
     *
     * @return The generated lucky number.
     */
    public int random() {
        // Create an instance of the Random class.
        Random random = new Random();
        // Generate a random number between 0 and MAXNUM (inclusive).
        int luckyNumber = random.nextInt(MAXNUM)+1;

        // Inform the player that the lucky number has been generated.
        System.out.println("Lucky Number has been generated!");

        // Return the generated lucky number.
        return luckyNumber;
    }

    /**
     * Processes the game by comparing player guesses to the lucky number.
     *
     * @param input The player's initial guess.
     * @param luckyNumber The randomly generated lucky number.
     * @return The number of guesses made by the player during this game.
     */
    public int play(int input, int luckyNumber) {
        // Initialize a counter to track the number of guesses for this game.
        int guessCount = 0;

        // Enter a loop to repeatedly prompt the player for guesses until they guess correctly.
        while (true) {
            // Increment the guess counter for this game and overall guesses.
            guessCount++;
            totalGuess++;

            // Provide feedback based on the player's guess compared to the lucky number.
            if (input > luckyNumber) {
                System.out.println("The lucky number is smaller than the number you guessed.");
            } else if (input < luckyNumber) {
                System.out.println("The lucky number is larger than the number you guessed.");
            } else {
                // If the player guesses correctly, congratulate them and break the loop.
                System.out.println("Congratulations! You've guessed the lucky number after " + guessCount + " guesses.");
                break;
            }

            // Prompt the player for another guess using the IO utility class.
            input = IO.getInteger("Try again: ");
        }

        // Increment the total number of games played.
        totalGame++;

        // Update the best game record if this game had fewer guesses than the previous best.
        if (guessCount < bestGame) {
            bestGame = guessCount;
        }

        // Return the total number of guesses for this game.
        return guessCount;
    }

    /**
     * Displays a summary report of the player's performance in the game.
     */
    public void report() {
        // Print a header for the game summary.
        System.out.println("==== Game Summary ====");

        // Display the total number of games played.
        System.out.println("Total games played: " + totalGame);

        // Display the total number of guesses made.
        System.out.println("Total guesses made: " + totalGuess);

        // Calculate and display the average number of guesses per game. If not have average is 0.
        System.out.println("Average guesses per game: " + (totalGame > 0 ? (double) totalGuess / totalGame : 0));

        // Display the fewest number of guesses made in a single game.
        System.out.println("Best game (fewest guesses): " + (bestGame == Integer.MAX_VALUE ? 0 : bestGame));

        // Thank the player for playing the game.
        System.out.println("Thank you for playing the Lucky Number Game!");
    }
}
