package com.raviranjan.dbtrials.Dao;

import com.mongodb.MongoClient;
import com.raviranjan.dbtrials.Entity.Student;
import org.mongodb.morphia.*;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import  java.util.List;

import java.util.Collection;

/**
 * Created by ravkumar on 28/05/17.
 */
@Qualifier("morphia")
@Repository("morphia")
public class MorphiaStudentDaoImpl implements StudentDao {

    final Morphia morphia = new Morphia();

    //morphia.mapPackage("com.raviranjan.dbtrials.Entity.Student");

        // create the Datastore connecting to the default port on the local host
    final Datastore datastore = morphia.createDatastore(new MongoClient(), "students_morphia");


    @Override
    public Collection<Student> getAllStudents() {
        final Query<Student> query = datastore.createQuery(Student.class);
        final List<Student> studentList = query.asList();
        return studentList;
    }

    @Override
    public Student getStudentById(String id) {
        final Query<Student> query = datastore.createQuery(Student.class).field("id").equal(id);
        return query.asList().get(0);
    }

    @Override
    public void removeStudentById(String id) {
        final Query<Student> query = datastore.createQuery(Student.class).filter("id =",id);
        datastore.delete(query);

    }

    @Override
    public void updateStudent(Student student) {
        this.insertStudent(student);

    }

    @Override
    public void insertStudent(Student student) {
        datastore.save(student);

    }
}
