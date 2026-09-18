package com.studentmanagement.model;
import com.studentmanagement.exception.InvalidDataException;
/** Marks and attendance for one enrollment. */
public class AcademicRecord {
    private final String studentId, courseCode; private double assignment, midterm, finalExam; private int conducted, attended;
    public AcademicRecord(String s,String c,double a,double m,double f,int conducted,int attended){studentId=s;courseCode=c;setMarks(a,m,f);setAttendance(conducted,attended);}
    public void setMarks(double a,double m,double f){if(a<0||a>20||m<0||m>30||f<0||f>50)throw new InvalidDataException("Marks must be within assignment 0-20, midterm 0-30, final 0-50.");assignment=a;midterm=m;finalExam=f;}
    public void setAttendance(int c,int a){if(c<0||a<0||a>c)throw new InvalidDataException("Attendance must be non-negative and attended cannot exceed conducted.");conducted=c;attended=a;}
    public String getStudentId(){return studentId;} public String getCourseCode(){return courseCode;} public double getAssignment(){return assignment;} public double getMidterm(){return midterm;} public double getFinalExam(){return finalExam;}
    public int getClassesConducted(){return conducted;} public int getClassesAttended(){return attended;} public double total(){return assignment+midterm+finalExam;} public double attendancePercentage(){return conducted==0?0:attended*100.0/conducted;}
}
