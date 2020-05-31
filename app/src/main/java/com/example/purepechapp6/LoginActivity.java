package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistrarse;

    EditText edtUsuarioLog;
    EditText edtContraseñaLog;
    EditText edtCorreoLog;

    String UsuarioLog;
    String usuario;
    String ContraseñaLog;
    String CorreoLog;
//era para el metodo que no incluis firebase
    /*
    String usuario;
    String password;
    */

    //Agregamos atributo mAuth para administrar el registro de un nuevo usuario
    private FirebaseAuth mAuth;

    //Instancia de la base de datos de Firestore
    FirebaseFirestore db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Relacionando objetos Java con los objetos XML
        edtCorreoLog = findViewById(R.id.edtCorreoLog);
        edtContraseñaLog = findViewById(R.id.edtContraseñaLog);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnIniciarSesion.setOnClickListener(onClickIniciarSesion);
        btnRegistrarse.setOnClickListener(onClikRegistrarse);

    }

    View.OnClickListener onClickIniciarSesion = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            CorreoLog = edtCorreoLog.getText().toString();
            ContraseñaLog = edtContraseñaLog.getText().toString();

            //era para metodo sin firebase

            /*try {
                Bundle bundleRegistro = getIntent().getExtras();
                usuario = bundleRegistro.getString(getString(R.string.usuario));
                password = bundleRegistro.getString(getString(R.string.contrase_aLog));
            } catch (NullPointerException error)
            {
                Toast.makeText(getApplicationContext(), "Verifica el usuario o crea una cuetna", Toast.LENGTH_SHORT).show();
            }
            if( UsuarioLog.equals(usuario) && ContraseñaLog.equals(password)  )
            {
                Toast.makeText(getApplicationContext(),"Bienvenido, has ingresado correctamente, " + UsuarioLog, Toast.LENGTH_SHORT).show();
            }
            else if( UsuarioLog.equals(usuario) && !ContraseñaLog.equals(password)  )
            {
                Toast.makeText(getApplicationContext(),"Contraseña incorrecta, " + UsuarioLog,Toast.LENGTH_SHORT).show();
            }*/

            //Se verifica que los campos no estén vacíos

            if (ContraseñaLog.length() !=0 && CorreoLog.length() !=0) {
                ingresarExistente();
            }
            else if (ContraseñaLog.length() ==0 && CorreoLog.length() != 0){
                Toast.makeText(getApplicationContext(), "Debes inrgesar tu contraseña", Toast.LENGTH_SHORT).show();
            }
            else if(CorreoLog.length() == 0 && ContraseñaLog.length() !=0){
                Toast.makeText(getApplicationContext(), "Debes ingresar un correo para iniciar sesión", Toast.LENGTH_SHORT).show();
            }
            else if(CorreoLog.length() == 0 && ContraseñaLog.length() ==0)
            {
                Toast.makeText(getApplicationContext(), "Los campos están vacíos", Toast.LENGTH_SHORT).show();
            }
            //Hilo para evitar interrupciones y pueda llevarse a cabo el inicio de seión
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try
                    {
                        BuscarUsuario();
                    }
                    catch (InterruptedException e)
                    {
                        Log.d("error",e.getMessage());
                    }
                    Log.d("Hilo","Hilo Terminado");
                }
            }).start();
        }
    };

    View.OnClickListener onClikRegistrarse = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent btnRegistrarse = new Intent(LoginActivity.this, RegistroActivity.class);
            LoginActivity.this.startActivity(btnRegistrarse);
        }
    };

    //Valida usuario por medio de correo y contraseña
    private void ingresarExistente() {
        ContraseñaLog = edtContraseñaLog.getText().toString();
        CorreoLog = edtCorreoLog.getText().toString();
        mAuth.signInWithEmailAndPassword(CorreoLog, ContraseñaLog).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    /*db.collection("Usuarios").document(mAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            usuario = documentSnapshot.getString("usuario");
                            Toast.makeText(getApplicationContext(),"Bienvenido, has ingresado correctamente, " +  usuario, Toast.LENGTH_SHORT).show();
                            */
                            Intent btnIniciarSesion = new Intent(getApplicationContext(), PerfilActivity.class);
                            LoginActivity.this.startActivity(btnIniciarSesion);
                            finish();
                        //}
                    //});
                }
                else {
                    Toast.makeText(getApplicationContext(), "Falla de autenticación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  void BuscarUsuario() throws InterruptedException {

        for(int i=0; i< 15; i++)
        {
            Thread.sleep(1000);
            Log.d("Segundos","Tiempo de busqueda: " +i +"[s]" );

        }

    }
}
