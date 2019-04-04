package com.example.sebas.seasqueensean;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import DB.CreateUsuario;
import DB.Usuario;

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
    private int contador = 0;

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    private int[] preguntasSalidas = new int[5];

    private int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_primer_modulo);

        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Collections.shuffle(numbers);

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

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ExamenPrimerModulo.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void actualizarPreguntas(){

        if (contador >= 5){


            if (puntuacion>=80){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¡Felicidades obtuviste una calificacion aprovatoria de "+puntuacion+" puntos!");
                builder.setTitle(Html.fromHtml("<font color='#31B8EE'>En HoraBuena</font>"));
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*SE ACTUALIZA EL STATUS DEL PROGRESO A 3*/
                        CreateUsuario source = new CreateUsuario(ExamenPrimerModulo.this);
                        source.openDataBase();
                        Cursor c = source.traer();
                        int colum4=c.getColumnIndex("progreso");
                        int colum8=c.getColumnIndex("puntuacionmodulouno");
                        c.moveToFirst();
                        int progresoDB = Integer.parseInt(c.getString(colum4));
                        int puntuacionModuloUnoDB = Integer.parseInt(c.getString(colum8));
                        Log.wtf("ProgresoDb",""+progresoDB);
                        Log.wtf("EXAMEN1Db",""+puntuacionModuloUnoDB);


                        if (progresoDB == 2){
                            Usuario usuario = new Usuario();
                            usuario.setProgreso(3);
                            source.updateProgreso(usuario, 1);
                        }

                        if (puntuacionModuloUnoDB < puntuacion){
                            Usuario usuario = new Usuario();
                            usuario.setPuntuacionModuloUno(puntuacion);
                            source.updateExamen1(usuario,1);
                        }

                        source.close();
                        /*SE TERMINA LA ACTUALIZACION*/

                        Intent intent = new Intent(ExamenPrimerModulo.this, MainMenuActivity.class);
                        startActivity(intent);
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

                        CreateUsuario source = new CreateUsuario(ExamenPrimerModulo.this);

                        source.openDataBase();
                        Cursor c = source.traer();
                        int colum4=c.getColumnIndex("progreso");
                        int colum8=c.getColumnIndex("puntuacionmodulouno");
                        c.moveToFirst();
                        int progresoDB = Integer.parseInt(c.getString(colum4));
                        int puntuacionModuloUnoDB = Integer.parseInt(c.getString(colum8));
                        Log.wtf("ProgresoDb",""+progresoDB);
                        Log.wtf("EXAMEN1Db",""+puntuacionModuloUnoDB);

                        if (puntuacionModuloUnoDB < puntuacion){
                            Usuario usuario = new Usuario();
                            usuario.setPuntuacionModuloUno(puntuacion);
                            source.updateExamen1(usuario,1);
                        }


                        source.close();

                        Intent intent = new Intent(ExamenPrimerModulo.this, MainMenuActivity.class);
                        startActivity(intent);
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



            /*Random random = new Random();
            numeroPregunta=(random.nextInt(6));
            preguntasSalidas[contador]=numeroPregunta;
            for (x=0;x<preguntasSalidas.length;x++){
                   // Log.wtf("long",""+preguntasSalidas.length);
                    Log.wtf("valorx",""+x);
                if (preguntasSalidas[x] == numeroPregunta){
                    numeroPregunta=(random.nextInt(5));
                    preguntasSalidas[x]=numeroPregunta;
                    x=0;
                }
            }*/



            numeroPregunta=numbers.get(contador);

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
            //numeroPregunta++;
            contador++;
        }
    }
}
