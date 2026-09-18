package com.studentmanagement.model;
/** A university student. Natural ordering is by ID. */
public class Student extends Person implements Comparable<Student> {
    private String department; private int semester;
    public Student(String id,String name,String email,String department,int semester){super(id,name,email);this.department=department;this.semester=semester;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public int getSemester(){return semester;} public void setSemester(int v){semester=v;}
    @Override public String displayDetails(){return "%s | %s | %s | %s | Semester %d".formatted(getId(),getName(),getEmail(),department,semester);}
    @Override public int compareTo(Student other){return getId().compareToIgnoreCase(other.getId());}
}
