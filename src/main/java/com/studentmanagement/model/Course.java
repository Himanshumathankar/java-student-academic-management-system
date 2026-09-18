package com.studentmanagement.model;
/** A taught course and its assessment maximum. */
public class Course {
    private final String code; private String name; private int credits; private String facultyName; private int maximumMarks;
    public Course(String code,String name,int credits,String facultyName,int maximumMarks){this.code=code;this.name=name;this.credits=credits;this.facultyName=facultyName;this.maximumMarks=maximumMarks;}
    public String getCode(){return code;} public String getName(){return name;} public void setName(String v){name=v;}
    public int getCredits(){return credits;} public void setCredits(int v){credits=v;} public String getFacultyName(){return facultyName;} public void setFacultyName(String v){facultyName=v;}
    public int getMaximumMarks(){return maximumMarks;} public void setMaximumMarks(int v){maximumMarks=v;}
    @Override public String toString(){return "%s | %s | %d credits | %s | max %d".formatted(code,name,credits,facultyName,maximumMarks);}
}
