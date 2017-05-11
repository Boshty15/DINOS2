package com.example;

/**
 * Created by bostj on 12. 04. 2017.
 */

public class VrstaOdpadkaCenaKolicina {
    private VrstaOdpadkov vrstaOdpadkov;
    private double cena;
    private double kolicina;


    @Override
    public String toString() {
        return "VrstaOdpadkaCenaKolicina{" +
                "vrstaOdpadkov=" + vrstaOdpadkov +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                '}';
    }

    public VrstaOdpadkov getVrstaOdpadkov() {
        return vrstaOdpadkov;
    }

    public void setVrstaOdpadkov(VrstaOdpadkov vrstaOdpadkov) {
        this.vrstaOdpadkov = vrstaOdpadkov;
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

    public VrstaOdpadkaCenaKolicina(VrstaOdpadkov vrstaOdpadkov, double cena, double kolicina) {

        this.vrstaOdpadkov = vrstaOdpadkov;
        this.cena = cena;
        this.kolicina = kolicina;
    }
}
