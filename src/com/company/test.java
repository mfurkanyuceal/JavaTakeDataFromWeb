package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class test {


    public static void main(String Args[]) throws IOException {

        File file = new File("C:\\Users\\M.Furkan Yüceal\\IdeaProjects\\HizmetWeb\\src\\com\\company\\alimlist.json");
        FileWriter writer = new FileWriter(file);

        writer.write("</br>");

        writer.close();


        var alimarray = new ArrayList<Alim>();

        var alim=new Alim();

        alim.setKaynak("www.google.com");
        alim.setMana("bundan sonra böyle </br>");
        alim.setKelime("furkan");


    }


}
