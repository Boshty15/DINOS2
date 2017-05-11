package com.example.bostj.dinos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DataAll;
import com.example.Lokacija;
import com.example.VrstaOdpadkov;

import java.util.Calendar;

import static java.lang.Math.abs;

public class ActivityOdpadek extends AppCompatActivity {
    ApplicationMy app;
    ImageView ivSlika;
    EditText edCena;
    EditText edName;
    VrstaOdpadkov v;
    SeekBar simpleSeekBar;
    TextView txtCenaSkupaj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odpadek);

        app = (ApplicationMy)getApplication();
        ivSlika =(ImageView) findViewById(R.id.imageViewMain);
        edCena = (EditText)findViewById(R.id.txtCena);
        edName = (EditText)findViewById(R.id.editTextName);
        txtCenaSkupaj = (TextView)findViewById(R.id.txtCena);
        update(app.getTestVrstaOdpadkov());

        simpleSeekBar=(SeekBar)findViewById(R.id.seekBar);
        // perform seek bar change listener event used for getting the progress value
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                //txtCenaSkupaj.setText(progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ActivityOdpadek.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();


            }
        });

    }
    void setVrstaOdpadkov(String ID) {
        v = app.getVrstaOdpadkovByID(ID);
        update(v);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            setVrstaOdpadkov(extras.getString(DataAll.ODPADEK_ID));
        } else {
            System.out.println("Nič ni v extras!");
        }

        // l = app.getTestLocation();
        // update(l);
    }

    private void update(VrstaOdpadkov l) {
        edName.setText(l.getOdpadek());
        edCena.setText(l.getCena() + "");
    }



}
