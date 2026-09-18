package com.studentmanagement.service;
import com.studentmanagement.exception.CourseNotFoundException; import com.studentmanagement.model.Course; import com.studentmanagement.repository.AcademicRepository; import com.studentmanagement.utility.InputValidator; import java.util.*;
/** Business operations for the course catalogue. */
public class CourseService {
    private final AcademicRepository repository; public CourseService(AcademicRepository r){repository=r;}
    public Course add(String code,String name,int credits,String faculty,int max){Course c=valid(code,name,credits,faculty,max);repository.addCourse(c);return c;} public Course update(String code,String name,int credits,String faculty,int max){Course c=valid(code,name,credits,faculty,max);repository.updateCourse(c);return c;}
    private Course valid(String c,String n,int cr,String f,int m){return new Course(InputValidator.required(c,"Course code"),InputValidator.required(n,"Course name"),InputValidator.range(cr,1,10,"Credits"),InputValidator.required(f,"Faculty"),InputValidator.range(m,1,1000,"Maximum marks"));}
    public Course find(String code){return repository.course(code).orElseThrow(()->new CourseNotFoundException(code));} public List<Course> all(){return repository.courses();} public List<Course> search(String q){String t=q.toLowerCase(Locale.ROOT);return all().stream().filter(c->c.getCode().toLowerCase(Locale.ROOT).contains(t)||c.getName().toLowerCase(Locale.ROOT).contains(t)).toList();} public void delete(String c){repository.deleteCourse(c);}
}
