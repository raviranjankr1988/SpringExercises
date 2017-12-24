package com.springexercises.springjdbc.dao;

import com.springexercises.springjdbc.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public Circle getCircle(int id) {

        Connection conn=null;

        Circle circle = null;
        try {
            conn =dataSource.getConnection();



            PreparedStatement ps = conn.prepareCall("Select * from circle where id = ?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                circle = new Circle(id,rs.getString("name"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return circle;


    }

    public int getCircleCount() {
        String sql = "select count(*) from circle";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public String getCircleName(int id) {
        String sql = "select name from circle where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[] {id},String.class);
    }

    public Circle getCircleForId(int id){
        String sql = "select * from circle where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[] {id}, new CircleMapper());

    }

    public List<Circle> getAllCircles(){
        String sql = "select * from circle";
        return jdbcTemplate.query(sql, new CircleMapper());

    }

    public void insertCircle(Circle circle){
        String sql = "insert into circle (id,name) values (?,?)";
        jdbcTemplate.update(sql,circle.getId(),circle.getName());
    }

    public void insertCircleNamedParameter(Circle circle){
        String sql = "insert into circle (id,name) values (:id,:name)";
        SqlParameterSource namedParameterSource = new MapSqlParameterSource("id",circle.getId()).addValue("name",circle.getName());
        namedParameterJdbcTemplate.update(sql,namedParameterSource);
    }

    public void createTriangleTable(){
        String sql = "create table Triangle (id integer, name varchar(50))";
        jdbcTemplate.execute(sql);
    }

    private  static final class CircleMapper implements RowMapper<Circle>{
        @Nullable
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));

            return circle;
        }
    }
}
