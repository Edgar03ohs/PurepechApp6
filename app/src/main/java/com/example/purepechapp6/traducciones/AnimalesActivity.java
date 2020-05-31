package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class AnimalesActivity extends AppCompatActivity {
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

    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));
        listItems.add(new EntidadAnimales(R.drawable.image_campo,"vegeta", R.drawable.background_uno));

        return listItems;
    }
}
