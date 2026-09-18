package com.studentmanagement.exception;
/** Indicates that a requested student ID is unknown. */
public class StudentNotFoundException extends RuntimeException { public StudentNotFoundException(String id) { super("Student ID " + id + " was not found."); } }
