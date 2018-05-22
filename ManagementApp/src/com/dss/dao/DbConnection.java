package com.dss.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    static Connection con = null;

    public static Connection doConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_details", "root", "root");
            System.out.println("connection ready...");
        } catch (Exception e) {
        }
        return con;
    }
    public static void main(String[] args) {
        doConnect();
    }
}
