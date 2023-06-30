/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;


import com.mycompany.pttkhttt.bus.BUS_DANGKYTOURDULICH;
import com.mycompany.pttkhttt.bus.BUS_KHACHHANG;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author ASUS I7
 */
public class DAO_DANGKYTOURDULICHDB {
    public void GuiDoiTac(BUS_DANGKYTOURDULICH dktdl){
        int counter = 1;
        try (PrintWriter writer = new PrintWriter("GuiDoiTac.txt", "UTF-8")) {
            writer.println("Danh sach khach hang:");
            writer.println();
            for (BUS_KHACHHANG khachHang : dktdl.getDsKhachHang()) {
                 writer.println("Khach hang " + counter + ":");
                 writer.println("Ten khach hang: " +khachHang.getTenkhachhang());
                 writer.println("Dia chi: " + khachHang.getDiachi());
                 writer.println("Email: " +khachHang.getEmail());
                 writer.println("Id_kh: " +khachHang.getId_kh());
                 writer.println("Ngay den: " +khachHang.getNgayDen().toString());
                 writer.println("SDT: 0" +khachHang.getSdt());
                 writer.println("So dem luu tru: " +khachHang.getSodemluutru());
                 writer.println("So luong hanh ly: " +khachHang.getSoluonghanhly());
                 counter++;
                 writer.println();
            }
            writer.println();
            writer.println("Id Tour du lich da chon: " + dktdl.getIdTourDuLich());
            writer.println("Hinh Thuc: " + dktdl.getHinhThuc());
            writer.println("So nguoi tham gia: " + dktdl.getSoNguoiThamGia());
            writer.println("Nhu cau dac biet: " + dktdl.getNhuCauDacBiet());
            writer.println("Thoi diem khoi hanh: " + dktdl.getThoiDiemKhoiHanh());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }
}
