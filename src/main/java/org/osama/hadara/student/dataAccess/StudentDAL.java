package org.osama.hadara.student.dataAccess;

import org.osama.hadara.student.model.Student;
import org.osama.hadara.seq.exception.SequenceException;

import java.util.List;

public interface StudentDAL  {
    Student save (Student student)  throws SequenceException;
    List<Student> getAll();
    void deleteAll();
    List<Student> getStudent(String id);

}
