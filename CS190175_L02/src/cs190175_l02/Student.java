/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs190175_l02;

/**
 * L02 - Manage students. Student Management Class This class represents a student with
 * attributes such as ID, name, semester, and course name. It implements the
 * Comparable interface to allow sorting by student names in descending order.
 *
 * @author Nguyen Van Duc Long - CS190175 - 18/2/2025
 */
public class Student implements Comparable<Student> {

    // Private attributes to store student details.
    private String id;            // The unique student ID.
    private String studentName;   // The student's full name.
    private String semester;      // The semester the student is enrolled in.
    private String courseName;    // The course the student is taking.

    /**
     * Default constructor that initializes an empty student object.
     */
    public Student() {
    }

    /**
     * Parameterized constructor to initialize a student with given details.
     *
     * @param id The student's ID.
     * @param studentName The student's name.
     * @param semester The student's semester.
     * @param courseName The name of the course the student is taking.
     */
    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Getter method to retrieve the student's ID.
     *
     * @return The student's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method to update the student's ID.
     *
     * @param id The new student ID.
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
     * Getter method to retrieve the semester the student is enrolled in.
     *
     * @return The student's semester.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Setter method to update the student's semester.
     *
     * @param semester The new semester.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Getter method to retrieve the course name the student is taking.
     *
     * @return The student's course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter method to update the course name the student is taking.
     *
     * @param courseName The new course name.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Compares two students by name in descending order. This method is used
     * for sorting students based on their names.
     *
     * @param t The student object to compare with.
     * @return A negative integer if `t` comes before this student, a positive
     * integer if `t` comes after, and zero if they are equal.
     */
    @Override
    public int compareTo(Student t) {
        return t.studentName.compareTo(this.studentName); // Sort in descending order by student name.
    }

}
