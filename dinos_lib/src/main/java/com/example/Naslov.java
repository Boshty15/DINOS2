package com.example;

/**
 * Created by bostj on 30. 05. 2017.
 */

public class Naslov {
    private String naslov;
    private String hisnaSt;
    private String posta;
    private int postnaSt;

    @Override
    public String toString() {
        return "Naslov{" +
                "naslov='" + naslov + '\'' +
                ", hisnaSt='" + hisnaSt + '\'' +
                ", posta='" + posta + '\'' +
                ", postnaSt=" + postnaSt +
                '}';
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getHisnaSt() {
        return hisnaSt;
    }

    public void setHisnaSt(String hisnaSt) {
        this.hisnaSt = hisnaSt;
    }

    public String getPosta() {
        return posta;
    }

    public void setPosta(String posta) {
        this.posta = posta;
    }

    public int getPostnaSt() {
        return postnaSt;
    }

    public void setPostnaSt(int postnaSt) {
        this.postnaSt = postnaSt;
    }

    public Naslov(String naslov, String hisnaSt, String posta, int postnaSt) {

        this.naslov = naslov;
        this.hisnaSt = hisnaSt;
        this.posta = posta;
        this.postnaSt = postnaSt;
    }
}
