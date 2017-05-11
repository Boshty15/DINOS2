package com.example;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class VrstaOdpadkov {
    private String id;
    private String odpadek;
    private double cena;

    public VrstaOdpadkov(String id, String odpadek, double cena) {
        this.id = id;
        this.odpadek = odpadek;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "VrstaOdpadkov{" +
                "id=" + id +
                ", odpadek='" + odpadek + '\'' +
                ", cena=" + cena +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOdpadek() {
        return odpadek;
    }

    public void setOdpadek(String odpadek) {
        this.odpadek = odpadek;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
