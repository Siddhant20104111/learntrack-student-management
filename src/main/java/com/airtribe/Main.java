package com.airtribe;

import com.airtribe.entity.Course;
import com.airtribe.entity.Enrollment;
import com.airtribe.entity.Status;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.service.CourseService;
import com.airtribe.service.EnrollmentService;
import com.airtribe.service.StudentService;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService,courseService);

        while (true) {

            System.out.println("\n===== LearnTrack Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Deactivate Student");

            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Activate Course");
            System.out.println("8. Deactivate Course");

            System.out.println("9. Enroll Student to Course");
            System.out.println("10. View Enrollments for Student");
            System.out.println("11. Update Enrollment Status");

            System.out.println("0. Exit");

            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();

                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Batch: ");
                        String batch = sc.nextLine();

                        studentService.addStudent(fn, ln, email, batch);
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();

                        try {
                            System.out.println(
                                    studentService.findStudentById(sid).getDisplayName()
                            );
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter Student ID: ");
                        int deactivateId = sc.nextInt();

                        try {
                            studentService.deactivateStudent(deactivateId);
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.print("Course Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        System.out.print("Duration (weeks): ");
                        int duration = sc.nextInt();

                        courseService.addCourse(cname, desc, duration);
                        break;

                    case 6:
                        courseService.listCourses();
                        break;

                    case 7:
                        System.out.print("Enter Course ID: ");
                        int activateId = sc.nextInt();

                        try {
                            courseService.activateCourse(activateId);
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.print("Enter Course ID: ");
                        int deactivateCourseId = sc.nextInt();

                        try {
                            courseService.deactivateCourse(deactivateCourseId);
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 9:
                        System.out.print("Student ID: ");
                        int stId = sc.nextInt();

                        System.out.print("Course ID: ");
                        int crId = sc.nextInt();

                        enrollmentService.enrollStudentToCourse(stId, crId);
                        break;

                    case 10:
                        System.out.print("Enter Student ID: ");
                        int esid = sc.nextInt();

                        List<Enrollment> list = enrollmentService.viewEnrollmentsForStudent(esid);

                        if (list.isEmpty()) {
                            System.out.println("No enrollments found.");
                        } else {
                            for (Enrollment e : list) {
                                try {
                                    Course course = courseService.findCourseById(e.getCourseId());

                                    System.out.println(
                                            "Course: " + course.getCourseName() +
                                                    ", Status: " + e.getStatus()
                                    );

                                } catch (EntityNotFoundException ex) {
                                    System.out.println("Course not found for ID: " + e.getCourseId());
                                }
                            }
                        }
                        break;

                    case 11:
                        System.out.print("Student ID: ");
                        int sId = sc.nextInt();

                        System.out.print("Course ID: ");
                        int cId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Status (ACTIVE / COMPLETED / CANCELLED): ");
                        String input = sc.nextLine().toUpperCase();

                        try {
                            Status status = Status.valueOf(input);

                            enrollmentService.markEnrollmentStatus(sId, cId, status);

                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid status!");
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
            }
        }
    }
}