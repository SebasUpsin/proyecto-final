package com.example.sebas.seasqueensean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExamenPrimerModulo extends AppCompatActivity {

    private PreguntasExamenPrimerModulo preguntasExamenPrimerModulo = new PreguntasExamenPrimerModulo();

    private Button opcion1;
    private Button opcion2;
    private Button opcion3;

    private TextView pregunta;
    private TextView puntaje;

    private ImageView anexoPregunta;

    private String preguntaTraida;
    private int numeroPregunta = 0;
    private int puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_primer_modulo);

        opcion1 = (Button) findViewById(R.id.btnOpcion1);
        opcion2 = (Button) findViewById(R.id.btnOpcion2);
        opcion3 = (Button) findViewById(R.id.btnOpcion3);

        pregunta = (TextView) findViewById(R.id.pregunta);
        puntaje = (TextView) findViewById(R.id.puntuacion);

        anexoPregunta = (ImageView) findViewById(R.id.imagenPregunta);

        actualizarPreguntas();

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (opcion1.getText().equals(preguntaTraida)){
                    puntuacion = puntuacion + 20;
                    puntaje.setText(""+puntuacion);
                    actualizarPreguntas();

                    Toast.makeText(ExamenPrimerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenPrimerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    actualizarPreguntas();
                }

            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (opcion2.getText().equals(preguntaTraida)){
                    puntuacion = puntuacion + 20;
                    puntaje.setText(""+puntuacion);
                    actualizarPreguntas();

                    Toast.makeText(ExamenPrimerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenPrimerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    actualizarPreguntas();
                }

            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (opcion3.getText().equals(preguntaTraida)){
                    puntuacion = puntuacion + 20;
                    puntaje.setText(""+puntuacion);
                    actualizarPreguntas();

                    Toast.makeText(ExamenPrimerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenPrimerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    actualizarPreguntas();
                }

            }
        });

    }

    public void actualizarPreguntas(){

        if (numeroPregunta >= 5){
            finish();
        }else{

            switch (numeroPregunta){
                case 0:
                    anexoPregunta.setImageResource(R.drawable.numero0);
                    break;
                case 1:
                    anexoPregunta.setImageResource(R.drawable.letrae);
                    break;
                case 2:
                    anexoPregunta.setImageResource(R.drawable.numero3);
                    break;
                case 3:
                    anexoPregunta.setImageResource(R.drawable.letrau);
                    break;
                case 4:
                    anexoPregunta.setImageResource(R.drawable.numero9);
                    break;
            }

            pregunta.setText(preguntasExamenPrimerModulo.getPreguntas(numeroPregunta));
            opcion1.setText(preguntasExamenPrimerModulo.getOpciones(numeroPregunta));
            opcion2.setText(preguntasExamenPrimerModulo.getOpciones2(numeroPregunta));
            opcion3.setText(preguntasExamenPrimerModulo.getOpciones3(numeroPregunta));

            preguntaTraida = preguntasExamenPrimerModulo.getRespuestaCorrecta(numeroPregunta);
            numeroPregunta++;
        }
    }
}
