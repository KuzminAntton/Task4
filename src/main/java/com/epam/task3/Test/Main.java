package com.epam.task3.Test;

import com.mysql.jdbc.Statement;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/news",
                    "root",
                    "aNTON1488"
            );
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM news.news ";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                String creator = rs.getString("creator");
                System.out.println(creator);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sqlExample() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/news",
                    "root",
                    "aNTON1488"
            );
            String sql = "INSERT INTO news(title,creator,category) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"MyBook");
            ps.setString(2,"Anton");
            ps.setString(3,"Book");
            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
