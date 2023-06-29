/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.pttkhttt.bus.BUS_KHACHHANG;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS I7
 */
public class DAO_KHACHHANGDB {
     public boolean KiemTraIdKH(String id_kh) {
        DatabaseConnection db = new DatabaseConnection();
        
        try {
            db.connect();
            String query = "SELECT * FROM KhachHang WHERE id_kh = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_kh);
            return pstmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
            return false;
        }
        finally{
            db.disconnect();
        }
    }
     
     public BUS_KHACHHANG LayKhachHang(String id_kh){
        BUS_KHACHHANG khachHang = null;
        DatabaseConnection db = new DatabaseConnection();
        LocalDateTime ngayden;
        try {
           db.connect();
            String query = "SELECT * FROM KhachHang WHERE id_kh = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_kh);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Get data from ResultSet and create new BUS_KHACHHANG object
                String tenkhachhang = rs.getString("tenkhachhang");
                String diachi = rs.getString("diachi");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                Timestamp timestamp = rs.getTimestamp("ngayden");
                ngayden = timestamp.toLocalDateTime();
                int sodemluutru = rs.getInt("sodemluutru");
                int soluonghanhly = rs.getInt("soluonghanhly");
                // ... get other fields as needed
                khachHang = new BUS_KHACHHANG(diachi,email,id_kh, ngayden,sdt,sodemluutru,soluonghanhly,tenkhachhang);
            }
           
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
        }
        finally{
            db.disconnect();
        }
        return khachHang;
     }
}
