/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;


/**
 *
 * @author ASUS I7
 */
public class DAO_TINHPHIDICHVUTAMTHOIDB {
    public void TinhPhiDichVuTamThoi(String nganhang, String sotaikhoan, BigDecimal giatien){
        try {
            FileWriter fw = new FileWriter("ThanhToan.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Ngan hang: " + nganhang);
            bw.newLine();
            bw.write("So tai khoan: " + sotaikhoan);
            bw.newLine();
            bw.write("Gia tien: " + giatien.toString());
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
           
        }
    }  
}
