package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextView txtEsloganInicio;
    Button btnStart;

    //Agregamos atributo mAuth para administrar el registro de un nuevo usuario
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        //Relacionando objetos Java con los objetos XML
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"¡Comenzamos!",Toast.LENGTH_SHORT).show();
                Intent intentComenzar = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intentComenzar);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, PerfilActivity.class));
            finish();
        }
    }
}
