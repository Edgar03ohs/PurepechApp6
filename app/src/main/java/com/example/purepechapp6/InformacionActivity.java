package com.example.purepechapp6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InformacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //La opcion seleccionada del bottom navigation bar
        bottomNavigationView.setSelectedItemId(R.id.informacion);

        //ir a la actividad correspondiente seleccionada
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.aprender:
                        startActivity(new Intent(getApplicationContext(),ConjuntosActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(),PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.informacion:
                        return true;
                }
                return false;
            }
        });
    }
}
