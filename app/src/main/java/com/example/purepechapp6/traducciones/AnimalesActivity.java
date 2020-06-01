package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class AnimalesActivity extends AppCompatActivity {
    //Se crea una listView y el adaptador
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        lvAnimales = findViewById(R.id.listView_ListaAnimales);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    //Se agregan los archivos que serán mostrados en el arrayList


    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.gato,"vegeta", R.drawable.letra_gato));
        listItems.add(new EntidadAnimales(R.drawable.perro,"vegeta", R.drawable.letra_perro));
        listItems.add(new EntidadAnimales(R.drawable.gallina,"vegeta", R.drawable.letra_gallina));
        listItems.add(new EntidadAnimales(R.drawable.ardilla,"vegeta", R.drawable.letra_ardilla));
        listItems.add(new EntidadAnimales(R.drawable.mariposa,"vegeta", R.drawable.letra_mariposa));


        return listItems;
    }
}
