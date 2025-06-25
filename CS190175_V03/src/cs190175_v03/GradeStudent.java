/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v03;

/**
 * V03 - ID: FA21_05 - Grade Student. This class represents a grading system for
 * students, including midterm, final exam, and homework scores. It calculates
 * the weighted score for each category and determines the overall grade.
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class GradeStudent {

    private int midTermWeight; // Weight for midterm exam
    private int finalWeight; // Weight for final exam
    private int homeWorkWeight; // Weight for homework

    /**
     * Gets a valid weight input from the user while ensuring the total weight
     * does not exceed 100.
     *
     * @return A valid weight input
     */
    public int getValidWeight() {
        // Prompt the user to enter a weight value
        int weight = IO.getInteger("Weight (0-100)? ");

        // Ensure that the total weight does not exceed 100
        while ((midTermWeight + finalWeight + homeWorkWeight + weight) > 100) {
            System.out.println("Total weight exceeds 100. Please enter a valid weight.");
            weight = IO.getInteger("Weight (0-100)? "); // Prompt user again
        }
        return weight; // Return valid weight value
    }

    /**
     * Processes midterm score, applies weight, and calculates the weighted
     * score.
     *
     * @return The weighted midterm score
     */
    public double midTerm() {
        System.out.println("Midterm:"); // Display midterm section header

        // Get valid weight for midterm
        midTermWeight = getValidWeight();

        // Validate weight range (should be between 0 and 100)
        while (midTermWeight < 0 || midTermWeight >= 100) {
             //Display error, must user try again
            System.out.println("Invalid weight. Please enter a value between 0 and 100.");
            midTermWeight = IO.getPositiveInteger("Weight (0-100)? ");
        }

        // Get midterm score from user and validate input (range 0-100)
        int score = IO.getPositiveInteger("Score earned? ");
        while (score < 0 || score > 100) {
             //Display error, must user try again
            System.out.println("Invalid score. Please enter a value between 0 and 100.");
            score = IO.getPositiveInteger("Score earned? ");
        }

        // Ask if score shifting is applied
        int shift = IO.getInteger("Were scores shifted (1=yes, 2=no)? ");
        while (shift != 1 && shift != 2) {
             //Display error, must user try again
            System.out.println("Invalid input. Enter 1 for yes, 2 for no.");
            shift = IO.getInteger("Were scores shifted (1=yes, 2=no)? ");
        }

        int shiftAmount = 0; // Initialize shift amount
        if (shift == 1) {
            shiftAmount = IO.getPositiveInteger("Shift amount? "); // Get shift amount if applicable
        }

        // Calculate total score after applying shift
        int totalPoint = score + shiftAmount;
        if (totalPoint > 100) {
            totalPoint = 100; // Ensure total points do not exceed 100
        }

        // Display total points earned
        System.out.println("Total points = " + totalPoint + " / 100");

        // Compute weighted score based on assigned midterm weight
        double weightScore = (double) totalPoint * midTermWeight / 100;

        // Display final weighted score
        System.out.println("Weight score = " + weightScore + " / " + midTermWeight);
        return weightScore; // Return final weighted score
    }

    /**
     * Processes final exam score, applies weight, and calculates the weighted
     * score.
     *
     * @return The weighted final exam score
     */
    public double finalExam() {
        System.out.println("\nFinal:"); // Display final exam section header

        // Get valid weight for final exam
        finalWeight = getValidWeight();

        // Validate weight range (should be between 0 and 100)
        while (finalWeight < 0 || finalWeight > 100) {
            //Display error, must user try again
            System.out.println("Invalid weight. Please enter a value between 0 and 100.");
            finalWeight = IO.getPositiveInteger("Weight (0-100)? ");
        }

        // Get final exam score and validate input (range 0-100)
        int score = IO.getPositiveInteger("Score earned? ");
        while (score < 0 || score > 100) {
             //Display error, must user try again
            System.out.println("Invalid score. Please enter a value between 0 and 100.");
            score = IO.getPositiveInteger("Score earned? ");
        }

        // Ask if score shifting is applied
        int shift = IO.getInteger("Were scores shifted (1=yes, 2=no)? ");
        while (shift != 1 && shift != 2) {
             //Display error, must user try again
            System.out.println("Invalid input. Enter 1 for yes, 2 for no.");
            shift = IO.getInteger("Were scores shifted (1=yes, 2=no)? ");
        }

        int shiftAmount = 0; // Initialize shift amount
        if (shift == 1) {
            shiftAmount = IO.getPositiveInteger("Shift amount? ");
        }

        // Calculate total score after applying shift
        int totalPoint = score + shiftAmount;
        if (totalPoint > 100) {
            totalPoint = 100; // Ensure total points do not exceed 100
        }

        // Display total points earned
        System.out.println("Total points = " + totalPoint + " / 100");

        // Compute weighted score based on assigned final weight
        double weightScore = (double) totalPoint * finalWeight / 100;

        // Display final weighted score
        System.out.println("Weight score = " + weightScore + " / " + finalWeight);
        return weightScore; // Return final weighted score
    }

    /**
     * Processes homework score, applies weight, and calculates the weighted
     * score.
     *
     * @return The weighted homework score
     */
    public double homeWork() {
        System.out.println("\nHomework: "); // Display homework section header

        // Get valid weight for homework
        homeWorkWeight = getValidWeight();

        // Validate weight range
        while (homeWorkWeight < 0 || homeWorkWeight > 100) {
            System.out.println("Invalid weight. Please enter a value between 0 and 100.");
            midTermWeight = IO.getPositiveInteger("Weight (0-100)? ");
        }

        // Get number of assignments
        int numAsg = IO.getPositiveInteger("Number of assignments? ");

        int totalScore = 0; // Sum of all assignment scores
        int totalMax = 0; // Sum of all assignment max scores
        int score = 0; // Individual assignment score
        int maxScore = 0; // Maximum possible score for an assignment

        // Loop through each assignment
        for (int i = 0; i < numAsg; i++) {
            // Get assignment score and max score from user input
            String input = IO.getString("Assignment " + (i + 1) + " score and max? ");
            String[] scoreAndMax = input.split("\\s+"); // Split score and max by space(can more spaces)
            score = Integer.parseInt(scoreAndMax[0]); // Assign first part of input to score
            maxScore = Integer.parseInt(scoreAndMax[1]); // Assign next part of input to score

            // Ensure max score is greater than 0
            while (maxScore <= 0) {
                System.out.println("Invalid max score. Max score must be greater than 0.");
                maxScore = IO.getPositiveInteger("Assignment " + (i + 1) + " max score? ");
            }

            // Ensure score is within valid range (0 to max score)
            while (score < 0 || score > maxScore) {
                System.out.println("Invalid score. Score must be between 0 and " + maxScore);
                score = IO.getPositiveInteger("Assignment " + (i + 1) + " score? ");
            }

            // Accumulate total scores and total max scores
            totalMax += maxScore;
            totalScore += score;
        }

        // Get number of sections attended
        int sectionsAttended = IO.getPositiveInteger("How many sections did you attend? ");

        // Calculate section points (5 points per section, max 30 points)
        int sectionPoints = sectionsAttended * 5;
        if (sectionPoints > 30) {
            sectionPoints = 30;
        }
        //Display section Point
        System.out.println("Section points = " + sectionPoints + " / 30");

        // Cap total max points at 150 if exceeded
        if (totalMax > 150) {
            totalMax = 150;
        }

        // Calculate total max points including section points
        int totalMaxPoint = totalMax + 30;

        // Calculate total earned points including section points
        int totalPoint = totalScore + sectionPoints;
        //Ensure totalPoint not over totalMaxPoint
        if (totalPoint > totalMaxPoint) {
            totalPoint = totalMaxPoint;
        }
        //Display total Point
        System.out.println("Total points = " + totalPoint + " / " + totalMaxPoint);

        // Compute weighted score
        double weightScore = (double) totalPoint / totalMaxPoint * homeWorkWeight;

        // Display weighted score
        System.out.printf("Weighted score = %.1f / %d\n", weightScore, homeWorkWeight);
        return weightScore;
    }

    /**
     * Generates and displays the final grade report based on weighted scores.
     *
     * @param midTermScore Weighted midterm score
     * @param finalScore Weighted final exam score
     * @param homeWorkScore Weighted homework score
     */
    public void report(double midTermScore, double finalScore, double homeWorkScore) {
        double overallScore = midTermScore + finalScore + homeWorkScore; // Calculate overall score of midTerm,final,homework.

        // Display overall percentage
        System.out.printf("\nOverall percentage = %.1f\n", overallScore);

        // Determine grade based on overall score
        if (overallScore >= 85.0) {
            // Display the grade and remarks for excellent performance.
            System.out.println("Your grade will be at least: 3.0");
            System.out.println("Excellent!");
        } else if (overallScore >= 75.0) {
            // Display the grade and remarks for good performance.
            System.out.println("Your grade will be at least: 2.0");
            System.out.println("Good job!");
        } else if (overallScore >= 60.0) {
            // Display the grade and comment for performance to try hard.
            System.out.println("Your grade will be at least: 0.7");
            System.out.println("Need to try harder");
        } else {
            // Display the grade and comment for failing performance.
            System.out.println("Your grade will be at least: 0.0");
            System.out.println("Pay tuition fee");
        }
    }
}
