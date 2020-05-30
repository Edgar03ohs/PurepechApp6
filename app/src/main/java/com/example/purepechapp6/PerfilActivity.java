package com.example.purepechapp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PerfilActivity extends AppCompatActivity {
    //Referencia a los elementos del .xml
    Button btnCerrarCesion;
    Button btnIniciarActividad;
    TextView txtUsuarioPerfil;
    TextView txtPuntosPerfil;

    String usuario;
    int puntos;
    //objeto tipo firebaseAuth
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnCerrarCesion = findViewById(R.id.btnCerrarSesion);
        btnIniciarActividad = findViewById(R.id.btnIniciarActiv);
        txtUsuarioPerfil = findViewById(R.id.txtUsuarioPerfil);
        txtPuntosPerfil = findViewById(R.id.txtPuntosPerfil);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnCerrarCesion.setOnClickListener(onClickCerrarSesion);

        obtenerInformacion();

        btnIniciarActividad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this,"¡Comenzamos!",Toast.LENGTH_SHORT).show();
                Intent intentComenzar = new Intent(getApplicationContext(),ConjuntosActivity.class);
                startActivity(intentComenzar);
            }
        });
    }

    private void obtenerInformacion() {
        final String id = mAuth.getCurrentUser().getUid();
        db.collection("Usuarios").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                usuario = documentSnapshot.getString("usuario");
                Toast.makeText(PerfilActivity.this, ""+ usuario, Toast.LENGTH_SHORT).show();
                Long aux  = documentSnapshot.getLong ("puntos");
                Toast.makeText(PerfilActivity.this, ""+ puntos, Toast.LENGTH_SHORT).show();
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
