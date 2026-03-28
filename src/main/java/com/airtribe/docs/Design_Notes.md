# Design Notes

## 📌 Why ArrayList Instead of Array?

* Arrays have fixed size
* ArrayList is dynamic and resizable
* Easier to add/remove elements
* Provides built-in methods like `add()`, `remove()`, `size()`

---

## 📌 Use of Static Members

Static members are used in utility classes like `IdGenerator`.

### Why?

* To maintain a shared counter across all objects
* Ensures unique IDs
* No need to create object of utility class

Example:

```java
private static int studentId;
```

---

## 📌 Use of Inheritance

A base class `Person` is created with common fields:

* id
* firstName
* lastName
* email

`Student` extends `Person`.

### Benefits:

* Code reuse
* Avoid duplication
* Cleaner structure
* Easier maintenance

---

## 📌 Separation of Concerns

The project is divided into layers:

* **Entity Layer** → Data models
* **Service Layer** → Business logic
* **UI Layer** → User interaction

### Why?

* Improves readability
* Easier debugging
* Better scalability

---

## 📌 Exception Handling

Custom exception:

* `EntityNotFoundException`

Used when:

* Student or Course not found

### Benefit:

* Prevents program crash
* Provides user-friendly error messages

---

## 📌 Clean Code Practices

* Small, focused methods
* Meaningful names (`addStudent`, `findCourseById`)
* Avoid long methods
* Clear structure and readability

---
