package com.airtribe.service;

import com.airtribe.entity.Course;
import com.airtribe.entity.Enrollment;
import com.airtribe.entity.Status;
import com.airtribe.entity.Student;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    private ArrayList<Enrollment> enrollments = new ArrayList<>();


    public void enrollStudentToCourse(int studentId, int courseId) {

        try {
            Student student = studentService.findStudentById(studentId);

            if (!student.isActive()) {
                System.out.println("Cannot enroll: Student is deactivated.");
                return;
            }

            Course course = courseService.findCourseById(courseId);

            if (!course.isActive()) {
                System.out.println("Cannot enroll: Course is deactivated.");
                return;
            }

            for (Enrollment e : enrollments) {
                if (e.getStudentId() == studentId && e.getCourseId() == courseId) {
                    System.out.println("Student is already enrolled in this course!");
                    return;
                }
            }

            int id = IdGenerator.getNextEnrollmentId();
            Enrollment enroll = new Enrollment(id, studentId, courseId, Status.ACTIVE);
            enrollments.add(enroll);

            System.out.println("Student enrolled to the course.");

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Enrollment> viewEnrollmentsForStudent(int studentId) {
        List<Enrollment> results = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                results.add(e);
            }
        }

        return results;
    }


    public void markEnrollmentStatus(int studentId, int courseId, Status status) throws EntityNotFoundException {

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId && e.getCourseId() == courseId) {
                e.setStatus(status);
                System.out.println("Status updated successfully.");
                break;
            }
        }

        throw new EntityNotFoundException(
                "Enrollment not found for Student ID: " + studentId +
                        " and Course ID: " + courseId
        );
    }

}
