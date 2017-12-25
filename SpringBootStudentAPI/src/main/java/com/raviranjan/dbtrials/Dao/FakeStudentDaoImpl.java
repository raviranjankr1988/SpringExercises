package com.raviranjan.dbtrials.Dao;

import com.raviranjan.dbtrials.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravkumar on 5/3/2017.
 */
@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private  static Map<String,Student> students;

    static {
        students = new HashMap<String,Student>(){
            {
                put("1",new Student("1","a","A"));
                put("2",new Student("2","b","B"));
                put("3",new Student("3","c","C"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents()
    {

        return this.students.values();
    }

    @Override
    public Student getStudentById(String id)
    {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(String id)
    {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setName(student.getName());
        s.setCourse(student.getCourse());
        students.put(student.getId(),s);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(),student);
    }
}
