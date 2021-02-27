package com.example.promedioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView textohola;
    private TextView notacalculada;
    private Button botonotravez;
    private ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombre= getIntent().getExtras().getString("nombreUser");
        String notaenviada = getIntent().getExtras().getString("notaenviada");

     textohola = findViewById(R.id.textohola);
     notacalculada = findViewById(R.id.notacalculada);
     botonotravez = findViewById(R.id.botonotravez);
     fondo = findViewById(R.id.fondo);

        String colorfondo = getSharedPreferences("configcolor", MODE_PRIVATE).getString("codigocolor", "#ffffff");
        fondo.setBackgroundColor(Color.parseColor(colorfondo));

     textohola.setText("hola "+nombre+". Tu nota final es de:");
     notacalculada.setText(notaenviada);

     botonotravez.setOnClickListener(
             v -> {

                 Intent i = new Intent(this, MainActivity.class);

                 startActivity(i);
                 finish();

             }
     );


    }
}