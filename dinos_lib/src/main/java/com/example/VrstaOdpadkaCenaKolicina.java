package com.example;

/**
 * Created by bostj on 12. 04. 2017.
 */

public class VrstaOdpadkaCenaKolicina {
    private VrstaOdpadkov name;
    private double cena;
    private double kolicina;


    @Override
    public String toString() {
        return "VrstaOdpadkaCenaKolicina{" +
                "vrstaOdpadkov=" + name +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                '}';
    }

    public VrstaOdpadkov getVrstaOdpadkov() {
        return name;
    }

    public void setVrstaOdpadkov(VrstaOdpadkov name) {
        this.name = name;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public VrstaOdpadkaCenaKolicina(VrstaOdpadkov name, double cena, double kolicina) {

        this.name = name;
        this.cena = cena;
        this.kolicina = kolicina;
    }
}
