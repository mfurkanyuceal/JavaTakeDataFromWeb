package com.company;

import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;


public class Main {

    static String alfabe = "A B C Ç D E F G H İ K L M N O Ö P R S T U Ü V Y Z";
    static String[] harf = alfabe.split(" ");


    public static void main(String[] args) throws IOException {

        var alimarray = new ArrayList<Alim>();

        for (int i = 0; i < harf.length; i++) {

            try {
                var url = new URL("http://www.ehlisunnetbuyukleri.com/Islam-Alimleri-Ansiklopedisi/Alfabetik/" + harf[i]);
                var newAlim = new Alim();
                var document1 = Jsoup.connect(url.toString()).get();
                for (int j = 0; j < document1.select("a.IslamAlimleri_Hicri").size(); j++) {
                    Element price = document1.select("a.IslamAlimleri_Hicri").get(j);
                    String kaynak = "http://www.ehlisunnetbuyukleri.com" + price.attr("href");
                    newAlim.setKaynak(kaynak);

                    Document alimContent = Jsoup.connect(newAlim.getKaynak()).get();
                    Element price23 = alimContent.select("label#lblTitle").first();
                    String isim = price23.text();
                    newAlim.setKelime(isim);
                    String content = "";
                    for (int k = 0; k < alimContent.select("p").size(); k++) {
                        Element price3 = alimContent.select("p").get(k);
                        content += price3.text();
                    }
                    newAlim.setMana(content);
                    newAlim.setKaynak("www.ehlisunnetbuyukleri.com");
                    alimarray.add(newAlim);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(harf[i]);
        }

        var gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("C:\\Users\\M.Furkan Yüceal\\IdeaProjects\\HizmetWeb\\src\\com\\company\\alimlist.json");
        FileWriter writer = new FileWriter(file);
        writer.write(gsonBuilder.toJson(alimarray));
        writer.close();
    }
}