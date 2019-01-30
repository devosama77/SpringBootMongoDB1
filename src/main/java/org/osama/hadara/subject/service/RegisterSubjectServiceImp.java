package org.osama.hadara.subject.service;

import org.osama.hadara.subject.dataAccess.RegisterSubjectDAL;
import org.osama.hadara.subject.model.RegisterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterSubjectServiceImp implements RegisterSubjectService {

    @Autowired
    RegisterSubjectDAL registerSubjectDAL;

    @Override
    public String saveCourse(RegisterSubject registerSubject) {
        String save = registerSubjectDAL.save(registerSubject);
        return save;
    }

    @Override
    public List<RegisterSubject> getAllRegisterSubject() {
        List<RegisterSubject> all = registerSubjectDAL.getAll();
        return all;
    }

    @Override
    public void deleteAll() {
        registerSubjectDAL.deleteAll();

    }
}
