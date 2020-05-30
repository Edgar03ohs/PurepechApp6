package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

//import com.example.purepechapp.conjuntos.ListaAnimales;

public class ConjuntosActivity extends AppCompatActivity {

    private CardView animalescard;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjuntos);

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
