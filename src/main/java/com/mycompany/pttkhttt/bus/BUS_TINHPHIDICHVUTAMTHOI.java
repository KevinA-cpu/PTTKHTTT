/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;

import com.mycompany.pttkhttt.db.DAO_TINHPHIDICHVUTAMTHOIDB;
import java.math.BigDecimal;

/**
 *
 * @author ASUS I7
 */
public class BUS_TINHPHIDICHVUTAMTHOI {
    private final String nganhang;
    private final String sotaikhoan;
    private final BigDecimal giatien;

    public BUS_TINHPHIDICHVUTAMTHOI(){
       this.nganhang = null;
       this.sotaikhoan = null;
       this.giatien = null;
    }
    
    public void TinhPhiDichVuTamThoi(String nganhang, String sotaikhoan, BigDecimal giatien){
        DAO_TINHPHIDICHVUTAMTHOIDB tpdvttdb = new DAO_TINHPHIDICHVUTAMTHOIDB();
        tpdvttdb.TinhPhiDichVuTamThoi(nganhang, sotaikhoan, giatien);
    }
}
