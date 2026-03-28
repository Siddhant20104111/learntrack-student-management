# LearnTrack - Student & Course Management System

## 📌 Project Description

LearnTrack is a console-based Student & Course Management System built using Core Java. It allows admins to manage students, courses, and enrollments through a menu-driven interface.

This project focuses on strengthening Java fundamentals such as OOP concepts, collections, exception handling, and clean code practices.

---

## 🚀 Features

### 👨‍🎓 Student Management

* Add new student
* View all students
* Search student by ID
* Deactivate student

### 📚 Course Management

* Add new course
* View all courses
* Activate/Deactivate course

### 📝 Enrollment Management

* Enroll student into a course
* View enrollments for a student
* Update enrollment status (ACTIVE / COMPLETED / CANCELLED)

---

## 🧠 Concepts Covered

* Java Basics (variables, loops, conditionals)
* OOP (Encapsulation, Inheritance, Polymorphism)
* Constructors & Method Overloading
* Collections (ArrayList)
* Exception Handling
* Static vs Instance Members
* Modular Design & Clean Code

---

## 🏗️ Project Structure

```
com.airtribe.learntrack
│
├── entity        # Student, Course, Enrollment, Person
├── service       # Business logic classes
├── ui            # Main class (menu-driven console UI)
├── exception     # Custom exceptions
├── util          # Utility classes (IdGenerator, Validator)
└── docs          # Documentation files
```

---

## ⚙️ How to Compile & Run

### Using Terminal

```bash
javac com/airtribe/learntrack/ui/Main.java
java com.airtribe.learntrack.ui.Main
```

### Using IDE

* Import project
* Run `Main.java`

---

## 📊 Class Diagram (Simplified)

```
        Person
          |
   ----------------
   |              |
Student        Trainer

Student --- Enrollment --- Course
```

---

## 📄 Documentation

* Setup Instructions → `docs/Setup_Instructions.md`
* JVM Basics → `docs/JVM_Basics.md`
* Design Notes → `docs/Design_Notes.md`

---

## 📌 Notes

* Data is stored in-memory using ArrayList
* No database or file persistence is used
* Designed for learning and practice purposes

---

## 🔗 Submission

* Push code to a **public GitHub repository**
* Submit via **Pull Request (PR)**

---
