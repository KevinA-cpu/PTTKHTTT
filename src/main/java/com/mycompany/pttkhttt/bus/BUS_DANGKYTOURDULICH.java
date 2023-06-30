/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;


import java.time.LocalDateTime;
import java.util.List;
import com.mycompany.pttkhttt.db.DAO_DANGKYTOURDULICHDB;
/**
 *
 * @author ASUS I7
 */
public class BUS_DANGKYTOURDULICH {
    private final List<BUS_KHACHHANG> dsKhachHang;
    private final String HinhThuc;
    private final String IdTourDuLich;
    private final String SoNguoiThamGia;
    private final String NhuCauDacBiet;
    private final LocalDateTime ThoiDiemKhoiHanh;

    public BUS_DANGKYTOURDULICH(List<BUS_KHACHHANG> dsKhachHang, String HinhThuc, String IdTourDuLich, String SoNguoiThamGia, String NhuCauDacBiet, LocalDateTime ThoiDiemKhoiHanh) {
        this.dsKhachHang = dsKhachHang;
        this.HinhThuc = HinhThuc;
        this.IdTourDuLich = IdTourDuLich;
        this.SoNguoiThamGia = SoNguoiThamGia;
        this.NhuCauDacBiet = NhuCauDacBiet;
        this.ThoiDiemKhoiHanh = ThoiDiemKhoiHanh;
    }
    
     public BUS_DANGKYTOURDULICH() {
        this.dsKhachHang = null;
        this.HinhThuc = null;
        this.IdTourDuLich = null;
        this.SoNguoiThamGia = null;
        this.NhuCauDacBiet = null;
        this.ThoiDiemKhoiHanh = null;
    }
     
    public List<BUS_KHACHHANG> getDsKhachHang() {
        return dsKhachHang;
    }

    public String getHinhThuc() {
        return HinhThuc;
    }

    public String getIdTourDuLich() {
        return IdTourDuLich;
    }

    public String getSoNguoiThamGia() {
        return SoNguoiThamGia;
    }
    
    public String getNhuCauDacBiet() {
        return NhuCauDacBiet;
    }

    public LocalDateTime getThoiDiemKhoiHanh() {
        return ThoiDiemKhoiHanh;
    }
    
    public void GuiDoiTac(BUS_DANGKYTOURDULICH dktdl){
        DAO_DANGKYTOURDULICHDB dktdldb = new DAO_DANGKYTOURDULICHDB();
        dktdldb.GuiDoiTac(dktdl);
    }
    
}
