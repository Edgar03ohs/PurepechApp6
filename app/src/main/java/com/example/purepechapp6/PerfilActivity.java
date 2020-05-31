package com.example.purepechapp6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PerfilActivity extends AppCompatActivity {
    //Referencia a los elementos del .xml
    Button btnCerrarCesion;
    TextView txtUsuarioPerfil;
    TextView txtPuntosPerfil;

    String usuario;
    int puntos;

    //Agregamos atributo mAuth para administrar el registro de un nuevo usuario
    private FirebaseAuth mAuth;

    //Instancia de la base de datos de Firestore
    FirebaseFirestore db;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //La opcion seleccionada del bottom navigation bar
        bottomNavigationView.setSelectedItemId(R.id.perfil);

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
                        return true;
                    case R.id.informacion:
                        startActivity(new Intent(getApplicationContext(),InformacionActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //Relacionando objetos Java con los objetos XML
        btnCerrarCesion = findViewById(R.id.btnCerrarSesion);
        txtUsuarioPerfil = findViewById(R.id.txtUsuarioPerfil);
        txtPuntosPerfil = findViewById(R.id.txtPuntosPerfil);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnCerrarCesion.setOnClickListener(onClickCerrarSesion);

        obtenerInformacion();
/*
        btnIniciarActividad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this,"¡Comenzamos!",Toast.LENGTH_SHORT).show();
                Intent intentComenzar = new Intent(getApplicationContext(),ConjuntosActivity.class);
                startActivity(intentComenzar);
            }
        });*/
    }

    private void obtenerInformacion() {
        final String id = mAuth.getCurrentUser().getUid();
        db.collection("Usuarios").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                usuario = documentSnapshot.getString("usuario");
                //Toast como este son para verificar que se haya obtenido bien el dato durante las pruebas
                //Toast.makeText(PerfilActivity.this, "Bienvenido, "+ usuario, Toast.LENGTH_SHORT).show();
                Long aux  = documentSnapshot.getLong ("puntos");

                //Toast como este son para verificar que se haya obtenido bien el dato durante las pruebas
                //Toast.makeText(PerfilActivity.this, ""+ puntos, Toast.LENGTH_SHORT).show();

                puntos = aux.intValue();
                txtUsuarioPerfil.setText(usuario);
                txtPuntosPerfil.setText(""+ puntos);
            }
        });
    }




    View.OnClickListener onClickCerrarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mAuth.signOut();
            Intent btnCerrarSesion = new Intent(PerfilActivity.this, MainActivity.class);
            PerfilActivity.this.startActivity(btnCerrarSesion);
            finish();
        }
    };
}
