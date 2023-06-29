/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;

import com.mycompany.pttkhttt.db.DAO_DANGKYDICHVUDB;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;


/**
 *
 * @author ASUS I7
 */      
public class BUS_DANGKYDICHVU {
    
        private final String id_dv;
        private final String id_kh;
        private final LocalDateTime lichsudung;
        private final BigDecimal gia;
    
    public BUS_DANGKYDICHVU(){
       this.id_dv = null;
       this.id_kh = null;
       this.lichsudung=null;
       this.gia=null;
    }
    
    public BUS_DANGKYDICHVU(String id_dv, String id_kh, LocalDateTime lichsudung, BigDecimal  gia){
       this.id_dv = id_dv;
       this.id_kh = id_kh;
       this.lichsudung=lichsudung;
       this.gia=gia;
    }

    public String getId_dv() {
        return id_dv;
    }

    public String getId_kh() {
        return id_kh;
    }

    public LocalDateTime getLichsudung() {
        return lichsudung;
    }

    public BigDecimal getGia() {
        return gia;
    }
    
    public boolean KiemTraIdKhachHangVaIdPhong(String id_kh, String id_phong){
        DAO_DANGKYDICHVUDB daoDangKyDichVuDB = new DAO_DANGKYDICHVUDB();
        return daoDangKyDichVuDB.LayPhieuDatPhong(id_kh, id_phong);
    }
    //TODO: make changes like in the class diagram, merge all three DAO_DB into one
    public boolean KiemTraIdPhongHoTroDichVu (String id_phong, String apdung){
        DAO_DANGKYDICHVUDB daoDangKyDichVuDB = new DAO_DANGKYDICHVUDB();
        String loaiphong = daoDangKyDichVuDB.LayTenLoaiPhong(id_phong);
        if(apdung.contains("tất cả")){
            return true;
        } 
        else if(apdung.contains("VIP") && loaiphong.contains("VIP")){
            return true;
        }
        return false;
    }
    
    public void ThemThongTinDangKy (BUS_DANGKYDICHVU dkdv){
        DAO_DANGKYDICHVUDB daoDangKyDichVuDB = new DAO_DANGKYDICHVUDB();
        
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char c = characters.charAt(index);
            sb.append(c);
        }
        String id_pycdv = sb.toString();
        
        daoDangKyDichVuDB.ThemThongTinDangKy(id_pycdv, dkdv);
        
        
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        
         for (int i = 0; i < length; i++) {
            int index = random1.nextInt(characters.length());
            char c = characters.charAt(index);
            sb1.append(c);
        }
        String id_hoadon = sb1.toString();
        LocalDateTime ngaylapphieu = LocalDateTime.now();
        daoDangKyDichVuDB.ThemHoaDon(id_hoadon, dkdv.getId_kh(), id_pycdv, ngaylapphieu, dkdv.getGia());
    }
    
}
