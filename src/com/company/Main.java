package com.company;

import com.google.gson.Gson;
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
        System.out.println("Program was Started!");
        var alimarray = new ArrayList<Alim>();
        for (int i = 0; i < harf.length; i++) {

            try {
                var url = new URL("http://www.ehlisunnetbuyukleri.com/Islam-Alimleri-Ansiklopedisi/Alfabetik/" + harf[i]);
                var document1 = Jsoup.connect(url.toString()).get();
                for (int j = 0; j < document1.select("a.IslamAlimleri_Hicri").size(); j++) {
                    var newAlim = new Alim();
                    Element price = document1.select("a.IslamAlimleri_Hicri").get(j);
                    String kaynak = "http://www.ehlisunnetbuyukleri.com" + price.attr("href");
                    newAlim.setKaynak(kaynak);

                    var alimContent = Jsoup.connect(newAlim.getKaynak()).get();
                    var price23 = alimContent.select("label#lblTitle").first();
                    var isim = price23.text();
                    newAlim.setKelime(isim);

                    for (int k = 0; k < alimContent.select("p").size(); k++) {
                        var price3 = alimContent.select("p").get(k).html();
                        newAlim.addMana(price3);
                    }

                    newAlim.clearMana();
                    newAlim.setKaynak("www.ehlisunnetbuyukleri.com");
                    alimarray.add(newAlim);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(harf[i]+"'s data  is get taked!");
        }
        var gsonBuilder = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        File file = new File("C:\\Users\\M.Furkan Yüceal\\IdeaProjects\\HizmetWeb\\src\\com\\company\\alimlist.json");
        FileWriter writer = new FileWriter(file);
        writer.write(gsonBuilder.toJson(alimarray));
        writer.close();
    }
}