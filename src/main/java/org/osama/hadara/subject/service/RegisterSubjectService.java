package org.osama.hadara.subject.service;

import org.osama.hadara.subject.model.RegisterSubject;

import java.util.List;

public interface RegisterSubjectService {
    String saveCourse(RegisterSubject registerSubject);
    List<RegisterSubject> getAllRegisterSubject();
    void deleteAll();
}
