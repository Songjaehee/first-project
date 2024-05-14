package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection(){
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            // 클래스가 존재하는지 확인하기 위함
            Class.forName(driver);
            con = DriverManager.getConnection(url, prop);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con){
        try {
            if(con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement pstmt){
        try {
            if(pstmt != null && !pstmt.isClosed()){
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            if(rset !=null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




