package com.springexercises.springjdbc.dao;

import com.springexercises.springjdbc.model.Circle;

import java.sql.*;

public class JdbcDaoImpl {

    public Circle getCircle(int id) {

        Connection conn=null;

        Circle circle = null;
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCSPR","root","Rovi1234");
            PreparedStatement ps = conn.prepareCall("Select * from circle where id = ?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                circle = new Circle(id,rs.getString("name"));
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
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
