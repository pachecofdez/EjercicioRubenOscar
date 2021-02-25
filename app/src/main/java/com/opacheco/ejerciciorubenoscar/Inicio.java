package com.opacheco.ejerciciorubenoscar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");

        Toast.makeText(this, usuario, Toast.LENGTH_SHORT).show();


    }


}