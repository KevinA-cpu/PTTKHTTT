/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.bus;

import java.util.List;
import com.mycompany.pttkhttt.db.DAO_TOURDULICHDB;

/**
 *
 * @author ASUS I7
 */
public class BUS_TOURDULICH {
    private final String xId;
    private final String name;
    private final String kinds;
    private final int rate;

    
     public BUS_TOURDULICH(){
       this.xId = null;
       this.name=null;
       this.kinds=null;
       this.rate=0;
    }
    
    public BUS_TOURDULICH(String xId, String name, String kinds, int rate){
        this.xId = xId;
        this.name =  name;
        this.kinds=kinds;
        this.rate=rate;
    }
    
    public String getxId() {
        return xId;
    }

    public String getName() {
        return name;
    }

    public String getKinds() {
        return kinds;
    }

    public int getRate() {
        return rate;
    }
   
    public List<BUS_TOURDULICH> LayTourDuLich() {
        DAO_TOURDULICHDB tdldb = new DAO_TOURDULICHDB();
        return tdldb.LayTourDuLich();
    }
    
}
