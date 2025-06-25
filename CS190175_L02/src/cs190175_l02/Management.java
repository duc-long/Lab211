/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ToolistStudent | Templates
 * and open the template in the editor.
 */
package cs190175_l02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * L02 - Manage students. This class handles student management operations
 * including Creating a student record, Searching for students by name, Sorting
 * students alphabetically, Updating or deleting student records, Generating
 * reports of student courses.
 *
 * @author Nguyen Van Duc Long - CS190175 -18/2/2025
 */
public class Management {

    // Declare an ArrayList to store Student objects
    private ArrayList<Student> listStudent = new ArrayList<>();

    /**
     * Constructor to initialize the Management class with a list of students.
     *
     * @param listStudent The list of Student objects to be managed.
     */
    public Management(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    /**
     * Checks if a student record already exists in the list when adding a new
     * student. This method ensures that duplicate student entries are not added
     * to the list.
     *
     * @param id The student ID to check.
     * @param studentName The name of the student.
     * @param semester The semester in which the student is enrolled.
     * @param courseName The course that the student is taking.
     * @return `true` if the student record is unique (not already in the list),
     * `false` if the student with the same ID, name, semester, and course
     * already exists.
     */
    public boolean checkStudentExistC(String id,
            String studentName, String semester, String courseName) {
        // Loop through the student list to check for a duplicate entry.
        for (Student student : listStudent) {
            // If the student ID, name, semester, and course all match an existing record, return false.
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false; // Student already exists in the list.
            }
        }
        return true; // No duplicate found; the student record is unique.
    }

    /**
     * Checks whether a student's information has been changed. This method
     * compares the new input values with the existing student record.
     *
     * @param student The student object being updated.
     * @param name The new student name.
     * @param semester The new semester.
     * @param course The new course name.
     * @return `true` if the student's information has changed, `false` if it
     * remains the same.
     */
    public boolean checkChangeInfomation(Student student, String name, String semester, String course) {
        // Compare the new values with the existing student information.
        if (name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false; // No changes detected.
        }
        return true; // Information has been modified.
    }

    /**
     * Checks if a report entry already exists for a given student id and
     * course. This method prevents duplicate reports in the list.
     *
     * @param lr The list of reports.
     * @param id The student's id.
     * @param courseName The course name.
     * @return `true` if the report already exists, `false` otherwise.
     */
    public boolean checkReportExist(ArrayList<Report> lr, String id, String courseName) {
        // Loop through the list of reports to check for a match.
        for (Report report : lr) {
            // If a report with the same id and course name exists, return true.
            if (report.getId().equals(id) && report.getCourseName().equals(courseName)) {
                return true; // Report already exists.
            }
        }
        return false; // No matching report found.
    }

    /**
     * Method to create a new student record and add it to the student list.
     * This method ensures that students are added without duplication and
     * validates the input before adding the record.
     */
    public void createStudent() {
        // If the number of students reaches 10 or more, prompt the user for confirmation to continue.
        if (listStudent.size() >= 10) {
            System.out.print("Do you want to continue adding students? (Y/N): ");
            if (IO.checkInputYN()) { // Validate Yes/No user input.
                return; // Exit the method if the user does not want to continue.
            }
        }

        // Loop to ensure a valid and non-duplicate student entry is made.
        while (true) {

            // Prompt the user to enter a valid student ID.
            // Only letters, numbers, and spaces are allowed.
            String id = IO.getID("Enter student ID: ", "ID must only contain letters, numbers, and spaces.");

            String name = ""; // Variable to store the student's name if the ID already exists.
            boolean idExists = false; // Flag to check if the ID already exists in the list.

            // Iterate through the student list to check if the ID is already in use.
            for (Student student : listStudent) {
                if (id.equalsIgnoreCase(student.getId())) { // Case-insensitive comparison.
                    idExists = true;
                    name = student.getStudentName(); // Retrieve the existing student's name.
                    System.out.println("Hello " + name + "!"); // Hello the existing student.
                    break; // Exit the loop since the ID is found.
                }
            }

            // If the ID does not exist, prompt the user to enter the student's name.
            if (!idExists) {
                System.out.print("Enter student name: ");
                name = IO.checkInputName(); // Validate the name input.
            }

            // Prompt the user to enter the student's semester (only valid formats are accepted).
            System.out.print("Enter semester (0-9): ");
            String semester = IO.checkInputSemester();

            // Prompt the user to enter the student's course name (only valid courses are allowed).
            System.out.print("Enter course name: ");
            String course = IO.checkInputCourse();

            // Check if the student record already exists (same ID, name, semester, and course).
            if (checkStudentExistC(id, name, semester, course)) {
                // If the student does not exist in the list, create a new Student object and add it.
                listStudent.add(new Student(id, name, semester, course));

                // Print confirmation message.
                System.out.println("Student added successfully.");
                return; // Exit the method after successfully adding the student.
            }

            // If the student record already exists, print a message and exit.
            System.out.println("Duplicate entry detected, so the list remains unchanged.");
            return; // Exit the method if the student already exists in the list.
        }
    }

