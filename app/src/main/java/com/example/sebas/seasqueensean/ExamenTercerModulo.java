package com.example.sebas.seasqueensean;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExamenTercerModulo extends AppCompatActivity {


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
        setContentView(R.layout.activity_examen_tercer_modulo);

        opcion1 = (Button) findViewById(R.id.btnOpcion1Modulo3);
        opcion2 = (Button) findViewById(R.id.btnOpcion2Modulo3);
        opcion3 = (Button) findViewById(R.id.btnOpcion3Modulo3);

        pregunta = (TextView) findViewById(R.id.preguntaModulo3);
        puntaje = (TextView) findViewById(R.id.puntuacionModulo3);

        anexoPregunta = (ImageView) findViewById(R.id.imagenPreguntaModulo3);

        actualizarPreguntas();

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (opcion1.getText().equals(preguntaTraida)){
                    puntuacion = puntuacion + 20;
                    puntaje.setText(""+puntuacion);
                    actualizarPreguntas();

                    Toast.makeText(ExamenTercerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenTercerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ExamenTercerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenTercerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ExamenTercerModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenTercerModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    actualizarPreguntas();
                }

            }
        });
    }

    public void actualizarPreguntas(){

        if (numeroPregunta >= 5){


            if (puntuacion>=80){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¡Felicidades obtuviste una calificacion aprovatoria de "+puntuacion+" puntos!");
                builder.setTitle(Html.fromHtml("<font color='#31B8EE'>En HoraBuena</font>"));
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#31B8EE"));
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Lo siento obtuviste una calificacion de "+puntuacion+" puntos");
                builder.setTitle(Html.fromHtml("<font color='#ff0000'>Vuelve a Intentarlo</font>"));
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#ff0000"));
            }



        }else{

            switch (numeroPregunta){
                case 0:
                    anexoPregunta.setImageResource(R.drawable.hola);
                    break;
                case 1:
                    anexoPregunta.setImageResource(R.drawable.palabraporfavor);
                    break;
                case 2:
                    anexoPregunta.setImageResource(R.drawable.palabraadios);
                    break;
                case 3:
                    anexoPregunta.setImageResource(R.drawable.palabragracias);
                    break;
                case 4:
                    anexoPregunta.setImageResource(R.drawable.palabraencantadoconocer);
                    break;
            }

            pregunta.setText(preguntasExamenPrimerModulo.getPreguntas3(numeroPregunta));
            opcion1.setText(preguntasExamenPrimerModulo.getOpcionesModuloTres(numeroPregunta));
            opcion2.setText(preguntasExamenPrimerModulo.getOpcionesModuloTres2(numeroPregunta));
            opcion3.setText(preguntasExamenPrimerModulo.getOpcionesModuloTres3(numeroPregunta));

            preguntaTraida = preguntasExamenPrimerModulo.getRespuestaCorrecta3(numeroPregunta);
            numeroPregunta++;
        }
    }


}
