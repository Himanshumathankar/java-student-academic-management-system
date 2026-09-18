# Sample Output

The following illustrates expected sessions; spacing may vary slightly.

## Startup

```text
========================================
STUDENT ACADEMIC MANAGEMENT SYSTEM
========================================
1. Student Management
2. Course Management
3. Enrollment Management
4. Marks Management
5. Attendance Management
6. Reports & Analytics
7. Save Data
8. Exit
Enter choice:
```

## Add student and create course

```text
ID: 23BME10006
Name: Anaya Kapoor
Email: anaya.kapoor@example.edu
Department: Mechanical Engineering
Semester: 2
Added: 23BME10006 | Anaya Kapoor | anaya.kapoor@example.edu | Mechanical Engineering | Semester 2

Code: MEC2101
Name: Engineering Mechanics
Credits: 4
Faculty: Dr. Ishaan Jain
Maximum marks: 100
Created: MEC2101 | Engineering Mechanics | 4 credits | Dr. Ishaan Jain | max 100
```

## Enrollment, marks, and attendance

```text
Student ID: 23BME10006
Course code: MEC2101
Enrollment created.

Assignment (0-20): 17
Midterm (0-30): 24
Final (0-50): 43
Saved. Total 84.00/100, grade A

Classes conducted: 40
Classes attended: 27
Saved. Attendance 67.50% — LOW ATTENDANCE
```

## Academic and low-attendance reports

```text
23BME10006 | Anaya Kapoor | anaya.kapoor@example.edu | Mechanical Engineering | Semester 2
MEC2101 | marks 84.00 | grade A | attendance 67.50% | LOW
Overall average: 84.00%

Anaya Kapoor | 67.50%
```

## Invalid input handling

```text
Semester: abc
ERROR: Enter a whole number.
Semester: 20
ERROR: Semester must be between 1 and 12.

Assignment (0-20): 25
ERROR: Marks must be within assignment 0-20, midterm 0-30, final 0-50.
```
