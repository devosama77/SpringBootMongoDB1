package org.osama.hadara.register.dataAccess;

import org.osama.hadara.register.model.Registration;

import java.util.List;

public interface RegistrationDAL {
   Registration save(Registration registration);
   List<Registration> getAll();
   void deleteAll();
}
