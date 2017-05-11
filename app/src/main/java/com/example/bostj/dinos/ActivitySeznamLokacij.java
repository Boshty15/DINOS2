package com.example.bostj.dinos;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.bostj.dinos.eventBus.MessageEventUpdateLocation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class ActivitySeznamLokacij extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AdapterLokacija mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ApplicationMy app;
    Location mLocation;

    @Subscribe
    public void onMessageEvent(MessageEventUpdateLocation event) {
        Log.i("ApplicationMy","MessageEventUpdateLocation ");
        mLocation = event.getM();
        mAdapter.setLastLocation(mLocation);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seznam_lokacij);
        mRecyclerView = (RecyclerView) findViewById(R.id.myrecycleview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        app = (ApplicationMy)getApplication();
        mAdapter = new AdapterLokacija(app.getAll(), this);
        mRecyclerView.setAdapter(mAdapter);

        app.sortChangeAndUpdate();
        mAdapter.notifyDataSetChanged();

        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);

    }
    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

}
