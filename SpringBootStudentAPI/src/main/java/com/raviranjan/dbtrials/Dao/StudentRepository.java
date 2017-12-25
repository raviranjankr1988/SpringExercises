package com.raviranjan.dbtrials.Dao;

import com.raviranjan.dbtrials.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ravkumar on 28/05/17.
 */
public interface StudentRepository extends MongoRepository<Student,String>{
    void delete(Student deleted);

    List<Student> findAll();


    Student save(Student saved);
}
