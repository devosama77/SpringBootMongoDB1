package org.osama.hadara.student.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public class Student {
     @Id
     String idStudent;
     Details details;

     List<RegisterForStudent> registerStudents;


    public List<RegisterForStudent> getRegisterStudents() {
        return registerStudents;
    }

    public void setRegisterStudents(List<RegisterForStudent> registerStudents) {
        this.registerStudents = registerStudents;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }


}
