package org.osama.hadara.register.dataAccess;


import org.osama.hadara.register.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDALImpl implements RegistrationDAL {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Registration save(Registration registration) {
        mongoTemplate.save(registration);
        return registration;
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> all = mongoTemplate.findAll(Registration.class);
        return all;
    }

    @Override
    public void deleteAll() {
            mongoTemplate.dropCollection(Registration.class);
    }
}
