package com.raviranjan.dbtrials.Dao;

import com.raviranjan.dbtrials.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by ravkumar on 5/9/2017.
 */
@Repository("mySql")
public class MySqlStudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements  RowMapper<Student>
    {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        final String Sql = "Select id, name, course from students";
        List<Student> students = jdbcTemplate.query(Sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(String id) {
        final String Sql = "Select id, name, course from students where id = ?";
        Student s = jdbcTemplate.queryForObject(Sql, new StudentRowMapper(), id);
        return s;
    }

    @Override
    public void removeStudentById(String id) {
        final  String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
        final  String id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql,name,course,id);
    }

    @Override
    public void insertStudent(Student student) {
        final String sql = "INSERT INTO students (name,course) values (?, ?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql,name,course);
    }
}
