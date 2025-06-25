/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_l02;

/**
 * L02 - Manage students. Student Course Report This class represents a report that summarizes
 * the total number of courses a student is enrolled in for a given subject.
 *
 * @author Nguyen Van Duc Long - CS190175 - 18/2/2025
 */
public class Report {

    // Private attributes to store report details.
    private String id;           // The id of student
    private String studentName;  // The full name of the student.
    private String courseName;   // The name of the course the student is taking.
    private int totalCourse;     // The total number of times the student has enrolled in the course.

    /**
     * Default constructor that initializes an empty report object.
     */
    public Report() {
    }

    /**
     * Parameterized constructor to initialize a report with given details.
     *
     * @param id The ID of student
     * @param studentName The student's name.
     * @param courseName The course name.
     * @param totalCourse The total number of times the student has taken this
     * course.
     */
    public Report(String id, String studentName, String courseName, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    /**
     * Getter method to retrieve the student's id.
     *
     * @return The student's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method to update the student's id.
     *
     * @param id The new student's id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method to retrieve the student's name.
     *
     * @return The student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Setter method to update the student's name.
     *
     * @param studentName The new student name.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Getter method to retrieve the course name.
     *
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter method to update the course name.
     *
     * @param courseName The new course name.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter method to retrieve the total number of times the student has taken
     * this course.
     *
     * @return The total number of enrollments in the course.
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * Setter method to update the total number of times the student has taken
     * this course.
     *
     * @param totalCourse The new total course count.
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
