package com.example.bostj.dinos;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.DataAll;
import com.example.Lokacija;
import com.example.VrstaOdpadkaCenaKolicina;
import com.example.VrstaOdpadkov;
import com.example.bostj.dinos.eventBus.MessageEventUpdateLocation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bostj on 5. 03. 2017.
 */

public class ApplicationMy extends Application {
    private static final String TAG = ApplicationMy.class.getCanonicalName() ;
    int x;
    DataAll a;

    private static final String DATA_MAP = "smetimapa";
    private static final String FILE_NAME = "smeti.json";
    Location mLastLocation;

    @Subscribe
    public void onMessageEvent(MessageEventUpdateLocation event) {
        Log.i("ApplicationMy","MessageEventUpdateLocation ");
        mLastLocation = event.getM();
    }

    public Location getmLastLocation() {
        return mLastLocation;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x = 5;
        if(load())
            Log.i(TAG,"uspešeno naložena datoteka");
        else {
            Log.i(TAG, " NE uspešeno naložena datoteka");
            a= DataAll.scenarijA();
        }
        a= DataAll.scenarijA();



        mLastLocation=null;
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        EventBus.getDefault().unregister(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Lokacija getTestLocation() {
        return a.getLocation(0);
    }
    public Lokacija getLocation(int i) {
        return a.getLocation(i);
    }
    public  int getLocationArraySize(){ return a.getLocationArraySize();}

    public VrstaOdpadkov getTestVrstaOdpadkov() {
        return a.getVrstaOdpadkov(0);
    }
    public DataAll getAll() {
        return  a;
    }
    public Lokacija getLocationByID(String id) {
        return a.getLocationByID(id);
    }
    public VrstaOdpadkov getVrstaOdpadkovByID(String id) {
        return a.getOdpadekByID(id);
    }
    public void removeLocationByPosition(int adapterPosition) {
        a.getKosaricaAll().remove(adapterPosition);
    }
    public void removeAll() {
        a.getKosaricaAll().clear();
    }
    public int getSize(){
        return a.getSize();
    }
    public VrstaOdpadkaCenaKolicina getItem(int i){
        return a.getItem(i);
    }
    public boolean save() {
        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);

        return ApplicationJson.save(a,file);
    }
    public boolean load(){
        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);
        DataAll tmp = ApplicationJson.load(file);
        if (tmp!=null) a = tmp;
        else return false;
        return true;
    }
    public Location getLocation() {
        return mLastLocation;
    }
    public void sortUpdate() {

                if (mLastLocation==null) return;
                Collections.sort(a.getLokacijaAll(), new Comparator<Lokacija>() {
                    @Override
                    public int compare(Lokacija l1, Lokacija l2) {
                        int d1 = Util.distance(mLastLocation.getLatitude(),mLastLocation.getLongitude(),l1.getX(),l1.getY());
                        int d2 = Util.distance(mLastLocation.getLatitude(),mLastLocation.getLongitude(),l2.getX(),l2.getY());
                        if (d1==d2) return 0;
                        if (d1>d2) return 1;
                        return -1;
                    }
                });





    }
    public void sortChangeAndUpdate() {
        sortUpdate();
    }

    public void addItemToKosarica(VrstaOdpadkov vrsta, double kolicina){
        a.addItemToKosarica(vrsta,kolicina);
    }
    public VrstaOdpadkov getVrstaOdpadkovFromIndex(int index){
        return a.getVrstaOdpadkovFromIndex(index);
    }
    public int getIndexOdpadekName(String name){

        return a.getIndexOdpadekName(name);
    }

}
