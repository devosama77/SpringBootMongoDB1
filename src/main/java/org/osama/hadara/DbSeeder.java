package org.osama.hadara;

import org.osama.hadara.financial.Financial;
import org.osama.hadara.financial.Payment;
import org.osama.hadara.subject.model.*;
import org.osama.hadara.subject.service.RegisterSubjectService;
import org.osama.hadara.register.model.Registration;
import org.osama.hadara.register.service.RegistrationService;
import org.osama.hadara.seq.SequenceDAL;
import org.osama.hadara.seq.model.SequenceId;
import org.osama.hadara.student.model.*;
import org.osama.hadara.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Component
public class DbSeeder implements CommandLineRunner {
    private static final String FINANCIAL_SEQ_KEY = "financial";
    private static final String STUDENT_REGISTER = "register";
    private static final String STUDENT_REGISTER_SUBJECT = "registersubject";
    private static final String STUDENT_REGISTER_FINANCIAL = "registerfinancial";
    @Autowired
    StudentService studentService;
    @Autowired
    private SequenceDAL sequenceDAL;
    @Autowired
    RegistrationService registrationService;

    @Autowired
    RegisterSubjectService registerSubjectService;



    public List<Attendance> generateAttendances(SubjectDetails subjectDetails, List<Meeting> meetings){

        LocalDate registerDate=subjectDetails.getRegisterDate();

        List<Attendance> attendances=new ArrayList<>();
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
//                if(s.equals(day)){
//                    LocalDateTime localDateTime2 = startDate.atTime(startTimeH,startTimeM);
//                    Attendance attendance=new Attendance(localDateTime2,endTime,0,"");
//                    list.add(attendance);
                System.out.println(s);
//                }
                startDate = startDate.plus(period);

            }
            list.sort(Comparator.comparing(Attendance::getAttendancesDate));



        }


        return  attendances;
    }

