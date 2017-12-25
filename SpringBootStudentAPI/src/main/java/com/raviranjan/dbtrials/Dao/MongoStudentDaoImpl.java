package com.raviranjan.dbtrials.Dao;

import com.raviranjan.dbtrials.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.Collection;

/**
 * Created by ravkumar on 5/8/2017.
 */
@Qualifier("mongoData")
@Repository("mongoData")
public class MongoStudentDaoImpl implements StudentDao {
	
	@Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Collection<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student getStudentById(String id) {
        return mongoTemplate.findById(id, Student.class);
    }

    @Override
    public void removeStudentById(String id) {
    	mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Student.class);
    }

    @Override
    public void updateStudent(Student student) {
    	Student s = this.getStudentById(student.getId());
    	s.setName(student.getName());
    	s.setCourse(student.getCourse());
    	mongoTemplate.save(s);
    }

    @Override
    public void insertStudent(Student student) {
    	mongoTemplate.save(student);
    }
}
