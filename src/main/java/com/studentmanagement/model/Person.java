package com.studentmanagement.model;
/** Base type for people managed by the application. */
public abstract class Person {
    private final String id; private String name; private String email;
    protected Person(String id, String name, String email) { this.id=id; this.name=name; this.email=email; }
    public String getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public abstract String displayDetails();
}
