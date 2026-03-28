package com.airtribe.service;

import com.airtribe.entity.Course;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.util.IdGenerator;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(String name, String desc, int duration) {
        int id = IdGenerator.getNextCourseId();
        Course c = new Course(id, name, desc, duration);
        courses.add(c);
        System.out.println("Course added!");
    }

    public void listCourses() {
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public Course findCourseById(int courseId) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + courseId);
    }

    public void activateCourse(int courseId) throws EntityNotFoundException {
        for (Course c : courses) {
            if(c.getId()==courseId){
                c.setActive(true);
                System.out.println("Course Activated Successfully.");
                return;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + courseId);
    }

    public void deactivateCourse(int courseId) throws EntityNotFoundException {
        for (Course c : courses) {
            if(c.getId()==courseId){
                c.setActive(false);
                System.out.println("Course Deactivated Successfully.");
                return;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + courseId);
    }
}
