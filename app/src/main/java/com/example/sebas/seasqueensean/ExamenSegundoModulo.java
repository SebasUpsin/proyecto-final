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

import DB.CreateUsuario;
import DB.Usuario;

public class ExamenSegundoModulo extends AppCompatActivity {

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
        setContentView(R.layout.activity_examen_segundo_modulo);

        opcion1 = (Button) findViewById(R.id.btnOpcion1Modulo2);
        opcion2 = (Button) findViewById(R.id.btnOpcion2Modulo2);
        opcion3 = (Button) findViewById(R.id.btnOpcion3Modulo2);

        pregunta = (TextView) findViewById(R.id.preguntaModulo2);
        puntaje = (TextView) findViewById(R.id.puntuacionModulo2);

        anexoPregunta = (ImageView) findViewById(R.id.imagenPreguntaModulo2);


        actualizarPreguntas();


        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (opcion1.getText().equals(preguntaTraida)){
                    puntuacion = puntuacion + 20;
                    puntaje.setText(""+puntuacion);
                    actualizarPreguntas();

                    Toast.makeText(ExamenSegundoModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenSegundoModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ExamenSegundoModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenSegundoModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ExamenSegundoModulo.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExamenSegundoModulo.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    actualizarPreguntas();
                }

            }
        });

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ExamenSegundoModulo.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
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
                        /*SE ACTUALIZA EL STATUS DEL PROGRESO A 6*/
                        CreateUsuario source = new CreateUsuario(ExamenSegundoModulo.this);
                        source.openDataBase();
                        Cursor c = source.traer();
                        int colum4=c.getColumnIndex("progreso");
                        int colum9=c.getColumnIndex("puntuacionmodulodos");
                        c.moveToFirst();
                        int progresoDB = Integer.parseInt(c.getString(colum4));
                        int puntuacionModuloDosDB = Integer.parseInt(c.getString(colum9));
                        Log.wtf("ProgresoDb",""+progresoDB);
                        Log.wtf("EXAMEN2Db",""+puntuacionModuloDosDB);


                        if (progresoDB == 5){
                            Usuario usuario = new Usuario();
                            usuario.setProgreso(6);
                            source.updateProgreso(usuario, 1);
                        }

                        if (puntuacionModuloDosDB < puntuacion){
                            Usuario usuario = new Usuario();
                            usuario.setPuntuacionModuloDos(puntuacion);
                            source.updateExamen2(usuario,1);
                        }


                        source.close();
                        /*SE TERMINA LA ACTUALIZACION*/

                        Intent intent = new Intent(ExamenSegundoModulo.this, MainMenuActivity.class);
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
                        CreateUsuario source = new CreateUsuario(ExamenSegundoModulo.this);

                        source.openDataBase();
                        Cursor c = source.traer();
                        int colum4=c.getColumnIndex("progreso");
                        int colum9=c.getColumnIndex("puntuacionmodulodos");
                        c.moveToFirst();
                        int progresoDB = Integer.parseInt(c.getString(colum4));
                        int puntuacionModuloDosDB = Integer.parseInt(c.getString(colum9));
                        Log.wtf("ProgresoDb",""+progresoDB);
                        Log.wtf("EXAMEN2Db",""+puntuacionModuloDosDB);


                        if (puntuacionModuloDosDB < puntuacion){
                            Usuario usuario = new Usuario();
                            usuario.setPuntuacionModuloDos(puntuacion);
                            source.updateExamen2(usuario,1);
                        }


                        source.close();

                        Intent intent = new Intent(ExamenSegundoModulo.this, MainMenuActivity.class);
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

            switch (numeroPregunta){
                case 0:
                    anexoPregunta.setImageResource(R.drawable.letaj);
                    break;
                case 1:
                    anexoPregunta.setImageResource(R.drawable.letrah);
                    break;
                case 2:
                    anexoPregunta.setImageResource(R.drawable.letrat);
                    break;
                case 3:
                    anexoPregunta.setImageResource(R.drawable.letrar);
                    break;
                case 4:
                    anexoPregunta.setImageResource(R.drawable.letrax);
                    break;
            }

            pregunta.setText(preguntasExamenPrimerModulo.getPreguntas2(numeroPregunta));
            opcion1.setText(preguntasExamenPrimerModulo.getOpcionesModuloDos(numeroPregunta));
            opcion2.setText(preguntasExamenPrimerModulo.getOpcionesModuloDos2(numeroPregunta));
            opcion3.setText(preguntasExamenPrimerModulo.getOpcionesModuloDos3(numeroPregunta));

            preguntaTraida = preguntasExamenPrimerModulo.getRespuestaCorrecta2(numeroPregunta);
            numeroPregunta++;
        }
    }
}
