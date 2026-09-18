package com.studentmanagement.exception;
/** Thrown when supplied application data violates a business rule. */
public class InvalidDataException extends RuntimeException { public InvalidDataException(String message) { super(message); } }
