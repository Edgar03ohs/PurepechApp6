package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.purepechapp6.traducciones.AnimalesActivity;
import com.example.purepechapp6.traducciones.CamposObActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.example.purepechapp.conjuntos.ListaAnimales;

public class ConjuntosActivity extends AppCompatActivity {

    private CardView animalescard;
    private CardView camposcard, cuerpocard, numeroscard, verboscard, frutascard;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjuntos);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //La opcion seleccionada del bottom navigation bar
        bottomNavigationView.setSelectedItemId(R.id.aprender);

        //ir a la actividad correspondiente seleccionada
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.aprender:
                        return true;
                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(),PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.informacion:
                        startActivity(new Intent(getApplicationContext(),InformacionActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //definiendo cards

        animalescard = findViewById(R.id.cardViewAnimales);
        camposcard = findViewById(R.id.cardViewCampo);
        cuerpocard = findViewById(R.id.cardViewCuerpo);
        numeroscard = findViewById(R.id.cardViewNumeros);
        verboscard = findViewById(R.id.cardViewVerbos);
        frutascard = findViewById(R.id.cardViewFrutas);

        animalescard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, AnimalesActivity.class);
                startActivity(intent);
            }
        });
        camposcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, CamposObActivity.class);
                startActivity(intent);
            }
        });
        cuerpocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, AnimalesActivity.class);
                startActivity(intent);
            }
        });
        numeroscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, AnimalesActivity.class);
                startActivity(intent);
            }
        });
        verboscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, AnimalesActivity.class);
                startActivity(intent);
            }
        });
        frutascard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, AnimalesActivity.class);
                startActivity(intent);
            }
        });

    }
}
