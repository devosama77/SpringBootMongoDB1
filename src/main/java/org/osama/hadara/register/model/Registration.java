package org.osama.hadara.register.model;

import org.osama.hadara.financial.Financial;
import org.osama.hadara.subject.model.RegisterSubject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "registrations")
public class Registration {
    @Id
    String id;
    int phase;
    int level;
    Financial financial;
    @DBRef
    List<RegisterSubject> registerSubjects;
    String notice;

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Financial getFinancial() {
        return financial;
    }

    public void setFinancial(Financial financial) {
        this.financial = financial;
    }

    public List<RegisterSubject> getRegisterSubjects() {
        return registerSubjects;
    }

    public void setRegisterSubjects(List<RegisterSubject> registerSubjects) {
        this.registerSubjects = registerSubjects;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }





}
