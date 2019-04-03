package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import DB.CreateUsuario;
import DB.Usuario;

public class ActividadTres extends AppCompatActivity {
    private TextView lblNombre;
    private TextView lblPuntos;
    private TextView lblFrase;
    private EditText txtFrase;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btnBorrar;
    private ProgressBar barra;
    private Thread hilo=null;
    private String nombre;
    private String edad;
    private String[] frases={"HOLA","BUENOS DÍAS","BUENAS TARDES","BUENAS NOCHES","MUCHO GUSTO","ADIOS"};
    private int contador;
    private int x;
    private int valorX=6000;
    private int maximo;
    private int puntos;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_tres);

        final SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.maximo = sharedPreferences.getInt("maximoActividad3",0);
        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.lblNombre = (TextView) findViewById(R.id.lblNombre);
        //this.lblNombre.setText("Nombre:"+this.nombre);
        this.lblPuntos = (TextView) findViewById(R.id.lblPuntos);
        this.lblFrase = (TextView) findViewById(R.id.lblFrase);
        this.txtFrase = (EditText) findViewById(R.id.txtFrase);
        this.btn1 = (Button) findViewById(R.id.btn1);
        this.btn2 = (Button) findViewById(R.id.btn2);
        this.btn3 = (Button) findViewById(R.id.btn3);
        this.btn4 = (Button) findViewById(R.id.btn4);
        this.btnBorrar = (Button) findViewById(R.id.btnBorrar);
        this.barra = (ProgressBar) findViewById(R.id.barra);
        this.contador=0;
        seleccionarFrase();
        this.barra.setProgress(0);
        this.barra.setMax(6000);
        this.hilo = new Thread() {
            @Override
            public void run() {
                try {
                    while (x < 6000) {
                        barra.setProgress(x);
                        sleep(10);
                        if (running)
                            x++;
                    }
                    puntos = 6000-valorX;
                    if(contador==6)
                        puntos+=1000;
                    if(puntos>=maximo){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("maximoActividad3",puntos);
                        editor.commit();
                        maximo=puntos;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }finally {


                    /*SE ACTUALIZA EL STATUS DEL PROGRESO A 2*/
                    /* SI PONES ALGUNA PUNTUACION JOSUE ME DICES DONDE PUSISTE LA VARIABLE DE PUNTUACION*/
                    CreateUsuario source = new CreateUsuario(ActividadTres.this);
                    source.openDataBase();
                    Cursor c = source.traer();
                    int colum4=c.getColumnIndex("progreso");
                    int colum7=c.getColumnIndex("puntuacionactividadtres");
                    c.moveToFirst();
                    int progresoDB = Integer.parseInt(c.getString(colum4));
                    int puntuacionActividadTresDB = Integer.parseInt(c.getString(colum7));
                    Log.wtf("ProgresoDb",""+progresoDB);
                    Log.wtf("ACT3Db",""+puntuacionActividadTresDB);

                    if (progresoDB == 7){
                        Usuario usuario = new Usuario();
                        usuario.setProgreso(8);
                        source.updateProgreso(usuario, 1);
                    }

                    if (puntuacionActividadTresDB < puntos){
                        Usuario usuario = new Usuario();
                        usuario.setPuntuacionActividadTres(puntos);
                        source.updateActividad3(usuario,1);
                    }


                    //Toast.makeText(ActividadUno.this,"Contacto Actualizado!", Toast.LENGTH_SHORT).show();
                    source.close();
                    /*SE TERMINA LA ACTUALIZACION*/










                    Intent intent = new Intent(ActividadTres.this, Resultados.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("edad",edad);
                    intent.putExtra("puntos",puntos);
                    intent.putExtra("maximo",maximo);
                    intent.putExtra("actividad","ACTIVIDAD MÓDULO 3");
                    startActivity(intent);
                    finish();
                }
            }
        };
        this.hilo.start();

        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frases[contador].length()>txtFrase.getText().toString().length())
                    escribir(1);
                if(frases[contador].length()==txtFrase.getText().toString().length())
                    if(comprobarFrase()) {
                        contador++;
                        if(contador==6) {
                            valorX=x;
                            x = 6000;
                            return;
                        }
                        seleccionarFrase();
                    }
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frases[contador].length()>txtFrase.getText().toString().length())
                    escribir(2);
                if(frases[contador].length()==txtFrase.getText().toString().length())
                    if(comprobarFrase()) {
                        contador++;
                        if(contador==6) {
                            valorX=x;
                            x = 6000;
                            return;
                        }
                        seleccionarFrase();
                    }
            }
        });
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frases[contador].length()>txtFrase.getText().toString().length())
                    escribir(3);
                if(frases[contador].length()==txtFrase.getText().toString().length())
                    if(comprobarFrase()) {
                        contador++;
                        if(contador==6) {
                            valorX=x;
                            x = 6000;
                            return;
                        }
                        seleccionarFrase();
                    }
            }
        });
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frases[contador].length()>txtFrase.getText().toString().length())
                    escribir(4);
                if(frases[contador].length()==txtFrase.getText().toString().length())
                    if(comprobarFrase()) {
                        contador++;
                        if(contador==6) {
                            valorX=x;
                            x = 6000;
                            return;
                        }
                        seleccionarFrase();
                    }
            }
        });

        this.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtFrase.getText().toString().contains(" ")) {
                    String[] s=txtFrase.getText().toString().split(" ");
                    txtFrase.setText(s[0]);
                }
                else
                    txtFrase.setText("");
            }
        });
    }

    private  void seleccionarFrase(){
        this.lblFrase.setText(this.frases[this.contador]);
        this.txtFrase.setText("");
        switch (this.contador){
            case 0:
                this.btn1.setBackgroundResource(R.drawable.dias);
                this.btn2.setBackgroundResource(R.drawable.hola);
                this.btn3.setBackgroundResource(R.drawable.mucho);
                this.btn4.setBackgroundResource(R.drawable.buenos);
                break;
            case 1:
                this.btn1.setBackgroundResource(R.drawable.mucho);
                this.btn2.setBackgroundResource(R.drawable.buenos);
                this.btn3.setBackgroundResource(R.drawable.hola);
                this.btn4.setBackgroundResource(R.drawable.dias);
                break;
            case 2:
                this.btn1.setBackgroundResource(R.drawable.noches);
                this.btn2.setBackgroundResource(R.drawable.buenos);
                this.btn3.setBackgroundResource(R.drawable.tardes);
                this.btn4.setBackgroundResource(R.drawable.hola);
                break;
            case 3:
                this.btn1.setBackgroundResource(R.drawable.hola);
                this.btn2.setBackgroundResource(R.drawable.noches);
                this.btn3.setBackgroundResource(R.drawable.mucho);
                this.btn4.setBackgroundResource(R.drawable.buenos);
                break;
            case 4:
                this.btn1.setBackgroundResource(R.drawable.gusto);
                this.btn2.setBackgroundResource(R.drawable.hola);
                this.btn3.setBackgroundResource(R.drawable.palabraadios);
                this.btn4.setBackgroundResource(R.drawable.mucho);
                break;
            case 5:
                this.btn1.setBackgroundResource(R.drawable.dias);
                this.btn2.setBackgroundResource(R.drawable.palabraadios);
                this.btn3.setBackgroundResource(R.drawable.hola);
                this.btn4.setBackgroundResource(R.drawable.buenos);
                break;
        }
    }
    private void escribir(int boton){
        String texto = this.txtFrase.getText().toString();
        if(!texto.isEmpty())
            texto = this.txtFrase.getText().toString()+" ";
        switch (this.contador){
            case 0:
                if(boton==1)
                    this.txtFrase.setText(texto+"DÍAS");
                else if(boton==2)
                    this.txtFrase.setText(texto+"HOLA");
                else if(boton==3)
                    this.txtFrase.setText(texto+"MUCHO");
                else if(boton==4)
                    this.txtFrase.setText(texto+"BUENOS");
                break;
            case 1:
                if(boton==1)
                    this.txtFrase.setText(texto+"MUCHO");
                else if(boton==2)
                    this.txtFrase.setText(texto+"BUENOS");
                else if(boton==3)
                    this.txtFrase.setText(texto+"HOLA");
                else if(boton==4)
                    this.txtFrase.setText(texto+"DÍAS");
                break;
            case 2:
                if(boton==1)
                    this.txtFrase.setText(texto+"NOCHES");
                else if(boton==2)
                    this.txtFrase.setText(texto+"BUENAS");
                else if(boton==3)
                    this.txtFrase.setText(texto+"TARDES");
                else if(boton==4)
                    this.txtFrase.setText(texto+"HOLA");
                break;
            case 3:
                if(boton==1)
                    this.txtFrase.setText(texto+"HOLA");
                else if(boton==2)
                    this.txtFrase.setText(texto+"NOCHES");
                else if(boton==3)
                    this.txtFrase.setText(texto+"MUCHOS");
                else if(boton==4)
                    this.txtFrase.setText(texto+"BUENAS");
                break;
            case 4:
                if(boton==1)
                    this.txtFrase.setText(texto+"GUSTO");
                else if(boton==2)
                    this.txtFrase.setText(texto+"HOLA");
                else if(boton==3)
                    this.txtFrase.setText(texto+"ADIOS");
                else if(boton==4)
                    this.txtFrase.setText(texto+"MUCHO");
                break;
            case 5:
                if(boton==1)
                    this.txtFrase.setText(texto+"DÍAS");
                else if(boton==2)
                    this.txtFrase.setText(texto+"ADIOS");
                else if(boton==3)
                    this.txtFrase.setText(texto+"HOLA");
                else if(boton==4)
                    this.txtFrase.setText(texto+"BUENOS");
                break;
        }
    }
    private boolean comprobarFrase(){
        if(this.lblFrase.getText().toString().equals(this.txtFrase.getText().toString()))
            return true;
        else
            return false;
    }
    protected void onStart() {
        super.onStart();
        this.running=true;
    }

    protected void onPause() {
        super.onPause();
        this.running=false;
    }
}
