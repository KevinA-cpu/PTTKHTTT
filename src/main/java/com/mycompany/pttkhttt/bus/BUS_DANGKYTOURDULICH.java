/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS I7
 */
public class BUS_DANGKYTOURDULICH {
    
    private final List<BUS_KHACHHANG> dsKhachHang = new ArrayList<>();
    private final List<BUS_TOURDULICH> dsTourDuLich = new ArrayList<>();
    private final String HinhThuc;
    private final String IdTourDuLich;
    private final String SoNguoiThamGia;
    private final LocalDateTime ThoiDiemKhoiHanh;

    public BUS_DANGKYTOURDULICH(String HinhThuc, String IdTourDuLich, String SoNguoiThamGia, LocalDateTime ThoiDiemKhoiHanh) {
        this.HinhThuc = HinhThuc;
        this.IdTourDuLich = IdTourDuLich;
        this.SoNguoiThamGia = SoNguoiThamGia;
        this.ThoiDiemKhoiHanh = ThoiDiemKhoiHanh;
    }
    


    
}
