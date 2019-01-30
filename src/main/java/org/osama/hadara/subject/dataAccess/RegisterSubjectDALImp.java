package org.osama.hadara.subject.dataAccess;

import org.osama.hadara.subject.model.RegisterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegisterSubjectDALImp implements RegisterSubjectDAL {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public String save(RegisterSubject registerSubject) {
        String message;
        try{
            mongoTemplate.save(registerSubject);
            message="Successfully . new Subject is added .";
            return message;
        }
        catch (Exception e){
            message="error: "+e.getMessage();
            return message;
        }
    }

    @Override
    public List<RegisterSubject> getAll() {
        List<RegisterSubject> all = mongoTemplate.findAll(RegisterSubject.class);
        return all;
    }

    @Override
    public void deleteAll() {
        mongoTemplate.dropCollection(RegisterSubject.class);

    }
}
