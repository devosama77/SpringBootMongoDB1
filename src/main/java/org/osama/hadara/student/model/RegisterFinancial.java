package org.osama.hadara.student.model;

import org.osama.hadara.financial.Payment;

import java.time.LocalDate;
import java.util.List;

public class RegisterFinancial {
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

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public LocalDate getFeesDate() {
        return feesDate;
    }

    public void setFeesDate(LocalDate feesDate) {
        this.feesDate = feesDate;
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
