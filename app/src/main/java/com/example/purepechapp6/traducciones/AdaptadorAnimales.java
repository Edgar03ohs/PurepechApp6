package com.example.purepechapp6.traducciones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class AdaptadorAnimales extends BaseAdapter {
    private Context context;
    private ArrayList<EntidadAnimales> listAnimales;

    public AdaptadorAnimales(Context context, ArrayList<EntidadAnimales> listItems) {
        this.context = context;
        this.listAnimales = listItems;
    }
    @Override
    public int getCount() {
        return listAnimales.size();
    }

    @Override
    public Object getItem(int position) {
        return listAnimales.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EntidadAnimales Item = (EntidadAnimales) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_trad_ani,null);
        ImageView imgAnimales = convertView.findViewById(R.id.imgAnimales);
        ImageView imgTraduccion = convertView.findViewById(R.id.imgTraduccion);

        imgAnimales.setImageResource(Item.getImgAnimales());
        imgTraduccion.setImageResource(Item.getImgTraduccion());
        return convertView;
    }
}
