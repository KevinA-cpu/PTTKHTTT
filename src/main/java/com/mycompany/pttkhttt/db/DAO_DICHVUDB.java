/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;

import com.mycompany.pttkhttt.bus.BUS_DICHVU;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.PreparedStatement;


/**
 *
 * @author ASUS I7
 */


public class DAO_DICHVUDB {
    public List<BUS_DICHVU> LayDichVu() {
        DatabaseConnection db = new DatabaseConnection();
        List<BUS_DICHVU> dichVuList = new ArrayList<>();
        try {
            db.connect();
            Statement stmt = db.getConnection().createStatement();
            String query = "SELECT * FROM DichVu";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Retrieve data from the result set and create a BUS_DICHVU object
                // For example:
                String id_dv = rs.getString("id_dv");
                String tendichvu = rs.getString("tendichvu");
                String mota = rs.getString("mota");
                BigDecimal gia = rs.getBigDecimal("gia");
                BUS_DICHVU dichVu = new BUS_DICHVU(id_dv, tendichvu, mota, gia);
                dichVuList.add(dichVu);
            }
            return dichVuList;
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
            return null;
        }
        finally{
            db.disconnect();
        }
    }
    
    public String LayApDungDichVu(String id_dv){
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.connect();
            String query = "SELECT * FROM DichVu where id_dv = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_dv);
            ResultSet rs  = pstmt.executeQuery();
            rs.next();
            return rs.getNString("apdung");
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
            return null;
        }
        finally{
            db.disconnect();
        }
    }
    public BigDecimal LayGiaDichVu(String id_dv){
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.connect();
            String query = "SELECT * FROM DichVu where id_dv = ?";
            PreparedStatement pstmt = db.getConnection().prepareStatement(query);
            pstmt.setString(1, id_dv);
            ResultSet rs  = pstmt.executeQuery();
            rs.next();
            return rs.getBigDecimal("gia");
        } catch (SQLException e) {
            System.out.println(e);
            db.disconnect();
            return null;
        }
        finally{
            db.disconnect();
        }
    }
}
