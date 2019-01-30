package org.osama.hadara.financial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Payment {
    double payments;
    LocalDate datePayments;
    LocalTime timePayments;
    String notice;


    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public LocalDate getDatePayments() {
        return datePayments;
    }

    public void setDatePayments(LocalDate datePayments) {
        this.datePayments = datePayments;
    }

    public LocalTime getTimePayments() {
        return timePayments;
    }

    public void setTimePayments(LocalTime timePayments) {
        this.timePayments = timePayments;
    }
}
