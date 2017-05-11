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
import android.widget.TextView;

import com.example.DataAll;
import com.example.Lokacija;
import com.example.VrstaOdpadkov;

import java.util.Calendar;

import static java.lang.Math.abs;

public class ActivityLokacija extends AppCompatActivity {
    ApplicationMy app;
    ImageView ivSlika;
    TextView txtMail;
    TextView txtTelefon;
    EditText edOpriralniCas;
    EditText edName;
    TextView txtStatus;
    Lokacija l;

    Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylokacija);

        app = (ApplicationMy)getApplication();
        txtMail = (TextView) findViewById(R.id.textViewMail);
        txtTelefon = (TextView) findViewById(R.id.textViewTelefon);
        ivSlika =(ImageView) findViewById(R.id.imageViewMain);
        edOpriralniCas = (EditText)findViewById(R.id.editTextMultiODPIRALNI);
        edName = (EditText)findViewById(R.id.editTextName);
        txtStatus = (TextView)findViewById(R.id.textViewStatus);
        update(app.getTestLocation());
    }
    void setLokacija(String ID) {
        l = app.getLocationByID(ID);
        update(l);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            setLokacija(extras.getString(DataAll.LOKACIJA_ID));
        } else {
            System.out.println("Nič ni v extras!");
        }
        app.save();

        // l = app.getTestLocation();
        // update(l);
    }

    private void update(Lokacija l) {
        txtMail.setText(l.getMail());
        txtTelefon.setText(l.getTelefon());
        edName.setText(l.getNaziv());
        edOpriralniCas.setText(l.getOdpiralniCas().toString());
        int casDo = l.getOdpiralniCasDanDo(dayOfWeek);
        int casoD = l.getOdpiralniCasDanOd(dayOfWeek);
        int trenutniCas = hour;
        //int trenutniCas = 22;
        int tmp = casDo - trenutniCas;
        // 10           17          18          17
        // 10           18          18          18
        // 10           10          18          10
        if(casoD <= trenutniCas && casDo > trenutniCas){
                int t = 60 - minute;
                tmp--;
                txtStatus.setText("Odpto še " + tmp + ":" + t + " ure");
                txtStatus.setTextColor(Color.GREEN);
        }
        else{
            if(trenutniCas < casoD) {
                int tmpOd = casoD - trenutniCas-1;
                int t = 60 - minute;
                txtStatus.setText("Zaprto še " + abs(tmpOd) + ":" + t + " ure");
                txtStatus.setTextColor(Color.RED);
            }else{
                txtStatus.setText("Zaprto že " + abs(tmp) + ":" + minute + " ure");
                txtStatus.setTextColor(Color.RED);
            }
        }
        txtStatus.setTextSize(20);
    }
    public void onClickCall(View v) {
        System.out.printf("Call click");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + app.getTestLocation().getTelefon()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);

    }
    public void onClickEmailSend(View v){
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setType("text/html");
        emailintent.putExtra(Intent.EXTRA_EMAIL, app.getTestLocation().getMail());
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailintent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(Intent.createChooser(emailintent, "Send Email"));

    }
    public void onClickIzhod(View v){
        finish();
    }
}
