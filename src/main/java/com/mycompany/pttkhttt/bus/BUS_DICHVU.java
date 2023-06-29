package com.mycompany.pttkhttt.bus;

import com.mycompany.pttkhttt.db.DAO_DICHVUDB;
import java.math.BigDecimal;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS I7
 */
public class BUS_DICHVU {
    
    private final String id_dv;
    private final String tendichvu;
    private final String mota;
    private final BigDecimal gia;
   
    public BUS_DICHVU(){
       this.id_dv = null;
       this.tendichvu=null;
       this.mota=null;
       this.gia=null;
    }
    
    public BUS_DICHVU(String id_dv, String tendichvu, String mota, BigDecimal gia){
        this.id_dv = id_dv;
        this.tendichvu =  tendichvu;
        this.mota=mota;
        this.gia=gia;
    }
    
    public String getId_dv() {
        return id_dv;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public String getMota() {
        return mota;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public List<BUS_DICHVU> LayDichVu() {
        DAO_DICHVUDB daoDichVuDb = new DAO_DICHVUDB();
        List<BUS_DICHVU> dichVuList = daoDichVuDb.LayDichVu();
        return dichVuList;
    }
    
    public String LayApDungDichVu(String id_dv){
       DAO_DICHVUDB daoDichVuDb = new DAO_DICHVUDB();
       return daoDichVuDb.LayApDungDichVu(id_dv);
    }

   public BigDecimal layGiaDichVu(String id_dv) {
      DAO_DICHVUDB daoDichVuDb = new DAO_DICHVUDB();
      return daoDichVuDb.LayGiaDichVu(id_dv);
   }
}
