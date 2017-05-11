package com.example;

import java.util.UUID;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class User {
    private String uId;
    private String idUser;
    private String vzdevek;

    private String ime;
    private String priimek;
    private String naslov;
    private String posta;

    public User(String idUser, String vzdevek, String ime, String priimek, String naslov, String posta) {
        this.uId = UUID.randomUUID().toString().replaceAll("-", "");
        this.idUser = idUser;
        this.vzdevek = vzdevek;
        this.ime = ime;
        this.priimek = priimek;
        this.naslov = naslov;
        this.posta = posta;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getVzdevek() {
        return vzdevek;
    }

    public void setVzdevek(String vzdevek) {
        this.vzdevek = vzdevek;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPosta() {
        return posta;
    }

    public void setPosta(String posta) {
        this.posta = posta;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", idUser='" + idUser + '\'' +
                ", vzdevek='" + vzdevek + '\'' +
                ", ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", naslov='" + naslov + '\'' +
                ", posta='" + posta + '\'' +
                '}';
    }
}
