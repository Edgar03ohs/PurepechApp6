package com.example.purepechapp6.traducciones;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.purepechapp6.R;

import java.util.ArrayList;

public class CamposObActivity extends AppCompatActivity {
    //Se crea una listView y el adaptador
    private ListView lvAnimales;
    private AdaptadorAnimales adaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campos);

        lvAnimales = findViewById(R.id.listView_ListaCampo);
        adaptador = new AdaptadorAnimales(this, GetArrayItems());
        lvAnimales.setAdapter(adaptador);
    }

    //Se agregan los archivos que serán mostrados en el arrayList de los objetos de campo

    private ArrayList<EntidadAnimales> GetArrayItems(){
        ArrayList<EntidadAnimales> listItems = new ArrayList<>();
        listItems.add(new EntidadAnimales(R.drawable.carar,"vegeta", R.drawable.clarar));
        listItems.add(new EntidadAnimales(R.drawable.ccampesino,"vegeta", R.drawable.clcampesino));
        listItems.add(new EntidadAnimales(R.drawable.ccosecha,"vegeta", R.drawable.clcosecha));
        listItems.add(new EntidadAnimales(R.drawable.cmilpa,"vegeta", R.drawable.clmilpa));
        listItems.add(new EntidadAnimales(R.drawable.csembrar,"vegeta", R.drawable.clsembrar));


        return listItems;
    }
}
