package org.osama.hadara.register.service;

import org.osama.hadara.register.model.Registration;

import java.util.List;

public interface RegistrationService {
    Registration saveRegistration(Registration registration);
    List<Registration> getAllRegistrations();
    void deleteAll();
}
