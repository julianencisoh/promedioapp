package com.example.promedioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button botonconfig;
    private EditText casillanombre;
    private Button botoncontinuar;
    private TextView texto;
    private ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     botonconfig = findViewById(R.id.botonconfig);
     casillanombre = findViewById(R.id.casillanombre);
     botoncontinuar = findViewById(R.id.botoncontinuar);
     texto = findViewById(R.id.texto);
     fondo = findViewById(R.id.fondo);

     String colorfondo = getSharedPreferences("configcolor", MODE_PRIVATE).getString("codigocolor", "#ffffff");
     fondo.setBackgroundColor(Color.parseColor(colorfondo));




     botonconfig.setOnClickListener(
             v -> {

                 Intent i = new Intent(this, PantallaColorActivity.class);

                 startActivity(i);
             }
             );


     botoncontinuar.setOnClickListener(
             v -> {
                 String nombreUser = casillanombre.getText().toString();
                 Intent i = new Intent(this, CalculoNotas.class);
                 i.putExtra("nombreUser",nombreUser);

                 startActivity(i);
             }

             );



    }
}