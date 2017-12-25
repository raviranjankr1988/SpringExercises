package com.raviranjan.dbtrials.Dao;

import com.raviranjan.dbtrials.Entity.Student;

import java.util.Collection;

/**
 * Created by ravkumar on 5/8/2017.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(String id);

    void removeStudentById(String id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
