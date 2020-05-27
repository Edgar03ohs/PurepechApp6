package com.example.purepechapp6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistrarse;

    EditText edtUsuarioLog;
    EditText edtContraseñaLog;

    String UsuarioLog;
    String ContraseñaLog;

    String usuario;
    String password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuarioLog = findViewById(R.id.edtUsuarioLog);
        edtContraseñaLog = findViewById(R.id.edtContraseñaLog);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnIniciarSesion.setOnClickListener(onClickIniciarSesion);
        btnRegistrarse.setOnClickListener(onClikRegistrarse);

    }

    View.OnClickListener onClickIniciarSesion = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            UsuarioLog = edtUsuarioLog.getText().toString();
            ContraseñaLog = edtContraseñaLog.getText().toString();
            try {
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
            }
            if (ContraseñaLog.length() ==0 && UsuarioLog.length() != 0){
                Toast.makeText(getApplicationContext(), "Debes inrgesar tu contraseña", Toast.LENGTH_SHORT).show();
            }
            if(UsuarioLog.length() == 0 && ContraseñaLog.length() !=0){
                Toast.makeText(getApplicationContext(), "Debes ingresar un nombre de usuario", Toast.LENGTH_SHORT).show();
            }

            if(UsuarioLog.length() == 0 && ContraseñaLog.length() ==0)
            {
                Toast.makeText(getApplicationContext(), "Los campos están vacíos", Toast.LENGTH_SHORT).show();
            }
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
        public void onClick(View v) {
            Intent btnRegistrarse = new Intent(LoginActivity.this, RegistroActivity.class);
            LoginActivity.this.startActivity(btnRegistrarse);
            finish();
        }
    };

    public  void BuscarUsuario() throws InterruptedException {

        for(int i=0; i< 15; i++)
        {
            Thread.sleep(1000);
            Log.d("Segundos","Tiempo de busqueda: " +i +"[s]" );

        }

    }
}
