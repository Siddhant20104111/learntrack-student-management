package com.airtribe.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName, "");
        this.active = true;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
