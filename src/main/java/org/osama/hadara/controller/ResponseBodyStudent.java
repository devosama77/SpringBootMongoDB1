package org.osama.hadara.controller;

import org.osama.hadara.student.model.Student;

import java.util.List;

public class ResponseBodyStudent {
    String text;
    List<Student> students;
    Student student;
    public ResponseBodyStudent() {
    }

    public ResponseBodyStudent(String text) {
        this.text = text;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ResponseBodyStudent{" +
                "text='" + text + '\'' +
                '}';
    }
}
