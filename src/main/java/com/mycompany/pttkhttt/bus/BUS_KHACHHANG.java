/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;

import java.time.LocalDateTime;
import com.mycompany.pttkhttt.db.DAO_KHACHHANGDB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS I7
 */
public class BUS_KHACHHANG {
    private final String diachi;
    private final String email;
    private final String id_kh;
    private final LocalDateTime NgayDen;
    private final String sdt;
    private final int sodemluutru;
    private final int soluonghanhly;
    private final String tenkhachhang;


    public BUS_KHACHHANG() {
        this.diachi = null;
        this.email = null;
        this.id_kh = null;
        this.NgayDen = null;
        this.sdt = null;
        this.sodemluutru = 0;
        this.soluonghanhly = 0;
        this.tenkhachhang = null;
    }
    
     public BUS_KHACHHANG(String diachi, String email, String id_kh, LocalDateTime NgayDen, String sdt, int sodemluutru, int soluonghanhly, String tenkhachhang) {
        this.diachi = diachi;
        this.email = email;
        this.id_kh = id_kh;
        this.NgayDen = NgayDen;
        this.sdt = sdt;
        this.sodemluutru = sodemluutru;
        this.soluonghanhly = soluonghanhly;
        this.tenkhachhang = tenkhachhang;
    }
    
    public boolean KiemTraIdKH(String[] idKH){
        DAO_KHACHHANGDB khdb = new DAO_KHACHHANGDB();
        for (String idKH1 : idKH) {
            if(!khdb.KiemTraIdKH(idKH1)){
                return false;
            }
        }
        return true;
    }
    
    public List<BUS_KHACHHANG> LayKhachHang(String[] idKHArray){
        DAO_KHACHHANGDB khdb = new DAO_KHACHHANGDB();
        List<BUS_KHACHHANG> khachHangList = new ArrayList<>();
        for (String idKH : idKHArray) {
            BUS_KHACHHANG khachHang = khdb.LayKhachHang(idKH);
            khachHangList.add(khachHang);
        }
        return khachHangList;
    }
    
}
