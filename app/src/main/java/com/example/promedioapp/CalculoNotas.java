package com.example.promedioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CalculoNotas extends AppCompatActivity {

    private EditText notauno;
    private EditText notados;
    private EditText notatres;
    private EditText notacuatro;
    private EditText notacinco;
    private Button botoncalcular;
    Float notafinal;
    private ConstraintLayout fondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_notas);

        String nombreUser = getIntent().getExtras().getString("nombreUser");

        notauno = findViewById(R.id.notauno);
        notados = findViewById(R.id.notados);
        notatres = findViewById(R.id.notatres);
        notacuatro = findViewById(R.id.notacuatro);
        notacinco = findViewById(R.id.notacinco);
        botoncalcular = findViewById(R.id.botoncalcular);
        fondo = findViewById(R.id.fondo);

        String colorfondo = getSharedPreferences("configcolor", MODE_PRIVATE).getString("codigocolor", "#ffffff");
        fondo.setBackgroundColor(Color.parseColor(colorfondo));


        botoncalcular.setOnClickListener(
                v -> {

                    calculoNota();

                    String notaenviada = ""+notafinal;
                    Intent i = new Intent(this,Resultado.class);
                    i.putExtra("nombreUser",nombreUser);
                    i.putExtra("notaenviada",notaenviada);

                    startActivity(i);
                    finish();

                }
        );


    }

    private void calculoNota() {

        Float n1 = Float.parseFloat(notauno.getText().toString());
        Float n2 = Float.parseFloat(notados.getText().toString());
        Float n3 = Float.parseFloat(notatres.getText().toString());
        Float n4 = Float.parseFloat(notacuatro.getText().toString());
        Float n5 = Float.parseFloat(notacinco.getText().toString());

        notafinal = ((n1+n2+n3+n4+n5)/5);
    }
}