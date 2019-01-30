package org.osama.hadara.subject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SubjectDetails {

    LocalDate registerDate;
    LocalDate beginDate;
    LocalDate endDate;



    public SubjectDetails(LocalDate registerDate,
                          LocalDate beginDate,
                          LocalDate endDate,
                          String notice) {

        this.registerDate = registerDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
    public SubjectDetails() {
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }


    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
