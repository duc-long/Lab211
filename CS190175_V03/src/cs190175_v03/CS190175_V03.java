/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_v03;

/**
 * V03 - ID: FA21_05 - Grade Student.
 *
 * @author Nguyen Van Duc Long - CS190175 - 4/2/2025
 */
public class CS190175_V03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Display introduction message
        IO.begin();

        // Create an instance of GradeStudent to handle student grading
        GradeStudent gs = new GradeStudent();

        // Retrieve and store the midterm score
        double midTerm = gs.midTerm();

        // Retrieve and store the final exam score
        double finalExam = gs.finalExam();

        // Retrieve and store the homework score
        double homeWork = gs.homeWork();

        // Generate and display the final grade report
        gs.report(midTerm, finalExam, homeWork);
    }

}
