package com.studentmanagement.service;
import com.studentmanagement.exception.*; import com.studentmanagement.model.Student; import com.studentmanagement.repository.StudentRepository; import com.studentmanagement.utility.InputValidator; import java.util.*;
/** Validates and coordinates student operations. */
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){this.repository=repository;}
    public Student add(String id,String name,String email,String department,int semester){Student s=validated(id,name,email,department,semester);repository.add(s);return s;}
    public Student update(String id,String name,String email,String department,int semester){Student s=validated(id,name,email,department,semester);repository.update(s);return s;}
    private Student validated(String id,String name,String email,String department,int semester){return new Student(InputValidator.required(id,"Student ID"),InputValidator.required(name,"Name"),InputValidator.email(email),InputValidator.required(department,"Department"),InputValidator.range(semester,1,12,"Semester"));}
    public Student find(String id){return repository.findById(id).orElseThrow(()->new StudentNotFoundException(id));} public List<Student> all(){return repository.findAll();}
    public List<Student> searchByName(String q){String term=q.toLowerCase(Locale.ROOT);return repository.findAll().stream().filter(s->s.getName().toLowerCase(Locale.ROOT).contains(term)).toList();}
    public void delete(String id){repository.delete(id);} public void save(){repository.save();}
}
