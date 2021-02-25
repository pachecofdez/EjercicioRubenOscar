package com.opacheco.ejerciciorubenoscar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario;
    EditText etPassword;
    Button btnRegistrar;
    Button btnIniciarSesion;
    String nombreUsuario;
    String passwordUsuario;
    SharedPreferences sp;
    Button btnCamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnCamara = findViewById(R.id.btnCamara);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.getItemId();
        if (R.id.itemOscar == item.getItemId()){
            Toast.makeText(this, "Soy " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (R.id.itemDavid == item.getItemId()){
            Toast.makeText(this, "Soy " + item.getTitle(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Soy " + item.getTitle(), Toast.LENGTH_SHORT).show();

        }

        return true;
    }

    public void abrirCamara (View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);}
    }

    public void registrar (View view) {

        nombreUsuario = etUsuario.getText().toString();
        passwordUsuario = etPassword.getText().toString();

        if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
            Toast.makeText(this, "No se puede registrar sin email o password", Toast.LENGTH_SHORT).show();
        }

        sp = getSharedPreferences("registros", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(nombreUsuario, passwordUsuario);
        editor.commit();


    }


    public void iniciarSesion (View view){

        nombreUsuario = etUsuario.getText().toString();
        passwordUsuario = etPassword.getText().toString();

        if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
            Toast.makeText(this, "No se puede iniciar sesion sin email o password", Toast.LENGTH_SHORT).show();
        }

        sp = getSharedPreferences("registros", Context.MODE_PRIVATE);
        String passwordCorrecta = sp.getString(nombreUsuario, null);

        if (passwordCorrecta.equals(passwordUsuario)){
            Intent it = new Intent(this, Inicio.class);
            it.putExtra("usuario", nombreUsuario);
            startActivity(it);
        }

    }


}