package org.osama.hadara.subject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class RegisterSubject {
    @Id
    String id;
    Subject subject;
    List<Meeting> meetings;
    List<Attendance> attendanceList;
    SubjectDetails subjectDetails;
    int phase;
    int level;
    String notice;

    public RegisterSubject( Subject subject,
                           List<Attendance> attendanceList, SubjectDetails subjectDetails,
                            String notice) {

        this.subject = subject;
        this.attendanceList = attendanceList;
        this.subjectDetails = subjectDetails;
        this.notice = notice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public RegisterSubject() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public SubjectDetails getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(SubjectDetails subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
