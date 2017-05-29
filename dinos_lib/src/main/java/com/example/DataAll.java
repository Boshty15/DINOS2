
package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class DataAll {
    public static final String LOKACIJA_ID = "lokacija_idXX";
    public static final String ODPADEK_ID = "odpadek_idXX";
    public static final String KOSARICA_ID = "kosarica_idXX";
    private User userMe;
    private ArrayList<Lokacija> lokacijaList;
   // private VrstaOdpadkovList vrstaOdpadkovList;
    private ArrayList<OdpiralniCas> odpiralniCas;
    private ArrayList<VrstaOdpadkov> vrstaOdpadkovList;
    private ArrayList<VrstaOdpadkaCenaKolicina> vrstaOdpadkaCenaKolicinas;


    public ArrayList<Lokacija> getLokacijeArray (){return lokacijaList;}

    public Lokacija getLocationByID(String ID) {
        for (Lokacija l: lokacijaList) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getId().equals(ID)) return l;
        }
        return null;
    }

    public VrstaOdpadkov getOdpadekByID(String ID) {
        for (VrstaOdpadkov l: vrstaOdpadkovList) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getId().equals(ID)) return l;
        }
        return null;
    }
    public void addVrstaOdpadkov(){
        this.vrstaOdpadkovList = new ArrayList<>();
        vrstaOdpadkovList.add(new VrstaOdpadkov("1","Papir",20));
        vrstaOdpadkovList.add(new VrstaOdpadkov("2","Železo",30));
        vrstaOdpadkovList.add(new VrstaOdpadkov("3","Baker",100));
        vrstaOdpadkovList.add(new VrstaOdpadkov("4","Plastika",26));
        vrstaOdpadkovList.add(new VrstaOdpadkov("5","Akumulatorji",120));
    }
    public void addvrstaOdpadkaCenaKolicinas(){
        this.vrstaOdpadkaCenaKolicinas = new ArrayList<>();
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(0),200,3000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(1),300,5000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(2),400,80000));

    }

    public void addOdpiralniCas(){
        this.odpiralniCas = new ArrayList<>();
        odpiralniCas.add(odpiralniCasPon(10,18));
        odpiralniCas.add(odpiralniCasTor(10,18));
        odpiralniCas.add(odpiralniCasSre(10,18));
        odpiralniCas.add(odpiralniCasCet(10,18));
        odpiralniCas.add(odpiralniCasPet(10,18));
        odpiralniCas.add(odpiralniCasSob(10,12));

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

    public Lokacija addLocation(double x, double y, String naziv, ArrayList<OdpiralniCas> odpiralni_cas, String telefon, String mail) {
        Lokacija tmp = new Lokacija(x,y,naziv,odpiralni_cas,telefon,mail);
        lokacijaList.add(tmp);
        return tmp;
    }


    public DataAll() {
        userMe = new User("neznani.nedolocen@ga.ni", "NiDefiniran", "neznan", "nedefiniran", "nek naslov", "0000 neznana posta");
        //vrstaOdpadkovList = new VrstaOdpadkovList();
        lokacijaList = new ArrayList<Lokacija>();
    }
    public static DataAll scenarijA(){
        DataAll da = new DataAll();
        da.addOdpiralniCas();
        Lokacija tmp;
        tmp = da.addLocation(46.39006397823504,14.295007067649863,"Ljubljana Dinos",da.odpiralniCas, "051555666","infoLJ@dinos.si");
        da.addLocation(46.249529,15.2505651,"Celje Dinos",da.odpiralniCas, "051333555","infoCE@dinos.si");
        da.addLocation(46.5239278,15.6546989,"Maribor Dinos",da.odpiralniCas, "051333555","infoCE@dinos.si");
        da.addLocation(46.2560064,14.3196523,"Center za predelavo Naklo",da.odpiralniCas, "051333555","infoCE@dinos.si");
        da.addLocation(45.527268,13.735005,"Skladisce Koper",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.5492122,16.4505,"Skladisce Lendava",da.odpiralniCas, "051111222","infoLendava@dinos.si");

        da.addLocation(46.6682993,16.1742097,"Skladišče Murska Sobota",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.0982974,14.5328824,"Skladišče Ptuj",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.3440159,15.4361028,"Skladišče Slovenske Konjice",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.573341,15.02767,"Skladišče Dravograd",da.odpiralniCas, "051111222","infoKP@dinos.si");

        da.addLocation(46.3659898,15.0993767,"Skladišče Velenje",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.1517179,15.0434964,"Skladišče Trbovlje",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.0982974,14.5328824,"Skladišče Sevnica",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(45.9237336,15.5881923,"Skladišče Brežice",da.odpiralniCas, "051111222","infoKP@dinos.si");

        da.addLocation(45.8190716,15.1546571,"Skladišče Novo mesto",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(45.5809844,15.1868632,"Skladišče Črnomelj",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.0982974,14.5328824,"Skladišče Kočevje",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.2244925,14.3637481,"Skladišče Kranj",da.odpiralniCas, "051111222","infoKP@dinos.si");

        da.addLocation(46.4365546,14.0415793,"Skladišče Jesenice",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(46.0982974,14.5328824,"Skladišče Idrija",da.odpiralniCas, "051111222","infoKP@dinos.si");
        da.addLocation(45.9666979,13.640705,"Skladišče Nova Gorica",da.odpiralniCas, "051111222","infoKP@dinos.si");

        da.userMe = new User("Bostjan@Kostomaj.org", "Bostjan", "Bostjan", "Kostomaj", "Kocbekova cesta 22", "3202 Ljubecna");
        //da.lokacijaList = new ArrayList<Lokacija>();
        da.addVrstaOdpadkov();

        da.addvrstaOdpadkaCenaKolicinas();

        return da;

    }
    public Lokacija getLocation(int i) {
        return lokacijaList.get(i);
    }
    public  int getLocationArraySize(){ return lokacijaList.size();}
    public VrstaOdpadkov getVrstaOdpadkov(int i){
        return vrstaOdpadkovList.get(i);
    }
    public VrstaOdpadkaCenaKolicina getVrstaOdpadkovKolicinaCena(int i){
        return vrstaOdpadkaCenaKolicinas.get(i);
    }
    public OdpiralniCas getCasOd(int i){
        return odpiralniCas.get(i);
    }
    public ArrayList<VrstaOdpadkaCenaKolicina> getKosaricaAll() {
        return vrstaOdpadkaCenaKolicinas;
    }
    public List<Lokacija> getLokacijaAll() {
        return lokacijaList;
    }

    @Override
    public String toString() {
        return "DataAll{" +
                "userMe=" + userMe +
                ", lokacijaList=" + lokacijaList +
                ", odpiralniCas=" + odpiralniCas +
                '}';
    }
    public int getLocationSize() {
        return lokacijaList.size();
    }
    public int getVrstaOdpadkovSize() {
        return vrstaOdpadkovList.size();
    }
    public int getVrstaOdpadkovKolicinaCenaSize() {
        return vrstaOdpadkaCenaKolicinas.size();
    }

}
