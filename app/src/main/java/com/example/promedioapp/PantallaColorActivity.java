package com.example.promedioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class PantallaColorActivity extends AppCompatActivity {

    private Button botonazul;
    private Button botonblanco;
    private Button botonnegro;
    private ConstraintLayout fondo;
    private String codigocolor = "#ffffff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_color);

        botonazul = findViewById(R.id.botonazul);
        botonblanco = findViewById(R.id.botonblanco);
        botonnegro = findViewById(R.id.botonnegro);
        fondo = findViewById(R.id.fondo);

        //fondo.setBackgroundColor(Color.parseColor(codigocolor));
        String colorfondo = getSharedPreferences("configcolor", MODE_PRIVATE).getString("codigocolor", "#ffffff");
        fondo.setBackgroundColor(Color.parseColor(colorfondo));


        botonazul.setOnClickListener(
                v -> {

                    codigocolor = "#abdefa";
                   // fondo.setBackgroundColor(Color.parseColor(codigocolor));
                    SharedPreferences preferencescolor = getSharedPreferences("configcolor",MODE_PRIVATE);
                    preferencescolor.edit().putString("codigocolor",codigocolor).apply();

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();

                }
        );

        botonblanco.setOnClickListener(
                v -> {

                    codigocolor = "#ffffff";
                  //  fondo.setBackgroundColor(Color.parseColor(codigocolor));
                    SharedPreferences preferencescolor = getSharedPreferences("configcolor",MODE_PRIVATE);
                    preferencescolor.edit().putString("codigocolor",codigocolor).apply();

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
        );

        botonnegro.setOnClickListener(
                v -> {

                    codigocolor = "#000000";
                   // fondo.setBackgroundColor(Color.parseColor(codigocolor));
                    SharedPreferences preferencescolor = getSharedPreferences("configcolor",MODE_PRIVATE);
                    preferencescolor.edit().putString("codigocolor",codigocolor).apply();

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
        );


    }
}