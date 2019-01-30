package org.osama.hadara.subject.model;

public class Meeting {
    int startTimeH;
    int startTimeM;
    int endTimeH;
    int endTimeM;
    String day;


    public Meeting(int startTimeH, int startTimeM, int endTimeH, int endTimeM, String day) {
        this.startTimeH = startTimeH;
        this.startTimeM = startTimeM;
        this.endTimeH = endTimeH;
        this.endTimeM = endTimeM;
        this.day = day;
    }

    public Meeting() {
    }

    public int getStartTimeH() {
        return startTimeH;
    }

    public void setStartTimeH(int startTimeH) {
        this.startTimeH = startTimeH;
    }

    public int getStartTimeM() {
        return startTimeM;
    }

    public void setStartTimeM(int startTimeM) {
        this.startTimeM = startTimeM;
    }

    public int getEndTimeH() {
        return endTimeH;
    }

    public void setEndTimeH(int endTimeH) {
        this.endTimeH = endTimeH;
    }

    public int getEndTimeM() {
        return endTimeM;
    }

    public void setEndTimeM(int endTimeM) {
        this.endTimeM = endTimeM;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
