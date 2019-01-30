package org.osama.hadara.subject.dataAccess;

import org.osama.hadara.subject.model.RegisterSubject;

import java.util.List;

public interface RegisterSubjectDAL {
  String save(RegisterSubject registerSubject);
    List<RegisterSubject> getAll();
    void deleteAll();
}
