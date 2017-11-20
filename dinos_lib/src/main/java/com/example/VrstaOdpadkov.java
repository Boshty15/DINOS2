package com.example;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class VrstaOdpadkov {
    private String id;
    private String odpadek;

    public VrstaOdpadkov(String id, String odpadek) {
        this.id = id;
        this.odpadek = odpadek;
    }

    @Override
    public String toString() {
        return "VrstaOdpadkov{" +
                "id=" + id +
                ", odpadek='" + odpadek + '\'' +
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
}
