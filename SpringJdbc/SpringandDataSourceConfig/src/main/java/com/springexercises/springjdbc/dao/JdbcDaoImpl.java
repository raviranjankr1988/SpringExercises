package com.springexercises.springjdbc.dao;

import com.springexercises.springjdbc.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
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
}
