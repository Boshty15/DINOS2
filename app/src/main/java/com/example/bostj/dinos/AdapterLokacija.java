package com.example.bostj.dinos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.DataAll;
import com.example.Lokacija;

import java.util.Calendar;

import static java.lang.Math.abs;

/**
 * Created by bostj on 14. 03. 2017.
 */

public class AdapterLokacija extends RecyclerView.Adapter<AdapterLokacija.ViewHolder> {
    DataAll all;
    Activity ac;


    public static int UPDATE_DISTANCE_IF_DIFF_IN_M=10;
    Location last;


    public void setLastLocation(Location l) {
        if (last==null) {
            last = l;
            notifyDataSetChanged();
        }
        else {
            if (Util.distance(last.getLatitude(),last.getLongitude(),l.getLatitude(),l.getLongitude())>UPDATE_DISTANCE_IF_DIFF_IN_M){
                last = l;
                notifyDataSetChanged();
            }
        }
    }

    public AdapterLokacija(DataAll all, Activity ac) {
        this.all = all;
        this.ac = ac;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public TextView txtOdprto;
        public ConstraintLayout layout;
        public ImageView iv;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtOdprto = (TextView) v.findViewById(R.id.txtViewOdprto);
            layout = (ConstraintLayout) v.findViewById(R.id.layoutC);
            iv = (ImageView)v.findViewById(R.id.icon);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private static void startDView(String lokacijaID, Activity ac) {
        //  System.out.println(name+":"+position);
        Intent i = new Intent(ac.getBaseContext(), ActivityLokacija.class);
        i.putExtra(DataAll.LOKACIJA_ID,  lokacijaID);
        ac.startActivity(i);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Lokacija trenutni = all.getLocation(position);
        final String name = trenutni.getNaziv();
        holder.txtHeader.setText(trenutni.getNaziv());
        System.out.println("aaaa " + trenutni.getNaziv());
        holder.iv.setImageDrawable(this.  ac.getDrawable(R.mipmap.ic_launcher));

        if (position%2==1) {
            //holder.txtHeader.setTextColor(Color.BLUE);
            holder.txtHeader.setTypeface(null, Typeface.BOLD);
            holder.txtFooter.setTypeface(null, Typeface.BOLD);
            holder.txtOdprto.setTypeface(null, Typeface.BOLD);
            //holder.layout.setBackgroundColor(Color.WHITE);


        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterLokacija.startDView(trenutni.getId(),ac);
            }
        });
       /* holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterLokacija.startDView(trenutni.getId(),ac);
            }
        });*/

        holder.txtFooter.setText("Footer: "  + trenutni.getX() + ", " +trenutni.getY() );
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        int casDo = trenutni.getOdpiralniCasDanDo(dayOfWeek);
        int casoD = trenutni.getOdpiralniCasDanOd(dayOfWeek);
        int trenutniCas = hour+1;
        if(casoD < trenutniCas && casDo > trenutniCas){
            holder.txtOdprto.setText("Odpto");
            holder.txtOdprto.setTextColor(Color.GREEN);
        }
        else{
            holder.txtOdprto.setText("Zaprto");
            holder.txtOdprto.setTextColor(Color.RED);
        }

       // holder.txtOdprto.setText("Odprto");
       // holder.txtOdprto.setTextColor(Color.GREEN);
    }


    @Override
    public int getItemCount() {
        return all.getLocationSize();
    }


}
