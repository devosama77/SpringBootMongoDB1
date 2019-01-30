package org.osama.hadara.student.service;



import org.osama.hadara.student.model.Student;
import org.osama.hadara.student.dataAccess.StudentDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDAL studentDAL;
    @Override
    public Student saveStudent(Student student) {
        Student save = studentDAL.save(student);
        return save;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = studentDAL.getAll();
        return allStudents;
    }

    @Override
    public void deleteAllStudents() {
        studentDAL.deleteAll();

    }

    @Override
    public List<Student> getStudent(String id) {
        List<Student> students = studentDAL.getStudent(id);
        return students;
    }
}
