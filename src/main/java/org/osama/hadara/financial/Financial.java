package org.osama.hadara.financial;

import java.time.LocalDate;
import java.util.List;


public class Financial {
    long id;
    double fees;
    LocalDate feesDate;
    List<Payment> payments;

    String notice;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFeesDate() {
        return feesDate;
    }

    public void setFeesDate(LocalDate feesDate) {
        this.feesDate = feesDate;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