    /**
     * Method to sort the student list by the first letter of the last name and
     * then find students whose names match the user's search input. This method
     * sorts the list based on the last name and then checks if the student's
     * name contains the entered keyword.
     */
    public void findAndSort() {
        // Check if the student list is empty.
        if (listStudent.isEmpty()) {
            System.out.println("List is empty.");
            return; // Exit the method if there are no students.
        }

        // Get a valid name input from the user using the validation method.
        String name = IO.getSearchName("Enter name to search: ");

        // Sort the list of students by the first letter of their last name and length of name.
        Collections.sort(listStudent, Comparator
                .comparing((Student student) -> {
                    // Split the full name into parts using whitespace as a delimiter.
                    String[] parts = student.getStudentName().trim().split("\\s+");

                    // Get the last part of the name (the last name).
                    String lastName = parts[parts.length - 1];

                    // Extract the first character of the last name and sorting.
                    return lastName.substring(0, 1);
                }).thenComparingInt(student -> student.getStudentName().length()) // If there are duplicate letters, compare by name length
        );
        // If the user presses Enter without entering anything, display the entire list
        if (name.isEmpty()) {
            getStudentByListFound(listStudent);
            return;
        }
        // Create a new list to store students that match the search criteria.
        ArrayList<Student> matchedStudents = new ArrayList<>();

        // Iterate through the sorted list of students to find matches.
        for (Student student : listStudent) {
            // Check if the student's name contains the search input.
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                // Add the matched student to the new list.
                matchedStudents.add(student);
            }
        }

