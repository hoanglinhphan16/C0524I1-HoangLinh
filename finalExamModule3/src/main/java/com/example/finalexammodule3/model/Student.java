package com.example.finalexammodule3.model;

public class Student {
    private int id;
    private String name;
    private String classStudent;

    public Student(){};

    public Student(int id, String name, String classStudent) {
        this.id = id;
        this.name = name;
        this.classStudent = classStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classStudent='" + classStudent + '\'' +
                '}';
    }
}
