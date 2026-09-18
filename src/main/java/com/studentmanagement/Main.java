package com.studentmanagement;
import com.studentmanagement.repository.*; import com.studentmanagement.service.*; import com.studentmanagement.ui.ConsoleMenu; import java.nio.file.Path; import java.util.logging.Logger;
/** Application entry point and dependency wiring. */
public final class Main {
    private static final Logger LOG=Logger.getLogger(Main.class.getName()); private Main(){}
    public static void main(String[] args){Path data=Path.of(System.getProperty("student.data.dir","data"));try{var studentRepo=new FileStudentRepository(data.resolve("students.csv"));var academicRepo=new AcademicRepository(data);var students=new StudentService(studentRepo);var courses=new CourseService(academicRepo);var enrollment=new EnrollmentService(students,courses,academicRepo);var reports=new ReportService(students,courses,academicRepo);LOG.info("Application started; data loaded from "+data.toAbsolutePath());new ConsoleMenu(students,courses,enrollment,reports,academicRepo).run();}catch(Exception e){LOG.severe("Application could not start: "+e.getMessage());System.err.println("ERROR: "+e.getMessage());}}
}
