package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class CuerpoActivity extends AppCompatActivity {
    //Se crea una listView y el adaptador
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuerpo);

        lvAnimales = findViewById(R.id.listView_ListaCuerpo);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    //Se agregan los archivos que serán mostrados en el arrayList de partes del cuerpo

    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.dcabello,"vegeta", R.drawable.dlcabello));
        listItems.add(new EntidadAnimales(R.drawable.dcabeza,"vegeta", R.drawable.dlcabeza));
        listItems.add(new EntidadAnimales(R.drawable.dmano,"vegeta", R.drawable.dlmano));
        listItems.add(new EntidadAnimales(R.drawable.dpie,"vegeta", R.drawable.dlpie));
        listItems.add(new EntidadAnimales(R.drawable.dojo,"vegeta", R.drawable.dlojo));


        return listItems;
    }
}

