package com.raviranjan.dbtrials.Service;

import com.raviranjan.dbtrials.Dao.*;
import com.raviranjan.dbtrials.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by ravkumar on 5/4/2017.
 */
@Service
public class StudentService {

    @Autowired
    @Qualifier("fakeData")
    private StudentDao StudentDao;
    public Collection<Student> getAllStudents()
    {

        return this.StudentDao.getAllStudents();
    }

    public Student getStudentById(String id)
    {
        return this.StudentDao.getStudentById(id);
    }

    public void removeStudentById(String id)
    {
        this.StudentDao.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        this.StudentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.StudentDao.insertStudent(student);
    }
}