@Override
    public void run(String... args) throws Exception {

  SubjectDetails subjectDetails6=new SubjectDetails();
  Meeting meeting6=new Meeting();
  meeting6.setDay("Sun");
  meeting6.setStartTimeH(4);
  meeting6.setStartTimeM(30);
  meeting6.setEndTimeH(8);
  meeting6.setEndTimeM(20);
  subjectDetails6.setBeginDate(LocalDate.of(2018,11,1));
  subjectDetails6.setEndDate(LocalDate.of(2018,11,10));
//  second meeting

    Meeting meeting7=new Meeting();
    meeting7.setDay("Wed");
    meeting7.setStartTimeH(6);
    meeting7.setStartTimeM(10);
    meeting7.setEndTimeH(9);
    meeting7.setEndTimeM(40);

//   generateAttendances(subjectDetails6,Arrays.asList(meeting6,meeting7));

// .....................subjects

        Subject subject1=new Subject();
        subject1.setCourseName("رياضيات");
        subject1.setTeacherName("أسامة محمود المدهون");



      Subject subject2=new Subject();
      subject2.setCourseName("رياضيات");
      subject2.setTeacherName("أسامة محمود المدهون");


            Subject subject3=new Subject();
            subject3.setTeacherName("أسامة محمود المدهون");
            subject3.setCourseName("علوم");



            Subject subject4=new Subject();
            subject4.setCourseName("انجليزي");
            subject4.setTeacherName("أسامة محمود المدهون");


        Subject course1=new Subject();
        course1.setCourseName("علوم");

        course1.setTeacherName("أسامة محمود المدهون");



        Subject course2=new Subject();
        course2.setCourseName("لغة انجليزيه");

        course2.setTeacherName("أسامة محمود المدهون");


        Subject course3=new Subject();
        course3.setTeacherName("أسامة محمود المدهون");
        course3.setCourseName("تكنولجيا معلومات");


        // Sequence ........
        sequenceDAL.deleteSequence();
        SequenceId sequenceId=new SequenceId();
        sequenceId.setId(FINANCIAL_SEQ_KEY);
        sequenceId.setSeq(0);
        sequenceDAL.save(sequenceId);


        // financial .....................................
        Financial financial=new Financial();
        financial.setFees(1500);
        Payment payment=new Payment();
        payment.setDatePayments(LocalDate.now().minusMonths(6));
        payment.setTimePayments(LocalTime.now().minusHours(2));
        payment.setPayments(200);
        payment.setNotice("دفع بنفسه المبلغ الملطوب");

        Payment payment1=new Payment();
        payment1.setDatePayments(LocalDate.now().minusYears(1));
        payment1.setPayments(100);
        payment1.setTimePayments(LocalTime.now().minusHours(2));
        payment1.setNotice("دفع بنفسه المبلغ الملطوب");

    Payment payment9=new Payment();
    payment9.setDatePayments(LocalDate.now().minusYears(1));
    payment9.setPayments(140);
    payment9.setTimePayments(LocalTime.now());
    payment9.setTimePayments(LocalTime.now().minusHours(2));
    payment9.setNotice("دفع بنفسه المبلغ الملطوب");

        financial.setPayments(Arrays.asList(payment,payment1,payment9));
        financial.setId(sequenceDAL.getNextSequenceId(FINANCIAL_SEQ_KEY));
        financial.setNotice("دفع كافة المتسحقات");

        Financial financial1=new Financial();
        financial1.setFees(2500);

        Payment payment2=new Payment();
        payment2.setDatePayments(LocalDate.now().minusMonths(8));
        payment2.setPayments(300);
        payment2.setTimePayments(LocalTime.now().minusHours(2));
        payment2.setNotice("دفع بنفسه المبلغ الملطوب");

        Payment payment3=new Payment();
        payment3.setDatePayments(LocalDate.now().minusMonths(10));
        payment3.setPayments(100);
        payment3.setTimePayments(LocalTime.now().minusHours(2));
        payment3.setNotice("دفع بنفسه المبلغ الملطوب");

        Payment payment4=new Payment();
        payment4.setPayments(300);
        payment4.setDatePayments(LocalDate.now().minusMonths(11));
        payment4.setTimePayments(LocalTime.now().minusHours(2));
        payment4.setNotice("دفع بنفسه المبلغ الملطوب");

        Payment payment5=new Payment();
        payment5.setPayments(600);
        payment5.setDatePayments(LocalDate.now().minusMonths(14));
        payment5.setTimePayments(LocalTime.now().minusHours(2));
        payment5.setNotice("دفع بنفسه المبلغ الملطوب");

        financial1.setPayments(Arrays.asList(payment2,payment3,payment4,payment5));
        financial1.setNotice("دفع كافة المتسحقات");
        financial1.setId(sequenceDAL.getNextSequenceId(FINANCIAL_SEQ_KEY));

        Financial financial2=new Financial();
        financial2.setFees(400);
        financial2.setNotice("دفع كافة المتسحقات");
        financial2.setPayments(Arrays.asList(payment3,payment5,payment));
        financial2.setId(sequenceDAL.getNextSequenceId(FINANCIAL_SEQ_KEY));
        Financial financial3=new Financial();
        financial3.setNotice("دفع كافة المتسحقات");
        financial3.setFees(2000);
        financial3.setPayments(Arrays.asList(payment4,payment5));
        financial3.setId(sequenceDAL.getNextSequenceId(FINANCIAL_SEQ_KEY));


// .............................Registration SubjectDetails
        // attendances
        List<Attendance> listAttendances=new ArrayList<>();
//        listAttendances=genAttendances();


        SubjectDetails subjectDetails
                =new SubjectDetails(LocalDate.now(),
                LocalDate.now().plusMonths(1),LocalDate.now().plusMonths(6),
                "يوجد اجازه السبت والاحد");

        SubjectDetails subjectDetails1
                =new SubjectDetails(LocalDate.now(),
                LocalDate.now().plusMonths(2),LocalDate.now().plusMonths(6),
                " لا يوجد اجازه ابدا");

//...................... registration Course
//        Meetings time

    Meeting meeting=new Meeting(16,30,18,20,"Sat");
    Meeting meeting1=new Meeting(16,30,18,20,"Mon");
    Meeting meeting2=new Meeting(16,30,18,20,"Tue");

//        LocalTime localTime=LocalTime.parse(startTime1, DateTimeFormatter.ofPattern("HH:mm"));


        RegisterSubject registerSubject=
             new RegisterSubject(course1,listAttendances, subjectDetails,"المطلوب 5 لكي نبدأ ");
        registerSubject.setPhase(1);
        registerSubject.setLevel(1);
        registerSubject.setMeetings(Arrays.asList(meeting,meeting1,meeting2));

        RegisterSubject registerSubject2=
                new RegisterSubject(course2,listAttendances, subjectDetails1,"تبدأ المجموعه قبل الموعد ");
        registerSubject2.setLevel(1);
        registerSubject2.setPhase(1);
        registerSubject2.setMeetings(Arrays.asList(meeting,meeting1,meeting2));

//    RegisterSubject registerSubject3=
//            new RegisterSubject(subject1,listAttendances, subjectDetails1,"تبدأ المجموعه قبل الموعد ");
//    registerSubject3.setLevel(1);
//    registerSubject3.setPhase(2);
//    registerSubject3.setMeetings(Arrays.asList(meeting));
//
//    RegisterSubject registerSubject4=
//            new RegisterSubject(subject2,listAttendances, subjectDetails1,"تبدأ المجموعه قبل الموعد ");
//    registerSubject4.setLevel(1);
//    registerSubject4.setPhase(3);
//    registerSubject4.setMeetings(Arrays.asList(meeting1));

//    RegisterSubject registerSubject5=
//            new RegisterSubject(subject3,listAttendances, subjectDetails1,"تبدأ المجموعه قبل الموعد ");
//    registerSubject5.setLevel(2);
//    registerSubject5.setPhase(3);
//    registerSubject5.setMeetings(Arrays.asList(meeting2));

    registerSubjectService.deleteAll();
    registerSubjectService.saveCourse(registerSubject);
    registerSubjectService.saveCourse(registerSubject2);
//    registerSubjectService.saveCourse(registerSubject3);
//    registerSubjectService.saveCourse(registerSubject4);
//    registerSubjectService.saveCourse(registerSubject5);
// ............................ registration
       Registration registration =new Registration();
        registration.setFinancial(financial);
        registration.setRegisterSubjects(Arrays.asList(registerSubject,registerSubject2));
        registration.setPhase(1);
        registration.setLevel(1);

        Registration registration1 =new Registration();
        registration1.setFinancial(financial2);
        registration1.setRegisterSubjects(Arrays.asList(registerSubject));
        registration1.setPhase(2);
        registration1.setLevel(1);

        Registration registration2 =new Registration();
        registration2.setFinancial(financial3);
        registration2.setRegisterSubjects(Arrays.asList(registerSubject2));
        registration2.setPhase(3);
        registration2.setLevel(2);

    Registration registration3 =new Registration();
    registration3.setFinancial(financial3);
    registration3.setRegisterSubjects(Arrays.asList(registerSubject2));
    registration3.setPhase(1);
    registration3.setLevel(1);
        this.registrationService.deleteAll();
        this.registrationService.saveRegistration(registration);
        this.registrationService.saveRegistration(registration1);
        this.registrationService.saveRegistration(registration2);
        this.registrationService.saveRegistration(registration3);


// Students ...............................................


//
    SequenceId sequenceIdRegister=new SequenceId();
    sequenceIdRegister.setId(STUDENT_REGISTER);
    sequenceIdRegister.setSeq(0);
    sequenceDAL.save(sequenceIdRegister);

    SequenceId sequenceIdRegisterSubject=new SequenceId();
    sequenceIdRegisterSubject.setId(STUDENT_REGISTER_SUBJECT);
    sequenceIdRegisterSubject.setSeq(0);
    sequenceDAL.save(sequenceIdRegisterSubject);


    SequenceId sequenceIdRegisterFinacial=new SequenceId();
    sequenceIdRegisterFinacial.setId(STUDENT_REGISTER_FINANCIAL);
    sequenceIdRegisterFinacial.setSeq(0);
    sequenceDAL.save(sequenceIdRegisterFinacial);

//    Register subject for studen
    RegisterSubjectForStudent registerSubjectForStudent=
            new RegisterSubjectForStudent(course1,null, subjectDetails,"المادة رقم 1  لكي نبدأ ");
    registerSubjectForStudent.setMeetings(Arrays.asList(meeting,meeting1,meeting2));
   registerSubjectForStudent.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER_SUBJECT));

    RegisterSubjectForStudent registerSubjectForStudent1=
            new RegisterSubjectForStudent(course1,null, subjectDetails,"المادة رقم 2  ");
    registerSubjectForStudent1.setMeetings(Arrays.asList(meeting,meeting1,meeting2));
    registerSubjectForStudent1.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER_SUBJECT));
