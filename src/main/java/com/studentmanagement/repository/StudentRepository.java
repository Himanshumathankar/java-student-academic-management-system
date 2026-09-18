package com.studentmanagement.repository;
import com.studentmanagement.model.Student; import java.util.*;
/** Persistence abstraction for student records. */
public interface StudentRepository { void add(Student s); Optional<Student> findById(String id); List<Student> findAll(); void update(Student s); void delete(String id); void save(); }
