package org.osama.hadara.controller;


import org.osama.hadara.seq.SequenceDAL;
import org.osama.hadara.student.model.RegisterForStudent;
import org.osama.hadara.student.model.Student;
import org.osama.hadara.student.dataAccess.StudentDAL;
import org.osama.hadara.student.service.StudentService;
import org.osama.hadara.subject.model.Attendance;
import org.osama.hadara.subject.model.Meeting;
import org.osama.hadara.subject.model.SubjectDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final String STUDENT_REGISTER = "register";
    private static final String STUDENT_REGISTER_SUBJECT = "registersubject";
    private static final String STUDENT_REGISTER_FINANCIAL = "registerfinancial";

    @Autowired
    private SequenceDAL sequenceDAL;

    @Autowired
    StudentService studentService;
    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4201")
    public List<Student> getStudents(){
        List<Student> all = studentService.getAllStudents();
        return all;
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ResponseBodyStudent getStudent(@PathVariable("id") String id ){
        ResponseBodyStudent responseBodyStudent=new ResponseBodyStudent();
        try{
            List<Student> students = studentService.getStudent(id);
            responseBodyStudent.setText("Successfully , retrieve Student ");
            responseBodyStudent.setStudents(students);
            return responseBodyStudent;
        } catch (Exception e){
            responseBodyStudent.setText(e.getMessage().toString());
            return responseBodyStudent;
        }


    }
    @PostMapping("student/save")
    @CrossOrigin(origins = "http://localhost:4201")
    @ResponseBody
    public ResponseBodyStudent saveRegSubject(@RequestBody Student student){
        List<RegisterForStudent> registerStudents = student.getRegisterStudents();
        registerStudents.forEach(reg->{
            reg.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER));
            reg.getRegisterFinancial().setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER_FINANCIAL));
            reg.getRegisterSubjectForStudents().forEach(s->{
                s.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER_SUBJECT ));
            });
        });
        student.getRegisterStudents().forEach(r->{
            r.getRegisterSubjectForStudents().forEach(s->{
                s.getMeetings().forEach(m->{System.out.println("Meeting::: "+m.getDay()+":"+m.getStartTimeH()+":"+m.getStartTimeM());});
//             System.out.println(s.getSubjectDetails().getBeginDate()+":"+s.getSubjectDetails().getEndDate());
//             System.out.println(generateAttendances(s.getSubjectDetails(),s.getMeetings()));
             s.setAttendanceList(generateAttendances(s.getSubjectDetails(),s.getMeetings()));
            s.getAttendanceList().forEach(a->{
                 System.out.println(a.getAttendancesDate()+":"+a.getEndTime());
             });
            });
        });
         ResponseBodyStudent responseBodyStudent=new ResponseBodyStudent();
         responseBodyStudent.setStudent(student);
         responseBodyStudent.setText("Successfully , one Student is added");
         studentService.saveStudent(student);
        return responseBodyStudent;
    }

    public List<Attendance> generateAttendances(SubjectDetails subjectDetails, List<Meeting> meetings){

//        LocalDate registerDate=subjectDetails.getRegisterDate();

        List<Attendance> list=new ArrayList<>();
        for(int i=0;i<meetings.size();i++){
            LocalDate startDate= subjectDetails.getBeginDate();
            LocalDate endDate=subjectDetails.getEndDate();
            String day=meetings.get(i).getDay();
            int startTimeH=meetings.get(i).getStartTimeH();
            int  startTimeM=meetings.get(i).getStartTimeM();
            String endTime=meetings.get(i).getEndTimeH()+":"+meetings.get(i).getEndTimeM();
            Period period=Period.ofDays(1);
            while (!startDate.equals(endDate)) {
                String s=  startDate.getDayOfWeek().getDisplayName( TextStyle.SHORT_STANDALONE, Locale.ENGLISH );
                if(s.equals(day)){
                    LocalDateTime localDateTime2 = startDate.atTime(startTimeH,startTimeM);
                    Attendance attendance=new Attendance(localDateTime2,endTime,0,"");
                    list.add(attendance);
                }
                startDate = startDate.plus(period);

            }
            list.sort(Comparator.comparing(Attendance::getAttendancesDate));



        }


        // String beginDate1= "2018-11-1";
        // String   endDate1= "2018-11-30";
//         String endTime="3:30";

        //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        // LocalDate startDate = LocalDate.parse(beginDate1, formatter);
        // LocalDate endDate = LocalDate.parse(endDate1, formatter);
        // int startTimeH=15;
        //  int startTimeM=30;

        return  list;
    }
}
