package com.example;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class Lokacija {
    private String id;
    private double x,y; //gps lokacija
    private String naziv;
    //private String naslov;
    private Naslov naslov;
    //private String odpiralni_cas;
    private ArrayList<OdpiralniCas> odpiralniCas;
    private String telefon;
    private String podjetje;

    public Naslov getNaslov() {
        return naslov;
    }

    public void setNaslov(Naslov naslov) {
        this.naslov = naslov;
    }

    private String mail;
   // private VrstaOdpadkovList vrstaOdpadkovList;


    @Override
    public String toString() {
        return "Lokacija{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", naziv='" + naziv + '\'' +
                ", naslov=" + naslov +
                ", odpiralniCas=" + odpiralniCas +
                ", telefon='" + telefon + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public Lokacija(double x, double y, String naziv, ArrayList<OdpiralniCas> odpiralniCas, String telefon, String mail, Naslov naslov, String podjetje) {
        this.podjetje = podjetje;
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.x = x;
        this.y = y;
        this.naziv = naziv;
        this.odpiralniCas = odpiralniCas;
        this.telefon = telefon;
        this.mail = mail;
        this.naslov = naslov;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<OdpiralniCas> getOdpiralniCas() {

        return odpiralniCas;
    }



    public void setOdpiralniCas(ArrayList<OdpiralniCas> odpiralniCas) {
        this.odpiralniCas = odpiralniCas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getOdpiralniCasDanOd(int dan){
        for( OdpiralniCas o : odpiralniCas){
            if(o.getDan() == dan){
                return  o.getCasOd();
            }
        }
        return 0;


    }
    public int getOdpiralniCasDanDo(int dan){
        for( OdpiralniCas o : odpiralniCas){
            if(o.getDan() == dan){
                return  o.getCasDo();
            }
        }
        return 0;


    }
   /* public Lokacija getLocationByID(String ID) {
        for (Lokacija l: lokacijaList) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getId().equals(ID)) return l;
        }
        return null;
    }*/
    public int getOdpiralniCasDanDo(String dan){
        return 0;
    }

    public void setPodjetje(String podjetje) {
        this.podjetje = podjetje;
    }

    public String getPodjetje() {
        return podjetje;
    }
}
