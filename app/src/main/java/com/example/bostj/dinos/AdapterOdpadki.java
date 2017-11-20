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
import com.example.VrstaOdpadkov;

/**
 * Created by bostj on 14. 03. 2017.
 */

public class AdapterOdpadki extends RecyclerView.Adapter<AdapterOdpadki.ViewHolder> {
    DataAll all;
    Activity ac;

    public AdapterOdpadki(DataAll all, Activity ac) {
        this.all = all;
        this.ac = ac;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
       // public TextView txtFooter;
        public ImageView iv;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
         //   txtFooter = (TextView) v.findViewById(R.id.secondLine);
            iv = (ImageView)v.findViewById(R.id.icon);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayoutodpadki, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private static void startDView(String odpadekID, Activity ac) {
        //  System.out.println(name+":"+position);
        Intent i = new Intent(ac.getBaseContext(), ActivityOdpadek.class);
        i.putExtra(DataAll.ODPADEK_ID,  odpadekID);
        ac.startActivity(i);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final VrstaOdpadkov trenutni = all.getVrstaOdpadkov(position);
        holder.txtHeader.setText(trenutni.getOdpadek());
        holder.iv.setImageDrawable(this.  ac.getDrawable(R.mipmap.ic_launcher));

        if (position%2==1) {
            //holder.txtHeader.setTextColor(Color.BLUE);
            holder.txtHeader.setTypeface(null, Typeface.BOLD);
            //holder.txtFooter.setTypeface(null, Typeface.BOLD);


        }
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterOdpadki.startDView(trenutni.getId(),ac);
            }
        });
        /*holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterOdpadki.startDView(trenutni.getId(),ac);
            }
        });*/

        //holder.txtFooter.setText("Cena/t: " +trenutni.getCena() );

    }


    @Override
    public int getItemCount() {
        return all.getVrstaOdpadkovSize();
    }

}
