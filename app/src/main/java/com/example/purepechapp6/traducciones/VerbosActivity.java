package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class VerbosActivity extends AppCompatActivity {
    //Se crea una listView y el adaptador
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbos);

        lvAnimales = findViewById(R.id.listView_ListaVerbos);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    //Se agregan los archivos que serán mostrados en el arrayList de verbos

    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.fcomer,"vegeta", R.drawable.flcmer));
        listItems.add(new EntidadAnimales(R.drawable.fcorrer,"vegeta", R.drawable.flcorrer));
        listItems.add(new EntidadAnimales(R.drawable.fjugar,"vegeta", R.drawable.fljugar));
        listItems.add(new EntidadAnimales(R.drawable.fsaludar,"vegeta", R.drawable.flsaludar));
        listItems.add(new EntidadAnimales(R.drawable.fver,"vegeta", R.drawable.flver));


        return listItems;
    }
}

