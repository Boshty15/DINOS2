package com.example;

import java.util.ArrayList;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class LokacijaList {
    private ArrayList<Lokacija> list;

    public LokacijaList() {
        /*list = new ArrayList<>();
        list.add(new Lokacija(46.5454545,45.1232122,"Ljubljana Dinos","Pond 10-12", "051555666","info@dinos.si"));
        list.add(new Lokacija(47.54523,44.121212,"Celje Dinos","Pond 10-12", "051555666","infoCE@dinos.si"));
        list.add(new Lokacija(48.4545454,43.69696969,"Novo mesto Dinos","Pond 10-12", "051555666","infoNM@dinos.si"));
        list.add(new Lokacija(49.32323232,42.25252525,"Maribor Dinos","Pond 10-12", "051555666","infoMB@dinos.si"));*/
    }

    public ArrayList<Lokacija> getList() {
        return list;
    }

    public void setList(ArrayList<Lokacija> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LokacijaList{" +
                "list=" + list +
                '}';
    }
}
