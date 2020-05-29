package com.example.purepechapp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PerfilActivity extends AppCompatActivity {
    //Referencia a los elementos del .xml
    Button btnCerrarCesion;
    TextView txtusUarioPerfil;
    TextView txtusPuntosPerfil;

    //objeto tipo firebaseAuth
    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnCerrarCesion = findViewById(R.id.btnCerrarSesion);
        txtusUarioPerfil = findViewById(R.id.txtUsuarioPerfil);
        txtusPuntosPerfil = findViewById(R.id.txtPuntosPerfil);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        btnCerrarCesion.setOnClickListener(onClickCerrarSesion);
/*
        FirebaseUser miUsuario= mAuth.getCurrentUser();
        txtusUarioPerfil.setText(miUsuario.getDisplayName());
        String id = miUsuario.getUid();
        db.collection("Usuarios").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Long aux = documentSnapshot.getLong("Puntos");
                txtusPuntosPerfil.setText(aux.toString());
            }
        });*/

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
