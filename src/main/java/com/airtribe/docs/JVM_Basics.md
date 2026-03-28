# JVM Basics

## 1. What is JDK, JRE, JVM?

### JDK (Java Development Kit)

JDK is a complete package used for developing Java applications. It includes tools like the compiler (`javac`) and JRE.

### JRE (Java Runtime Environment)

JRE provides the environment required to run Java programs. It includes JVM and necessary libraries.

### JVM (Java Virtual Machine)

JVM is responsible for executing Java bytecode. It converts bytecode into machine-specific instructions.

---

## 2. What is Bytecode?

When Java code is compiled using `javac`, it is converted into an intermediate format called **bytecode** (.class file).

This bytecode is platform-independent and can run on any system with a JVM.

---

## 3. Write Once, Run Anywhere

Java follows the principle of **Write Once, Run Anywhere (WORA)**.

This means:

* Code is written once
* Compiled into bytecode
* Executed on any platform using JVM

The JVM ensures platform independence by handling system-specific execution.
