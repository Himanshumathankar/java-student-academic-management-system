package com.studentmanagement.service;
import com.studentmanagement.model.*; import com.studentmanagement.repository.AcademicRepository; import com.studentmanagement.utility.GradeCalculator; import java.util.*; import java.util.stream.Collectors;
/** Computes reports from repository data without performing console I/O. */
public class ReportService {
    public record StudentMetric(Student student,double average,double attendance){} public record CourseMetric(Course course,long enrolled,double highest,double lowest,double average,long passed,long failed){}
    private final StudentService students; private final CourseService courses; private final AcademicRepository repository;
    public ReportService(StudentService s,CourseService c,AcademicRepository r){students=s;courses=c;repository=r;}
    public List<AcademicRecord> recordsFor(String id){students.find(id);return repository.records().stream().filter(r->r.getStudentId().equals(id)).toList();}
    public double average(String id){return recordsFor(id).stream().mapToDouble(AcademicRecord::total).average().orElse(0);}
    public double attendance(String id){return recordsFor(id).stream().mapToDouble(AcademicRecord::attendancePercentage).average().orElse(0);}
    public List<StudentMetric> topPerformers(){return students.all().stream().map(s->new StudentMetric(s,average(s.getId()),attendance(s.getId()))).sorted(Comparator.comparingDouble(StudentMetric::average).reversed()).toList();}
    public List<StudentMetric> lowAttendance(){return topPerformers().stream().filter(m->m.attendance()<75).toList();}
    public List<AcademicRecord> failed(){return repository.records().stream().filter(r->GradeCalculator.calculate(r.total()).equals("F")).toList();}
    public List<CourseMetric> coursePerformance(){return courses.all().stream().map(c->{DoubleSummaryStatistics x=repository.records().stream().filter(r->r.getCourseCode().equals(c.getCode())).collect(Collectors.summarizingDouble(AcademicRecord::total));long pass=repository.records().stream().filter(r->r.getCourseCode().equals(c.getCode())&&r.total()>=40).count();return new CourseMetric(c,x.getCount(),x.getCount()==0?0:x.getMax(),x.getCount()==0?0:x.getMin(),x.getAverage(),pass,x.getCount()-pass);}).toList();}
}
