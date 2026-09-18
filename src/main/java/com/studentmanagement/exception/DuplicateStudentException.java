package com.studentmanagement.exception;
/** Indicates an attempt to reuse a student ID. */
public class DuplicateStudentException extends RuntimeException { public DuplicateStudentException(String id) { super("Student ID " + id + " already exists."); } }
