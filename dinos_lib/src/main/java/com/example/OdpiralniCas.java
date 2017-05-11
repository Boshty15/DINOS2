package com.example;

/**
 * Created by bostj on 7. 03. 2017.
 */

public class OdpiralniCas {
    private int dan;
    private int casOd;
    private int casDo;

    public OdpiralniCas(int dan, int casOd, int casDo) {
        this.dan = dan;
        this.casOd = casOd;
        this.casDo = casDo;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getCasOd() {
        return casOd;
    }

    public void setCasOd(int casOd) {
        this.casOd = casOd;
    }

    public int getCasDo() {
        return casDo;
    }

    public String changeIntToDan(int i){
        switch (i){
            case 1: return "Ponedeljek";
            case 2: return "Torek";
            case 3: return "Sreda";
            case 4: return "Cetrtek";
            case 5: return "Petek";
            case 6: return "Sobota";
            default:
        }
        return "";
    }


    public void setCasDo(int casDo) {
        this.casDo = casDo;
    }
    public OdpiralniCas odpiralniCasPon(int x,int y){
        return new OdpiralniCas(1,x,y);
    }
    public OdpiralniCas odpiralniCasTor(int x,int y){
        return new OdpiralniCas(2,x,y);
    }
    public OdpiralniCas odpiralniCasSre(int x,int y){
        return new OdpiralniCas(3,x,y);
    }
    public OdpiralniCas odpiralniCasCet(int x,int y){
        return new OdpiralniCas(4,x,y);
    }
    public OdpiralniCas odpiralniCasPet(int x,int y){
        return new OdpiralniCas(5,x,y);
    }
    public OdpiralniCas odpiralniCasSob(int x,int y){
        return new OdpiralniCas(6,x,y);
    }

    @Override
    public String toString() {
        return changeIntToDan(dan) + " " + casOd +  " - " + casDo + "\n";
    }
}
