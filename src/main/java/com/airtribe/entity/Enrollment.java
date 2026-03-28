package com.airtribe.entity;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private Status status;

    public Enrollment(int id, int studentId, int courseId, Status status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public int getStudentId(){
        return studentId;
    }

    public int getCourseId(){
        return courseId;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
       this.status= status;
    }

}