        // If no students match the search, display a message.
        if (matchedStudents.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            // Display the sorted and filtered list of students.
            getStudentByListFound(matchedStudents);
        }
    }

    /**
     * Method to retrieve a list of students that match a given student ID. It
     * searches the student list and returns a new list containing only the
     * students whose ID matches the given input.
     *
     * @param id The student ID to search for.
     * @return A list of students that match the given ID.
     */
    public ArrayList<Student> listStudentOfId(String id) {
        // Create a new list to store students that match the given ID.
        ArrayList<Student> listStudentOfId = new ArrayList<>();

        // Iterate through the student list to find students with the matching ID.
        for (Student student : listStudent) {
            // Check if the student's ID matches the input ID (case-insensitive).
            if (id.equalsIgnoreCase(student.getId())) {
                // Add the matched student to the new list.
                listStudentOfId.add(student);
            }
        }

        // Return the list of students with the matching ID.
        return listStudentOfId;
    }

    /**
     * Method to display a formatted table of students found by a search query.
     * This method dynamically adjusts column widths based on the longest string
     * in each column, ensuring a clean and readable table format.
     *
     * @param listStudentFindByName The list of students that match the search
     * criteria.
     */
    public void getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        // Print a title for the list of found students.
        System.out.println("List of students found:");

        // Initialize default column widths for table formatting.
        int maxNameLength = 12;  // Default minimum width for the "Student Name" column.
        int maxSemesterLength = 8;  // Default minimum width for the "Semester" column.
        int maxCourseLength = 10;   // Default minimum width for the "Course Name" column.

        // Iterate through the list of students to determine the longest string in each column.
        for (Student student : listStudentFindByName) {
            // Update maxNameLength if the student's name is longer than the current max.
            maxNameLength = Math.max(maxNameLength, student.getStudentName().length());

            // Update maxSemesterLength if the semester length is longer than the current max.
            maxSemesterLength = Math.max(maxSemesterLength, student.getSemester().length());

            // Update maxCourseLength if the course name is longer than the current max.
            maxCourseLength = Math.max(maxCourseLength, student.getCourseName().length());
        }

        // Generate a horizontal divider line based on the calculated column widths.
        // This helps to format the table properly and separate rows visually.
        String dividerLine = "+" + String.join("+",
                String.join("", Collections.nCopies(5, "-")), // Column for "No."
                String.join("", Collections.nCopies(maxNameLength + 2, "-")), // Column for "Student Name"
                String.join("", Collections.nCopies(maxSemesterLength + 2, "-")), // Column for "Semester"
                String.join("", Collections.nCopies(maxCourseLength + 3, "-"))) + "+";  // Column for "Course Name"

        // Print the divider line before the header.
        System.out.println(dividerLine);

        // Construct the table header row with dynamically adjusted column widths.
        String header = "| " + String.format("%-3s", "No.") // Serial number column.
                + " | " + String.format("%-" + maxNameLength + "s", "Student Name") // Student Name column.
                + " | " + String.format("%-" + maxSemesterLength + "s", "Semester") // Semester column.
                + " | " + String.format("%-" + (maxCourseLength + 1) + "s", "Course Name") + " |"; // Course Name column.

        // Print the formatted header row.
        System.out.println(header);

        // Print another divider line after the header.
        System.out.println(dividerLine);

        // Iterate through the student list and print each student's details in table format.
        int count = 1;  // Counter for numbering each student.
        for (Student student : listStudentFindByName) {
            // Print a formatted row for each student with properly aligned columns.
            System.out.printf("| %-3d | %-" + maxNameLength + "s | %-" + maxSemesterLength + "s | %-" + (maxCourseLength + 1) + "s |\n",
                    count++, student.getStudentName(), student.getSemester(), student.getCourseName());

            // Print a divider line after each row to separate student records.
            System.out.println(dividerLine);
        }
    }

    /**
     * Method to update or delete a student record. The user is first prompted
     * to enter a student ID, and if multiple students share the same ID, they
     * are presented with a numbered list. The user can then choose to either
     * update or delete the selected student record.
     *
     */
    public void updateOrDelete() {
        // Check if the student list is empty.
        if (listStudent.isEmpty()) {
            System.out.println("List is empty.");
            return; // Exit the method if there are no students.
        }

        // Prompt the user to enter a student ID to update or delete.
        String id = IO.getID("Enter student ID to update/delete: ",
                "ID must only contain letters, numbers, and spaces.");
        // Get list of students matching the ID
        ArrayList<Student> studentsWithID = listStudentOfId(id);

        // Find all students who have the entered ID.
        listStudentOfId(id);

        // Check if any students were found with the given ID.
        if (studentsWithID.isEmpty()) {
            System.out.println("No student found with this ID.");
            return; // Exit if no student matches the given ID.
        } else {
            // Display the list of students found.
            getStudentByListFound(listStudentOfId(id));
            Student student; // Variable to hold the selected student.

            // If there's only **one student** with the given ID, select them automatically.
            if (studentsWithID.size() == 1) {
                student = studentsWithID.get(0);
            } else {
                // If multiple students have the same ID, ask for selection.
                System.out.print("Enter student number: ");
                int choice = IO.getRange(1, studentsWithID.size()); // Validate selection.
                student = studentsWithID.get(choice - 1); // Get selected student.
            }
            // Ask the user whether they want to update or delete the student.
            System.out.print("Do you want to update (U) or delete (D) the student? ");

            // If the user chooses to update:
            if (IO.checkInputUD()) {
                // Prompt the user to enter updated student details.
                System.out.print("Enter new student name: ");
                String name = IO.checkUpdateInputName(student.getStudentName()); // Validate new student name.
                System.out.print("Enter new semester (0-9): ");
                String semester = IO.checkUpdateInputSemester(student.getSemester()); // Validate new semester.

                System.out.print("Enter new course: ");
                String course = IO.checkUpdateInputCourse(student.getCourseName()); // Validate new course name.

                // Check if the updated information is the same as the current data.
                if (!checkChangeInfomation(student, name, semester, course)) {
                    System.out.println("No changes detected.");
                    return; //Exit when no change information
                }
                // Check if the new semester and course combination already exists
                if (!checkStudentExistC(id, name, semester, course)) {
                    System.out.println("A student with the same Semester and Course already exists.");
                    return; //Exit when semester and course is duplicate
                }
                // If multiple students share the same ID, update all names
                if (studentsWithID.size() > 1) {
                    for (Student s : studentsWithID) {
                        s.setStudentName(name); //Set all name in list if have multiple student name have the same ID
                    }
                }
                // If it does not exist, update the student record.
                student.setStudentName(name);
                student.setSemester(semester);
                student.setCourseName(course);
                System.out.println("Student updated successfully.");
            } else {
                // If the user chooses to delete, remove the student from the list.
                listStudent.remove(student);
                System.out.println("Student deleted successfully.");
            }
        }
    }

    /**
     * Method to generate and display a report on the total number of courses
     * each student is enrolled in. The report is displayed in a formatted
     * table.
     *
     */
    public void report() {
        // Check if the student list is empty.
        if (listStudent.isEmpty()) {
            System.out.println("List is empty.");  // Print message if no students are present.
            return;  // Exit the method if the list is empty.
        }
        // Create a arraylist to store the generated report.
        ArrayList<Report> lr = new ArrayList<>();

        // Loop through the student list to calculate the total number of courses
        // each student is enrolled in.
        for (Student student : listStudent) {
            String id = student.getId(); //Get the student's id
            String studentName = student.getStudentName(); //Get the student's name
            String courseName = student.getCourseName();  // Get the student's course name.

            // Initialize a counter to calculate the total number of times the student
            // is enrolled in the same course.
            int total = 0;

            // Loop through the list again to count how many times the student is
            // enrolled in the same course.
            for (Student studentCountTotal : listStudent) {
                // If the student ID and course name match, increment the count.
                if (student.getId().equalsIgnoreCase(studentCountTotal.getId())
                        && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                    total++;
                }
            }

            // Add the report to the list if it doesn't already exist.
            if (!checkReportExist(lr, id, courseName)) {
                // Add a new Report object containing student name, course, and total courses.
                lr.add(new Report(id, studentName, courseName, total));
            }
        }

        // If the report list is empty, display a message and exit.
        if (lr.isEmpty()) {
            System.out.println("No reports to display.");
            return;  // Exit if there are no reports to show.
        }

        // Calculate the column widths dynamically based on the longest string
        // in each column.
        int maxNameLength = 12;  // Default minimum width for the "Student Name" column.
        int maxCourseLength = 10;  // Default minimum width for the "Course" column.
        int maxTotalLength = 16;   // Default minimum width for the "Total Courses" column.

        // Loop through each report and update column widths as necessary.
        for (Report report : lr) {
            maxNameLength = Math.max(maxNameLength, report.getStudentName().length());
            maxCourseLength = Math.max(maxCourseLength, report.getCourseName().length());
            maxTotalLength = Math.max(maxTotalLength, String.valueOf(report.getTotalCourse()).length());
        }

        // Generate a horizontal divider line based on column widths.
        // This creates the visual separation between header and content.
        String dividerLine = "+" + String.join("+",
                String.join("", Collections.nCopies(5, "-")), // For "No."
                String.join("", Collections.nCopies(maxNameLength + 2, "-")), // For "Student Name"
                String.join("", Collections.nCopies(maxCourseLength + 2, "-")), // For "Course"
                String.join("", Collections.nCopies(maxTotalLength + 2, "-"))) + "+";  // For "Total Courses"

        // Print the divider line before the header.
        System.out.println(dividerLine);

        // Construct the table header row with dynamically adjusted column widths.
        String header = "| " + String.format("%-2s", "No.") // For numbering the report rows.
                + " | " + String.format("%-" + maxNameLength + "s", "Student Name") // For "Student Name" column.
                + " | " + String.format("%-" + maxCourseLength + "s", "Course") // For "Course" column.
                + " | " + String.format("%-" + maxTotalLength + "s", "Total of Courses") + " |";  // For "Total of Courses" column.

        // Print the header row.
        System.out.println(header);

        // Print the divider line after the header.
        System.out.println(dividerLine);

        // Iterate through the report list and print each report's details in a formatted table.
        int count = 1;  // Initialize a counter to number the report rows.
        for (Report report : lr) {
            // Print a formatted row for each report.
            System.out.printf("| %-3d | %-" + maxNameLength + "s | %-" + maxCourseLength + "s | %-" + maxTotalLength + "d |\n",
                    count++, report.getStudentName(), report.getCourseName(), report.getTotalCourse());

            // Print the divider line after each row to separate the report entries.
            System.out.println(dividerLine);
        }
    }

}
