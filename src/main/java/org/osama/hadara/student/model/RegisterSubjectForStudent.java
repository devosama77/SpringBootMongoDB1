package org.osama.hadara.student.model;

        import org.osama.hadara.subject.model.Attendance;
        import org.osama.hadara.subject.model.Meeting;
        import org.osama.hadara.subject.model.Subject;
        import org.osama.hadara.subject.model.SubjectDetails;
        import java.util.List;



public class RegisterSubjectForStudent {
    long id;
    Subject subject;
    List<Meeting> meetings;
    List<Attendance> attendanceList;
    SubjectDetails subjectDetails;
    String notice;

    public RegisterSubjectForStudent(Subject subject,
                           List<Attendance> attendanceList, SubjectDetails subjectDetails,
                           String notice) {

        this.subject = subject;
        this.attendanceList = attendanceList;
        this.subjectDetails = subjectDetails;
        this.notice = notice;
    }
    public RegisterSubjectForStudent() {
    }


    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
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
