/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.mycompany.pttkhttt.bus.BUS_DANGKYDICHVU;


/**
 *
 * @author ASUS I7
 */
public class DAO_DANGKYDICHVUDB {
    public boolean LayPhieuDatPhong(String id_kh, String id_phong) {
        DatabaseConnection db = new DatabaseConnection();
        
        try {
            db.connect();
            String query = "SELECT * FROM PhieuDatPhong WHERE id_kh = ? AND id_phong = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_kh);
            pstmt.setString(2, id_phong);
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
    
    public String LayTenLoaiPhong(String id_phong){
        DatabaseConnection db = new DatabaseConnection();
        
        try {
            db.connect();
            String query = "SELECT * FROM PHONG p join LOAIPHONG lp on p.loaiphong = lp.id_loaiphong WHERE p.id_phong = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_phong);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getNString("tenloaiphong");
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
            return null;
        }
        finally{
            db.disconnect();
        }
    }
    
    public void ThemThongTinDangKy(String id_pycdv, BUS_DANGKYDICHVU thongTinDangKy){
        
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.connect();
            String query = "INSERT INTO PHIEUYEUCAUDICHVU (id_pycdv, id_kh, id_dv, thoigian, giatien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_pycdv);
            pstmt.setString(2, thongTinDangKy.getId_kh());
            pstmt.setString(3, thongTinDangKy.getId_dv());
             
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = thongTinDangKy.getLichsudung().format(formatter);
            pstmt.setString(4, formattedDate);
        
            pstmt.setString(5, thongTinDangKy.getGia().toString());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
        }
        finally{
            db.disconnect();
        }
    }
    
     public void ThemHoaDon(String id_hoadon, String id_kh, String id_pycdv, LocalDateTime ngaylap,  BigDecimal tongtien){
        
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.connect();
            String query = "INSERT INTO HOADON (id_hoadon, id_kh, id_pycdv, ngaylap, Tongtien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_hoadon);
            pstmt.setString(2, id_kh);
            pstmt.setString(3, id_pycdv);
             
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = ngaylap.format(formatter);
            pstmt.setString(4, formattedDate);
        
            pstmt.setString(5, tongtien.toString());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
        }
        finally{
            db.disconnect();
        }
    }
}
