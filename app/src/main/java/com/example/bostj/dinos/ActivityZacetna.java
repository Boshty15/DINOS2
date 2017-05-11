package com.example.bostj.dinos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.PermissionRequest;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class ActivityZacetna extends AppCompatActivity {
    ApplicationMy app;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                startActivity(new Intent(this,ActivityMySettings.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void getPermissions() {
        MultiplePermissionsListener my  = new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (!report.areAllPermissionsGranted()) {
                    new android.app.AlertDialog.Builder(ActivityZacetna.this)
                            .setTitle(getString(R.string.permission_must_title))
                            .setMessage(getString(R.string.permission_must))
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    ActivityZacetna.this.finish(); //end app!
                                }
                            })
                            .setIcon(R.drawable.trash_icon)
                            .show();
                }}

            @Override
            public void onPermissionRationaleShouldBeShown(List<com.karumi.dexter.listener.PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }


        };


        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(my).check();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPermissions();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (ApplicationMy)getApplication();
        setContentView(R.layout.activity_zacetna);
        startService(new Intent(app, GPSLocation.class));

    }

    public  void onClickLokacije(View v){
        Intent i = new Intent(getBaseContext(),ActivitySeznamLokacij.class);
        startActivity(i);
    }
    public  void onClickVrstaOdpadkov(View v){
        Intent i = new Intent(getBaseContext(),ActivityVrstaOdpadkovList.class);
        startActivity(i);
    }
    public  void onClickShowMap(View v){
        if (app.getmLastLocation()!=null) {
            Intent i = new Intent(getBaseContext(), ActivityMap.class);
            startActivity(i);
        }
    }
}