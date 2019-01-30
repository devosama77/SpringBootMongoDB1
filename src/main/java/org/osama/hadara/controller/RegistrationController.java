package org.osama.hadara.controller;

import org.osama.hadara.register.model.Registration;
import org.osama.hadara.register.service.RegistrationService;
import org.osama.hadara.subject.model.RegisterSubject;
import org.osama.hadara.subject.service.RegisterSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regs")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    RegisterSubjectService registerSubjectService;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4201")
    public List<Registration> getRegistration(){
        List<Registration> allRegistrations =
                this.registrationService.getAllRegistrations();
        return allRegistrations;
    }
    @GetMapping("/subjects")
    @CrossOrigin(origins = "http://localhost:4201")
    public List<RegisterSubject> getRegisterSubject(){
        List<RegisterSubject> allRegistrations = registerSubjectService.getAllRegisterSubject();
        return allRegistrations;
    }

    @PostMapping("subject/save")
    @CrossOrigin(origins = "http://localhost:4201")
    public String saveRegSubject(@RequestBody RegisterSubject registerSubject){
        String registerSubject1 = registerSubjectService.saveCourse(registerSubject);
           return registerSubject1;
    }
}