//    Register financial For student
    // financial .....................................
    RegisterFinancial registerFinancial=new RegisterFinancial();
    registerFinancial.setFees(1500);
    Payment payment6=new Payment();
    payment6.setDatePayments(LocalDate.now().minusMonths(6));
    payment6.setTimePayments(LocalTime.now().minusHours(2));
    payment6.setPayments(200);
    payment6.setNotice("دفع بنفسه المبلغ الملطوب");

    Payment payment7=new Payment();
    payment7.setDatePayments(LocalDate.now().minusYears(1));
    payment7.setPayments(100);
    payment7.setTimePayments(LocalTime.now().minusHours(2));
    payment7.setNotice("دفع بنفسه المبلغ الملطوب");

    registerFinancial.setPayments(Arrays.asList(payment6,payment7,payment9,payment5));
    registerFinancial.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER_FINANCIAL));
    registerFinancial.setNotice("دفع كافة المتسحقات");

//    new register student
    RegisterForStudent registerForStudent=new RegisterForStudent();
    registerForStudent.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER));
    registerForStudent.setRegisterFinancial(registerFinancial);
    registerForStudent.setRegisterSubjectForStudents(Arrays.asList(registerSubjectForStudent,
            registerSubjectForStudent1));
    RegisterForStudent registerForStudent1=new RegisterForStudent();
    registerForStudent1.setId(sequenceDAL.getNextSequenceId(STUDENT_REGISTER));
    registerForStudent1.setRegisterFinancial(registerFinancial);
    registerForStudent1.setRegisterSubjectForStudents(Arrays.asList(registerSubjectForStudent,
            registerSubjectForStudent1));

    studentService.deleteAllStudents();



        // ................. SubjectDetails
