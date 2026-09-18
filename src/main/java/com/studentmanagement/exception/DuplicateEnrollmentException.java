package com.studentmanagement.exception;
/** Indicates that a student is already enrolled in a course. */
public class DuplicateEnrollmentException extends RuntimeException { public DuplicateEnrollmentException(String studentId, String courseCode) { super(studentId + " is already enrolled in " + courseCode + "."); } }
