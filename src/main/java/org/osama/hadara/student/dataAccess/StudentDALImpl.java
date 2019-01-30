package org.osama.hadara.student.dataAccess;


import org.bson.types.ObjectId;
import org.osama.hadara.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDALImpl implements StudentDAL {
    @Autowired
    private  MongoTemplate mongoTemplate;



    @Autowired
    public StudentDALImpl(MongoTemplate mongoTemplate) {

    }

    @Override
    public Student save(Student student) {
        mongoTemplate.save(student);
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = mongoTemplate.findAll(Student.class);
        return students;
    }

    @Override
    public void deleteAll() {
       mongoTemplate.dropCollection(Student.class);
    }

    @Override
    public List<Student> getStudent(String id) {
        Query query = new Query();
        ObjectId objID = new ObjectId(id);
        query.addCriteria(Criteria.where("idStudent").is(objID));
        List<Student> students = mongoTemplate.find(query, Student.class);
        return students;
    }

//    BasicQuery query1 = new BasicQuery("{ age : { $lt : 40 }, name : 'cat' }");
//    User userTest1 = mongoOperation.findOne(query1, User.class);
}
