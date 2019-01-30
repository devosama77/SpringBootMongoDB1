package org.osama.hadara.register.service;

import org.osama.hadara.register.dataAccess.RegistrationDAL;
import org.osama.hadara.register.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImp implements RegistrationService {
    @Autowired
    RegistrationDAL registrationDAL;
    @Override
    public Registration saveRegistration(Registration registration)
    {
        registrationDAL.save(registration);
        return registration;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> all = registrationDAL.getAll();
        return all;
    }

    @Override
    public void deleteAll() {
            registrationDAL.deleteAll();
    }
}
