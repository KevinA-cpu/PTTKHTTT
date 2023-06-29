/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pttkhttt.db;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mycompany.pttkhttt.bus.BUS_TOURDULICH;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS I7
 */

    
/**
 *
 * @author ASUS I7
 */
public class DAO_TOURDULICHDB {
    
    public List<BUS_TOURDULICH> LayTourDuLich() {
    List<BUS_TOURDULICH> tourDuLich = new ArrayList<>();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://opentripmap-places-v1.p.rapidapi.com/en/places/radius?radius=500&lon=38.364285&lat=59.855685"))
        .header("X-RapidAPI-Key", "d26b5968cemshf3acc4592de6140p1069ccjsna802bdd0b835")
        .header("X-RapidAPI-Host", "opentripmap-places-v1.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    try {
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray features = jsonObject.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            JSONObject properties = feature.getJSONObject("properties");
            String xid = properties.getString("xid");
            String name = properties.getString("name");
            int rate = properties.getInt("rate");
            String kinds = properties.getString("kinds");
            BUS_TOURDULICH tour = new BUS_TOURDULICH(xid, name, kinds, rate);
            tourDuLich.add(tour);
        }
    } catch (IOException | InterruptedException e) {
        System.out.println(e);
    }
    return tourDuLich;
}

}

