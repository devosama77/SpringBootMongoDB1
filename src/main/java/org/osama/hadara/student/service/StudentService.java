package org.osama.hadara.student.service;

import org.osama.hadara.student.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteAllStudents();
    List<Student> getStudent(String id);
}
