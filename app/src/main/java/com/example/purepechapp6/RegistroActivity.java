package com.example.purepechapp6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistroActivity extends AppCompatActivity {
    Button btnCrearCuenta;
    EditText edtUsuarioReg;
    EditText edtContraseñaReg;
    EditText edtConfContra;
    EditText edtCorreo;

    String usuario;
    String correo;
    String contraseña;
    int puntos = 0;

    //Agregamos atributo mAuth para administrar el registro de un nuevo usuario
    private FirebaseAuth mAuth;

    //Instancia de la base de datos de Firestore
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Instancia del objeto mAuth
        mAuth = FirebaseAuth.getInstance();

        //Relacionando objetos Java con los objetos XML
        edtUsuarioReg = findViewById(R.id.edtUsuarioReg);
        edtContraseñaReg = findViewById(R.id.edtContraseñaReg);
        edtConfContra = findViewById(R.id.edtConfContra);
        edtCorreo = findViewById(R.id.edtCorreo);
        db = FirebaseFirestore.getInstance();
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = edtUsuarioReg.getText().toString();
                String contraseña = edtContraseñaReg.getText().toString();
                String correo = edtCorreo.getText().toString();
                String confContra = edtConfContra.getText().toString();

                if(confContra.length() ==0){
                    Toast.makeText(getApplicationContext(), "Debes confirmar la contraseña", Toast.LENGTH_SHORT).show();
                }
                if(contraseña.length() ==0){
                    Toast.makeText(getApplicationContext(), "Debes ingresar una contraseña", Toast.LENGTH_SHORT).show();
                }
                if(correo.length() ==0){
                    Toast.makeText(getApplicationContext(), "Debes ingresar un Correo", Toast.LENGTH_SHORT).show();
                }
                if(usuario.length() ==  0 )
                {
                    Toast.makeText(getApplicationContext(), "Debes ingresar un Nombre", Toast.LENGTH_SHORT).show();
                }
                if( usuario.length() != 0 && correo.length() !=0 && contraseña.length() !=0 &&  confContra.length()!=0)
                {
                    if(contraseña.length() >=6 )
                    {
                        if (!confContra.equals(contraseña)) {
                            Toast.makeText(getApplicationContext(), "Las contraseñas deben coincidir", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Se está registrando al usuario", Toast.LENGTH_SHORT).show();
                            agregarElementos();
                            crearUsuario(correo, contraseña);

                            /*
                            Toast.makeText(getApplicationContext(), "Te has registrado con éxito, " + usuario, Toast.LENGTH_SHORT).show();
                            Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                            intentLogin.putExtra(getString(R.string.usuario), usuario);
                            intentLogin.putExtra(getString(R.string.contrase_a), contraseña);
                            startActivity(intentLogin);
                            finish();
                             */
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Contraseña demasiado corta", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }

    private void agregarElementos() {
        usuario = edtUsuarioReg.getText().toString();
        contraseña = edtContraseñaReg.getText().toString();
        correo = edtCorreo.getText().toString();
        Usuario miUsuario = new Usuario(usuario, correo, contraseña, puntos);
        db.collection("Usuarios").document().set(miUsuario);
        mAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "El registro fue exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Hubo un problema en el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void crearUsuario(String correo, String contraseña) {
        mAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "El registro fue exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Hubo un problema en el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
