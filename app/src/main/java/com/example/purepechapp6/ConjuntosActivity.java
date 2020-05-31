package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.example.purepechapp.conjuntos.ListaAnimales;

public class ConjuntosActivity extends AppCompatActivity {

    private CardView animalescard;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjuntos);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set perfil selected
        bottomNavigationView.setSelectedItemId(R.id.aprender);

        //Perform ItemSelected
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
                }
                return false;
            }
        });

        //definiendo cards

        animalescard = findViewById(R.id.cardViewAnimales);

        animalescard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConjuntosActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
