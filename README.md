# Student Academic Management & Performance Analysis System

## Overview

A terminal-based Java 17 application for managing students, courses, enrollments, assessment marks, attendance, and academic analytics. It is deliberately lightweight and demonstrates core Java rather than a web or enterprise framework.

## Problem Statement

Small academic departments need a reliable way to keep related student and course information, enforce basic rules, and turn raw marks and attendance into useful reports without requiring a database server.

## Objectives

- Maintain valid, persistent academic records.
- Prevent duplicate and inconsistent data.
- Calculate grades, averages, attendance, and course statistics.
- Provide a clear CLI that survives incorrect user input.
- Demonstrate object-oriented Java, collections, file handling, exceptions, lambdas, streams, and tests.

## Features and Functional Modules

- **Students:** add, view, update, delete, search, and sort by ID, name, marks, or attendance.
- **Courses:** create, update, delete, list, and search.
- **Enrollment:** enroll/unenroll and view either side of the relationship.
- **Marks:** assignment (20), midterm (30), and final (50), with validation.
- **Attendance:** conducted/attended classes, percentage, and a warning below 75%.
- **Reports:** individual academic report, top performers, low attendance, failed subjects, and per-course statistics.
- **Persistence:** automatic loading and saving in five local CSV files.

## Java Concepts Demonstrated

Encapsulation (`private` state), inheritance (`Student extends Person`), abstraction (`StudentRepository`), polymorphism (`displayDetails`), constructors, interfaces, method overriding, `ArrayList`, `HashMap`, `Set`, `Comparable`, `Comparator`, loops, streams, lambdas, custom exceptions, regex validation, try-with-resources, and JUnit 5.

## Technologies Used

Java 17, Maven, JUnit Jupiter 5, Java Collections, Java I/O, and `java.util.logging`. There are no runtime libraries, database, browser, API keys, or IDE requirements.

## Project Architecture

```text
ConsoleMenu -> Services -> Repository interfaces/implementations -> CSV files
                    \-> Utilities and domain models
```

The UI only gathers and displays data. Services hold use-case rules. Repositories own persistence. See [architecture details](docs/architecture.md) and [Mermaid diagrams](docs/diagrams.md).

## Folder Structure

```text
src/main/java/com/studentmanagement/
  model/       domain objects
  service/     use cases and reporting
  repository/  CSV persistence
  utility/     validation, files, grading
  exception/   meaningful application errors
  ui/          terminal menu
src/test/java/com/studentmanagement/  JUnit tests
data/                                sample CSV data
docs/                                design and testing notes
```

## Prerequisites

- JDK 17 or newer (`java -version`)
- Maven 3.8+ (`mvn -version`)

## Installation / Clone Repository

```bash
git clone <repository-url>
cd java-student-academic-management-system
```

## Build

```bash
mvn clean package
```

## Run

```bash
mvn exec:java
```

Or, after packaging:

```bash
java -jar target/student-academic-management.jar
```

To use a separate data directory: `java -Dstudent.data.dir=/path/to/data -jar target/student-academic-management.jar`.

## Testing

```bash
mvn test
```

The automated suite covers grade boundaries, invalid grades, email/field validation, student creation, duplicates, search, persistence, marks, and attendance. See [testing.md](docs/testing.md).

## Sample Usage

```text
1. Student Management
2. Course Management
...
Enter choice: 6
Choice: 2
Aarav Mehta | average 84.50%
Diya Nair | average 84.00%
```

More complete examples appear in [sample-output.md](docs/sample-output.md).

## Data Storage

`data/students.csv`, `courses.csv`, `enrollments.csv`, `marks.csv`, and `attendance.csv` are loaded at startup. Every mutation writes through immediately using a temporary file and atomic replacement where supported. For this intentionally simple CSV format, text fields may not contain commas or newlines.

## Error Handling

Expected mistakes become concise `ERROR:` messages. Custom exceptions describe missing students/courses, duplicate students/enrollments, and invalid values. Unexpected startup failures are logged with the JDK logger; routine menu actions are not logged.

## Diagrams

- [Architecture, use-case, workflow, class, sequence, and storage diagrams](docs/diagrams.md)

## Test Cases

The documented test matrix contains automated and manual scenarios without claiming unperformed manual results: [testing.md](docs/testing.md).

## Design Decisions

- **Maven** gives repeatable compile, test, package, and run commands.
- **Java 17** is an LTS release with broad educational compatibility.
- **CSV** is human-readable and needs no external service.
- **Layering** separates presentation, rules, and storage so each is explainable and testable.
- **Maps** provide quick ID lookup; lists preserve display flexibility; sets prevent duplicate enrollments.
- **Repository interface** demonstrates abstraction and allows alternate storage later.
- **Custom exceptions** express domain failures without leaking implementation details.

## Non-functional Requirements

- **Performance:** in-memory collections are suitable for normal departmental datasets.
- **Reliability:** writes use a temporary file and replacement; mutations persist immediately.
- **Usability:** looped menus, readable tables, and retrying numeric prompts.
- **Maintainability:** small packages and separated responsibilities.
- **Security:** validation rejects unsafe multiline/CSV field content; paths are application-configured.
- **Resource efficiency:** local text files and no background services.

## Future Enhancements

Quoted CSV fields, configurable assessment weights, authentication, import/export, backup history, and an optional database repository could be added without changing the UI-facing services.

## Author

- Name: **Himanshu Mathankar**
- Registration number: **23BAI10706**
- Program: **B.Tech CSE AIML**
- University: **VIT Bhopal University**

Before academic submission, add your own observations, challenges, and learnings from building and testing the application.
