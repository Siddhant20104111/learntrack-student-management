package com.airtribe.service;

import com.airtribe.entity.Student;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        students.add(student);
        System.out.println("Student added!");
    }

    public void listStudents() {
        for (Student s : students) {
            System.out.println(s.getDisplayName());
        }
    }

    public Student findStudentById(int studentId) throws EntityNotFoundException {
       for(Student student: students){
           if(student.getId()==studentId){
               return student;
           }
       }
        throw new EntityNotFoundException("Student not found with ID: " + studentId);
    }


    public  void deactivateStudent(int studentId) throws EntityNotFoundException {
        for(Student student: students){
            if(student.getId()==studentId){
                student.setActive(false);
                System.out.println("Student Deactivated SuccessFully.");
                return;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + studentId);
    }


}
