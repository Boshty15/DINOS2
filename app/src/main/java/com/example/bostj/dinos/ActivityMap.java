package com.example.bostj.dinos;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.example.DataAll;
import com.example.Lokacija;
import com.example.bostj.dinos.eventBus.MessageEventUpdateLocation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ScaleBarOverlay;

import java.util.ArrayList;

//https://github.com/osmdroid/osmdroid
//https://github.com/osmdroid/osmdroid/wiki/How-to-use-the-osmdroid-library
//http://stackoverflow.com/questions/6173388/googlemaps-custom-itemizedoverlay-and-overlayitem-the-correct-way-to-show-diff
//https://github.com/osmdjava.lang.Stringroid/osmdroid/blob/762c3d4241a9a78b244ab233f6f00bb866ee482a/osmdroid-third-party/src/main/java/org/osmdroid/google/overlay/GooglePolylineOverlay.java
//
public class ActivityMap extends Activity {
    private static final  String TAG = ActivityMap.class.getCanonicalName();
    ApplicationMy app;
    MapView mMapView;
    ScaleBarOverlay mScaleBarOverlay;
    DisplayMetrics dm;
    ArrayList<OverlayItem> items;
    private ItemizedOverlayWithFocus<OverlayItem> mMyLocationOverlay;
    GeoPoint startPoint;

    Location mLocation;
    IMapController mapController;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEventUpdateLocation event) {
        Log.i("ActivityZacetna","MessageEventUpdateLocation ");
        mLocation = event.getM();
        //mAdapter.setLastLocation(mLocation);
        startPoint = new GeoPoint(mLocation);
        mapController.setCenter(startPoint);
        Log.i(TAG, "MLokacija update:"+mLocation);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_map);
        Context ctx = getApplicationContext();
        //important! set your user agent to prevent getting banned from the osm servers
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_map);

        app = (ApplicationMy)getApplication();
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);
         mapController = mMapView.getController();
        mapController.setZoom(10);
        mLocation = app.getmLastLocation();
        GeoPoint startPoint = new GeoPoint(mLocation); // naštimat na trenutno lokacijo
        //System.out.println("lokacija= "+mLastLocation);

        mapController.setCenter(startPoint);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        mScaleBarOverlay = new ScaleBarOverlay(mMapView);
        mScaleBarOverlay.setCentred(true);
//play around with these values to get the location on screen in the right place for your applicatio
        mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);
        mMapView.getOverlays().add(this.mScaleBarOverlay);

        items = new ArrayList<OverlayItem>();
        //items.add(new OverlayItem("Smeti2", "Veliko smeti", new GeoPoint(46.25139,15.2568)));
        //items.add(new OverlayItem("Smeti", "Veliko smeti3", new GeoPoint(46.25139,15.2578)));
        //items.add(new OverlayItem(app.getLocation(0).getNaziv(),app.getLocation(0).getNaziv(),new GeoPoint(app.getLocation(0).getX(),app.getLocation(0).getY())));

        for(int i=0;i < app.getLocationArraySize();i++){
            String tmp = app.getLocation(i).getNaslov().getNaslov() + " " + app.getLocation(i).getNaslov().getHisnaSt();
            items.add(new OverlayItem(app.getLocation(i).getNaziv(),tmp ,new GeoPoint(app.getLocation(i).getX(),app.getLocation(i).getY())));
        }


        mMyLocationOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        IMapController mapController = mMapView.getController();
                        mapController.setCenter(item.getPoint());
                        mapController.zoomTo(mMapView.getMaxZoomLevel());
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        Toast.makeText(ActivityMap.this
                                ,
                                "Item '" + item.getTitle() + "' (index=" + index
                                        + ") got long pressed", Toast.LENGTH_LONG).show();
                        return false;
                    }
                }, this);


        mMyLocationOverlay.setFocusItemsOnTap(true);
        mMapView.getOverlays().add(mMyLocationOverlay);
        //Track path
        /*GooglePolylineOverlay gp = new GooglePolylineOverlay(Color.RED,8);
        gp.addPoints( new GeoPoint(46.25139,15.2568), new GeoPoint(46.25139,15.2578), new GeoPoint(46.25300,15.2572),new GeoPoint(46.25139,15.2568));
        mMapView.getOverlays().add(gp);*/
    }
    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        if (!EventBus.getDefault().isRegistered(this))
          EventBus.getDefault().register(this);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }

    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }
}