//        for(int x=0;x<=10;x++){
            Student student=new Student();
        //    student.setFinancial(Arrays.asList(financial,financial1));
            Details details=new Details();
            details.setFirstName("ياسر");
            details.setMiddleName("احمد");
            details.setLastName("المدهون");
            details.setBirthday(LocalDate.now());
            details.setFatherJob("وزير");
            details.setContact(new Contact("شمال غزة","انور عزيز","05991981","05998434334"));
            details.setLevel(1);
            details.setPhase(1);
            student.setDetails(details);
            student.setRegisterStudents(Arrays.asList(registerForStudent,registerForStudent1));
//            student.setRegistration(Arrays.asList(registration,registration1));
            studentService.saveStudent(student);

//        for(int x=0;x<=10;x++){
//            Student student1=new Student();
//            Details details1=new Details();
//            details1.setFirstName("رائد");
//            details1.setMiddleName("ناصر");
//            details1.setLastName("الشوبكي");
//            details1.setContact(new Contact("شمال غزة","شارع الهوجه","2222222222","1111111111"));
//            details1.setFatherJob("مدير");
//            details1.setBirthday(LocalDate.now());
//            details1.setLevel(2);
//            details1.setPhase(1);
//            student1.setDetails(details1);
////            student1.setRegistration(Arrays.asList(registration,registration2));
//            studentService.saveStudent(student1);
//
//        }

//        for(int x=0;x<=10;x++){
//            Student student1=new Student();
//            Details details1=new Details();
//            details1.setFirstName("نادر");
//            details1.setMiddleName("سعدي");
//            details1.setLastName("النجار");
//            details1.setContact(new Contact("شمال غزة","شارع الهوجه","2222222222","1111111111"));
//            details1.setFatherJob("مدير");
//            details1.setBirthday(LocalDate.now());
//            details1.setLevel(1);
//            details1.setPhase(2);
//            student1.setDetails(details1);
////            student1.setRegisterStudents(Arrays.asList(registration,registration2));
//            studentService.saveStudent(student1);
//
//        }

        for(int x=0;x<=10;x++){
            Student student1=new Student();
            Details details1=new Details();
            details1.setFirstName("جميل");
            details1.setMiddleName("رائد");
            details1.setLastName("ياسين");
            details1.setContact(new Contact("شمال غزة","شارع الهوجه","2222222222","1111111111"));
            details1.setFatherJob("مدير");
            details1.setBirthday(LocalDate.now());
            details1.setLevel(1);
            details1.setPhase(3);
            student1.setDetails(details1);
//            student1.setRegistration(Arrays.asList(registration,registration2));
            studentService.saveStudent(student1);

        }

    }
//    public List<Attendance> genAttendances() {
//        List<Attendance> list=new ArrayList<>();
//        int x=0;
//        int y=0;
//        for(int i=0;i<=5;i++){
//            y+=4;
//            Attendance attendance=new Attendance(LocalDate.now().minusDays(4+y),
//                    LocalTime.now().minusHours(3),true,"لم يغب");
//            list.add(attendance);
//        }
//        for(int i=0;i<=8;i++){
//            x+=4;
//            Attendance attendance=new Attendance(LocalDate.now().minusDays(4+x),
//                    LocalTime.now().minusHours(3),false,"غاب بعذر");
//            list.add(attendance);
//        }
//        return list;
//    }




}
