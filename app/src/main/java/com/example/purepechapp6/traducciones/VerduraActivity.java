package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class VerduraActivity extends AppCompatActivity {
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdura);

        lvAnimales = findViewById(R.id.listView_ListaVerdura);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.hchile,"vegeta", R.drawable.hlchile));
        listItems.add(new EntidadAnimales(R.drawable.helote,"vegeta", R.drawable.hlelote));
        listItems.add(new EntidadAnimales(R.drawable.hfrijol,"vegeta", R.drawable.hlfrijol));
        listItems.add(new EntidadAnimales(R.drawable.hmaiz,"vegeta", R.drawable.hlmaiz));
        listItems.add(new EntidadAnimales(R.drawable.hnopal,"vegeta", R.drawable.hlnopal));


        return listItems;
    }
}

