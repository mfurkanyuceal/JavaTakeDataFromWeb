package com.company;

import com.google.gson.JsonObject;
import org.json.simple.JSONObject;

public class Alim {

    private String Kelime;
    private String Mana;
    private String Kaynak;
    private Boolean HattiKuranVarMi;


    public Alim() {
        this.Kelime = "";
        this.Mana = "";
        this.Kaynak = "www.ehlisunnetbuyukleri.com";
        this.HattiKuranVarMi=false;
    }


    public String getKelime() {
        return Kelime;
    }

    public void setKelime(String kelime) {
        this.Kelime = kelime;
    }

    public String getKaynak() {
        return Kaynak;
    }

    public void setKaynak(String kaynak) {
        this.Kaynak = kaynak;
    }

    public String getMana() {
        return Mana;
    }

    public void setMana(String mana) {
        this.Mana = mana;
    }
}
