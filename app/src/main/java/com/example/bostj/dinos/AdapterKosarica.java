package com.example.bostj.dinos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.DataAll;
import com.example.VrstaOdpadkaCenaKolicina;
import com.example.VrstaOdpadkov;

/**
 * Created by bostj on 13. 04. 2017.
 */

public class AdapterKosarica extends RecyclerView.Adapter<AdapterKosarica.ViewHolder> {
    DataAll all;
    Activity ac;

    public AdapterKosarica(DataAll all, Activity ac) {
        this.all = all;
        this.ac = ac;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView iv;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            iv = (ImageView)v.findViewById(R.id.icon);
        }
    }
    @Override
    public AdapterKosarica.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayoutkkosarica, parent, false);

        // set the view's size, margins, paddings and layout parameters
        AdapterKosarica.ViewHolder vh = new AdapterKosarica.ViewHolder(v);
        return vh;
    }
    private static void startDView(String odpadekID, Activity ac) {
        //  System.out.println(name+":"+position);
        Intent i = new Intent(ac.getBaseContext(), ActivityOdpadek.class);
        i.putExtra(DataAll.ODPADEK_ID,  odpadekID);
        ac.startActivity(i);

    }
    @Override
    public void onBindViewHolder(AdapterKosarica.ViewHolder holder, final int position) {
        final VrstaOdpadkaCenaKolicina trenutni = all.getVrstaOdpadkovKolicinaCena(position);
        holder.txtHeader.setText(trenutni.getVrstaOdpadkov().getOdpadek());
        holder.iv.setImageDrawable(this.  ac.getDrawable(R.mipmap.ic_launcher));

        if (position%2==1) {
            //holder.txtHeader.setTextColor(Color.BLUE);
            holder.txtHeader.setTypeface(null, Typeface.BOLD);
            holder.txtFooter.setTypeface(null, Typeface.BOLD);


        }/*
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterOdpadki.startDView(trenutni.getId(),ac);
            }
        });
        holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterOdpadki.startDView(trenutni.getId(),ac);
            }
        });
*/  holder.txtFooter.setText( "Količina: "+ trenutni.getKolicina());

    }


    @Override
    public int getItemCount() {
        return all.getVrstaOdpadkovKolicinaCenaSize();
    }


}
