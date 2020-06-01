package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class NumerosActivity extends AppCompatActivity {
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Se crea una listView y el adaptador
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        lvAnimales = findViewById(R.id.listView_ListaNumeros);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    //Se agregan los archivos que serán mostrados en el arrayList de números
    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.euno,"vegeta", R.drawable.eluno));
        listItems.add(new EntidadAnimales(R.drawable.edos,"vegeta", R.drawable.eldos));
        listItems.add(new EntidadAnimales(R.drawable.etres,"vegeta", R.drawable.eltres));
        listItems.add(new EntidadAnimales(R.drawable.ediez,"vegeta", R.drawable.eldiez));
        listItems.add(new EntidadAnimales(R.drawable.eveinte,"vegeta", R.drawable.elveinte));

        return listItems;
    }
}

