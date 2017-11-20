
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
        vrstaOdpadkovList.add(new VrstaOdpadkov("1","Papir"));
        vrstaOdpadkovList.add(new VrstaOdpadkov("2","Zelezo"));
        vrstaOdpadkovList.add(new VrstaOdpadkov("3","Baker"));
        vrstaOdpadkovList.add(new VrstaOdpadkov("4","Plastika"));
        vrstaOdpadkovList.add(new VrstaOdpadkov("5","Akumulatorji"));
    }
    public void addvrstaOdpadkaCenaKolicinas(){
        this.vrstaOdpadkaCenaKolicinas = new ArrayList<>();
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(0),3000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(1),5000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(2),80000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(3),820000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(4),820000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(2),90000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(3),100000));
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrstaOdpadkovList.get(4),9000));

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
    public void addOdpiralniCasSurovina(){
        this.odpiralniCas = new ArrayList<>();
        odpiralniCas.add(odpiralniCasPon(7,15));
        odpiralniCas.add(odpiralniCasTor(7,15));
        odpiralniCas.add(odpiralniCasSre(7,15));
        odpiralniCas.add(odpiralniCasCet(7,15));
        odpiralniCas.add(odpiralniCasPet(7,15));

    }
    public void addOdpiralniCasSiombio(){
        this.odpiralniCas = new ArrayList<>();
        odpiralniCas.add(odpiralniCasPon(6,20));
        odpiralniCas.add(odpiralniCasTor(6,20));
        odpiralniCas.add(odpiralniCasSre(6,20));
        odpiralniCas.add(odpiralniCasCet(6,20));
        odpiralniCas.add(odpiralniCasPet(6,20));

    }
    public void addItemToKosarica(VrstaOdpadkov vrsta, double kolicina){
        vrstaOdpadkaCenaKolicinas.add(new VrstaOdpadkaCenaKolicina(vrsta,kolicina));
    }
    public VrstaOdpadkov getVrstaOdpadkovFromIndex(int index){
        return vrstaOdpadkovList.get(index);
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

    public Lokacija addLocation(double x, double y, String naziv, ArrayList<OdpiralniCas> odpiralni_cas, String telefon, String mail, String naslov, String hisnaSt, int postnaSt, String posta, String podjetje) {
        Lokacija tmp = new Lokacija(x,y,naziv,odpiralni_cas,telefon,mail, new Naslov(naslov,hisnaSt,posta,postnaSt), podjetje);
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
        tmp = da.addLocation(46.39006397823504,14.295007067649863,"Ljubljana Dinos",da.odpiralniCas, "0038615610630","info@dinos.si","Slandrova ulica","6",1000,"Ljubljana", "dinos");
        da.addLocation(46.249529,15.2505651,"Celje Dinos",da.odpiralniCas, "0038634266485","infoCE@dinos.si","Gaji","37",3000,"Celje","dinos");
        da.addLocation(46.5239278,15.6546989,"Maribor Dinos",da.odpiralniCas, "0038623201755","infoCE@dinos.si","Trzaska cesta","55",2000,"Maribor","dinos");
        da.addLocation(46.2560064,14.3196523,"Center za predelavo Naklo",da.odpiralniCas, "00386 4 255 94 90","infoNaklo@dinos.si","Cesta na Okroglo","9",4202,"Naklo","dinos");
        da.addLocation(45.527268,13.735005,"Skladisce Koper",da.odpiralniCas, "00386 5 625 17 20\n","infoKP@dinos.si","?marska cesta","7",6001,"Koper","dinos");
        da.addLocation(46.5492122,16.4505,"Skladisce Lendava",da.odpiralniCas, "00386 2 575 10 27","infoLendava@dinos.si","Trimlini ","1",9220,"Lendava","dinos");

        da.addLocation(46.6682993,16.1742097,"Skladisce Murska Sobota",da.odpiralniCas, "00386 2 524 14 80","infoKP@dinos.si","Marki?avska ","7",9000,"Murska Sobota","dinos");
        da.addLocation(46.0982974,14.5328824,"Skladisce Ptuj",da.odpiralniCas, "00386 2 77 23 901","infoKP@dinos.si","?pindlerjeva ulica","21",2250,"Ptuj","dinos");
        da.addLocation(46.3440159,15.4361028,"Skladisce Slovenske Konjice",da.odpiralniCas, "00386 3 758 04 50","infoKP@dinos.si","Ob potoku","9",3210,"Slovenjske Konjice","dinos");
        da.addLocation(46.573341,15.02767,"Skladisce Dravograd",da.odpiralniCas, "00386 2 87 87 400","infoKP@dinos.si","Oti?ki vrh","25E",2373,"?entjan? pri Dravogradu","dinos");

        da.addLocation(46.3659898,15.0993767,"Skladisce Velenje",da.odpiralniCas, "00386 3 586 64 47","infoKP@dinos.si","Simona Blatnika","9",3320,"Velenje","dinos");
        da.addLocation(46.1517179,15.0434964,"Skladi??e Trbovlje",da.odpiralniCas, "00 386 3 562 57 70","infoKP@dinos.si","Globu?ak ","3",1420,"Trbovlje","dinos");
        da.addLocation(46.0982974,14.5328824,"Skladi??e Sevnica",da.odpiralniCas, "00386 7 814 44 23","infoKP@dinos.si","Hermanova cesta","B?",8920,"Sevnica","dinos");
        da.addLocation(45.9237336,15.5881923,"Skladi??e Bre?ice",da.odpiralniCas, "00386 7 496 12 49","infoKP@dinos.si","Cesta bratov Cerjak","38",8250,"Bre?ice","dinos");

        da.addLocation(45.8190716,15.1546571,"Skladi??e Novo mesto",da.odpiralniCas, "00386 7 337 96 40","infoKP@dinos.si","Ljubljanska ","35",8000,"Novo mesto","dinos");
        da.addLocation(45.5809844,15.1868632,"Skladi??e ?rnomelj",da.odpiralniCas, "00386 7 305 18 90","infoKP@dinos.si","Semi?ka ulica","6",8340,"?rnomelj","dinos");
        da.addLocation(46.0982974,14.5328824,"Skladi??e Ko?evje",da.odpiralniCas, "00386 7 491 12 49","infoKP@dinos.si","Novome?ka cesta","B?",1330,"Ko?evje","dinos");
        da.addLocation(46.2244925,14.3637481,"Skladi??e Kranj",da.odpiralniCas, "00386 4 201 44 51","infoKP@dinos.si","Savska Loka","24",4000,"Kranj","dinos");

        da.addLocation(46.4365546,14.0415793,"Skladi??e Jesenice",da.odpiralniCas, "00386 4 583 51 90","infoKP@dinos.si","Kurilni?ka ","18",4270,"Jesenice","dinos");
        da.addLocation(46.0982974,14.5328824,"Skladi??e Idrija",da.odpiralniCas, "00386 4 201 44 51","infoKP@dinos.si","Vojkova ","9",5280,"Idrija","dinos");
        da.addLocation(45.9666979,13.640705,"Skladi??e Nova Gorica",da.odpiralniCas, "00386 5 300 55 86","infoKP@dinos.si","Cesta IX Korpus","110",5000,"Nova Gorica","dinos");

        da.addOdpiralniCasSurovina();
        da.addLocation(46.5272935,15.6554837, "Surovina Maribor", da.odpiralniCas,"0036827072230", "kovina@surovina.com", "Puchova ulica", "b.š.", 2000, "Maribor", "surovina");
        da.addLocation(46.5272935,15.6554837, "Surovina Ptuj", da.odpiralniCas,"0036827072230", "ptuj@surovina.com", "Lahova", "40", 2000, "Maribor", "surovina");
        da.addLocation(46.5272935,15.6554837, "Surovina Ormoz", da.odpiralniCas,"0036827072230", "Ormož@surovina.com", "Lahova", "40", 2000, "Maribor", "surovina");
        da.addLocation(46.5272935,15.6554837, "Surovina Lasko", da.odpiralniCas,"0036827072230", "kovine@surovina.com", "Lahova", "40", 2000, "Maribor", "surovina");

        da.addOdpiralniCasSiombio();
        da.addLocation(46.2395853, 15.3184555, "Simbio Celje", da.odpiralniCas, "003864256455", "info@simbio.si", "Bukovzlak", "30", 3221, "Teharje", "odpad");
        da.addLocation(46.548783, 15.6538058, "Snaga Maribor", da.odpiralniCas, "003866205800", "info@snaga-mb.si", "Nasipna ulica", "64", 2000, "Maribor", "odpad");

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
    public int getSize(){
        return vrstaOdpadkaCenaKolicinas.size();
    }
    public VrstaOdpadkaCenaKolicina getItem(int i){
        return vrstaOdpadkaCenaKolicinas.get(i);
    }
    public int getIndexOdpadekName(String name){

        for(int i = 0; i < vrstaOdpadkovList.size();i++){
            if(vrstaOdpadkovList.get(i).getOdpadek().equals(name)){
                return i;
            }
        }
        return 0;
    }
}
