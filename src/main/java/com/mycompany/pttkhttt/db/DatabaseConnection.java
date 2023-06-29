/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection conn;

    public void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\LAPTOP-TGVBBNN7:1433;databaseName=QuanLyKhachSan;encrypt=true;trustServerCertificate=true;","dhlogin","seaways456");
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}

