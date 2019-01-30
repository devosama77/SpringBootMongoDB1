package org.osama.hadara.subject.model;
import org.osama.hadara.subject.model.Subject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Attendance {
    LocalDateTime attendancesDate;
    String endTime;
    int status;
    String notice;

    public Attendance() {
    }

    public Attendance(LocalDateTime attendancesDate, String endTime, int status, String notice) {
        this.attendancesDate = attendancesDate;
        this.endTime=endTime;
        this.status = status;
        this.notice = notice;
    }

    public LocalDateTime getAttendancesDate() {
        return attendancesDate;
    }

    public void setAttendancesDate(LocalDateTime attendancesDate) {
        this.attendancesDate = attendancesDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
