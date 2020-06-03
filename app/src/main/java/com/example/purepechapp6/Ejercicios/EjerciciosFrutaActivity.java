package com.example.purepechapp6.Ejercicios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.purepechapp6.ConjuntosActivity;
import com.example.purepechapp6.InformacionActivity;
import com.example.purepechapp6.PerfilActivity;
import com.example.purepechapp6.R;
import com.example.purepechapp6.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class EjerciciosFrutaActivity extends AppCompatActivity implements View.OnClickListener{

    String usuario;
    String correo;
    String contraseña;
    String id;
    int puntos;
    int temporal;

    private int [] mEjerciciosImg = {R.drawable.hchile, R.drawable.helote, R.drawable.hfrijol, R.drawable.hmaiz, R.drawable.hnopal};
    private String [] mEjerciciosStr = {"k´auasï", "tiriapu", "t´atsïni", "tsíri", "parhe" };

    private int mPosicionActual = -1;

    //Agregamos atributo mAuth para administrar el registro de un nuevo usuario
    private FirebaseAuth mAuth;

    //Instancia de la base de datos de Firestore
    FirebaseFirestore db;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_fruta);

        //Relacionando los java con los xml
        Button btnOpcion1 = findViewById(R.id.btnOpcion1);
        Button btnOpcion2 = findViewById(R.id.btnOpcion2);
        Button btnOpcion3 = findViewById(R.id.btnOpcion3);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnOpcion1.setOnClickListener(this);
        btnOpcion2.setOnClickListener(this);
        btnOpcion3.setOnClickListener(this);

        cambiarEjercicio();

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
    }

    private void cambiarEjercicio() {
        Button btnOpcion1 = findViewById(R.id.btnOpcion1);
        Button btnOpcion2 = findViewById(R.id.btnOpcion2);
        Button btnOpcion3 = findViewById(R.id.btnOpcion3);
        ImageView Imagen = findViewById(R.id.imgEjerAnimal);
        int aux[] = new int[3];
        //Poniendo una imagen aleatoria distinta a la anterior

        Random numeroImagen = new Random();


        temporal = numeroImagen.nextInt(3);

        //do {
        aux[0] = numeroImagen.nextInt(5);
        //}while (mPosicionActual == aux[0]);

        for (int i=1; i<3; i++){
            aux[i] = numeroImagen.nextInt(5);
            for (int j=0; j<i; j++){
                if(aux[i]==aux[j]){
                    i--;
                }
            }
        }

        do {if(aux[temporal]==mPosicionActual){
            temporal=numeroImagen.nextInt(3);
        }

        }while (mPosicionActual==aux[temporal]);

        mPosicionActual = aux[temporal];

        //dando 3 opciones con solo una correcta

        btnOpcion1.setText(mEjerciciosStr[aux[0]]);
        btnOpcion2.setText(mEjerciciosStr[aux[1]]);
        btnOpcion3.setText(mEjerciciosStr[aux[2]]);

        Imagen.setImageResource(mEjerciciosImg[aux[temporal]]);

    }

    //Suma de puntos

    private void obtenerInformacion() {

        final String id = mAuth.getCurrentUser().getUid();
        db.collection("Usuarios").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                usuario = documentSnapshot.getString("usuario");
                correo = documentSnapshot.getString("correo");
                contraseña = documentSnapshot.getString("contraseña");
                Long aux  = documentSnapshot.getLong ("puntos");
                puntos = aux.intValue()+1;
                final Usuario miUsuario = new Usuario(usuario, correo, contraseña, puntos);
                db.collection("Usuarios").document(id).set(miUsuario).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Correcto.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOpcion1:
                if (temporal==0){
                    obtenerInformacion();
                } else {
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                }
                cambiarEjercicio();
                break;
            case R.id.btnOpcion2:
                if (temporal==1){
                    obtenerInformacion();
                } else {
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                }
                cambiarEjercicio();
                break;
            case R.id.btnOpcion3:
                if (temporal==2){
                    obtenerInformacion();
                } else {
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                }
                cambiarEjercicio();
                break;
        }

    }
}


