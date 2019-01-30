package org.osama.hadara.student.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class RegisterForStudent {

    long id;
    RegisterFinancial registerFinancial;
    List<RegisterSubjectForStudent> registerSubjectForStudents;
    String notice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RegisterFinancial getRegisterFinancial() {
        return registerFinancial;
    }

    public void setRegisterFinancial(RegisterFinancial registerFinancial) {
        this.registerFinancial = registerFinancial;
    }

    public List<RegisterSubjectForStudent> getRegisterSubjectForStudents() {
        return registerSubjectForStudents;
    }

    public void setRegisterSubjectForStudents(List<RegisterSubjectForStudent> registerSubjectForStudents) {
        this.registerSubjectForStudents = registerSubjectForStudents;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
