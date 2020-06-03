package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.purepechapp6.Ejercicios.EjerciciosActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosCampoActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosCuerpoActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosFrutaActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosNumerosActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosTodoActivity;
import com.example.purepechapp6.Ejercicios.EjerciciosVerbosActivity;
import com.example.purepechapp6.traducciones.AnimalesActivity;
import com.example.purepechapp6.traducciones.CamposObActivity;
import com.example.purepechapp6.traducciones.CuerpoActivity;
import com.example.purepechapp6.traducciones.NumerosActivity;
import com.example.purepechapp6.traducciones.VerbosActivity;
import com.example.purepechapp6.traducciones.VerduraActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SeleccionarActivity extends AppCompatActivity {

    private CardView animalescard;
    private CardView camposcard, cuerpocard, numeroscard, verboscard, frutascard;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //La opcion seleccionada del bottom navigation bar
        bottomNavigationView.setSelectedItemId(R.id.opEjercicios);

        //ir a la actividad correspondiente seleccionada
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.opEjercicios:
                        return true;
                    case R.id.opPerfil:
                        startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.opInformacion:
                        startActivity(new Intent(getApplicationContext(), InformacionActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.opAprender:
                        startActivity(new Intent(getApplicationContext(), ConjuntosActivity.class));
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
        Button btnDeToto = findViewById(R.id.btnDeTodo);

        //activación de las actividades subsecuentes a las card View

        animalescard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosActivity.class);
                startActivity(intent);
            }
        });
        camposcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosCampoActivity.class);
                startActivity(intent);
            }
        });
        cuerpocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosCuerpoActivity.class);
                startActivity(intent);
            }
        });
        numeroscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosNumerosActivity.class);
                startActivity(intent);
            }
        });
        verboscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosVerbosActivity.class);
                startActivity(intent);
            }
        });
        frutascard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosFrutaActivity.class);
                startActivity(intent);
            }
        });
        btnDeToto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActivity.this, EjerciciosTodoActivity.class);
                startActivity(intent);
            }
        });

    }
}
