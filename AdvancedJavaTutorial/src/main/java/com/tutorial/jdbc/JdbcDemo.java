package com.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        //creating connection
        String url = "jdbc:postgresql://localhost:5432/Student";
        Connection conn = null;

        int rollon = 2;
        String name = "Mary";
        int age = 30;
        String comment = "doi comentari";

//        String sql = "insert into person (rollno, name, age, comment) values("
//                + rollon + ",'" + name + "'," + age + ",'" + comment + "')";
        String sql = "update person Set comment =" + "'doi comentariu'" + "where rollno = 1";
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            Statement st = conn.createStatement();
            int m = st.executeUpdate(sql);
            if (m > 0) {
                System.out.println("insert successfully. Updated " + m + " lines : " + sql);
            } else {
                System.out.println("insert failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }
}