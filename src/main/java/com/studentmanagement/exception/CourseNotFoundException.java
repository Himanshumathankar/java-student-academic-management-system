package com.studentmanagement.exception;
/** Indicates that a requested course code is unknown. */
public class CourseNotFoundException extends RuntimeException { public CourseNotFoundException(String code) { super("Course " + code + " was not found."); } }
