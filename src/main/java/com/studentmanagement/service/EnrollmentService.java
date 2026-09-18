package com.studentmanagement.service;
import com.studentmanagement.exception.InvalidDataException; import com.studentmanagement.model.*; import com.studentmanagement.repository.AcademicRepository; import java.util.*;
/** Coordinates enrollment, marks, and attendance while preserving references. */
public class EnrollmentService {
    private final StudentService students; private final CourseService courses; private final AcademicRepository repository;
    public EnrollmentService(StudentService s,CourseService c,AcademicRepository r){students=s;courses=c;repository=r;}
    public void enroll(String studentId,String courseCode){students.find(studentId);courses.find(courseCode);repository.enroll(studentId,courseCode);} public void remove(String s,String c){repository.unenroll(s,c);}
    public List<Course> coursesFor(String id){students.find(id);Set<String> codes=new HashSet<>();for(Enrollment e:repository.enrollments())if(e.studentId().equals(id))codes.add(e.courseCode());return courses.all().stream().filter(c->codes.contains(c.getCode())).toList();}
    public List<Student> studentsFor(String code){courses.find(code);Set<String> ids=new HashSet<>();for(Enrollment e:repository.enrollments())if(e.courseCode().equals(code))ids.add(e.studentId());return students.all().stream().filter(s->ids.contains(s.getId())).toList();}
    private AcademicRecord required(String s,String c){return repository.record(s,c).orElseThrow(()->new InvalidDataException("Student is not enrolled in that course."));}
    public void recordMarks(String s,String c,double a,double m,double f){required(s,c).setMarks(a,m,f);repository.save();} public void recordAttendance(String s,String c,int conducted,int attended){required(s,c).setAttendance(conducted,attended);repository.save();}
}
