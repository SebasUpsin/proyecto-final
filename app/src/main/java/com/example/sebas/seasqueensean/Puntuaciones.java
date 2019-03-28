package com.example.sebas.seasqueensean;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import DB.CreateUsuario;

public class Puntuaciones extends AppCompatActivity {

    private ImageView imagenMenuPuntuaciones;
    private TextView nombreMenuPuntuaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        imagenMenuPuntuaciones = (ImageView) findViewById(R.id.imagenMenuPuntuacion);
        nombreMenuPuntuaciones = (TextView) findViewById(R.id.nombreMenuPuntuaciones);

        /* CREACION DE CONSTRUCTOR DE LA CLASE QUE VA A TRAER LOS METODOS DE LA BD*/
        CreateUsuario source = new CreateUsuario(Puntuaciones.this);

        /* SE ABRE LA CONEXION DE LA BD*/
        source.openDataBase();

        /*EL CURSOR VA A TOMAR LO QUE REGRESA LA CONSULTA TRAER Y ASIGANARA LOS INDICES DE
         * LAS COLUMNAS A LAS VARIABLES COLUM*/
        Cursor c = source.traer();
        int colum1=c.getColumnIndex("nombre");
        int colum3=c.getColumnIndex("genero");

        /*CON ESTO NOS POSICIONAMOS ANTES DE LA PRIMERA FILA PARA EMPEZAR A TRAER LOS DATOS*/
        c.moveToFirst();

        /*ASIGNO EL CONTENIDO DE LO QUE TIENE EL CURSOR A UNA VARIABLE DEL TIPO NECESARIO Y LE DOY
         * LA COLUMNA QUE QUIERO QUE ME TRAIGA EL DATO*/
        String nombreDB = c.getString(colum1);
        String generoDB = c.getString(colum3);

        /*CHECAMOS QUE SE HAYAN ASIGNADO NUESTROS DATOS*/
        Log.wtf("NombreDb",nombreDB);
        Log.wtf("GeneroDb",generoDB);


        if (generoDB.equals("Femenino")){
            imagenMenuPuntuaciones.setImageResource(R.drawable.user_nav_girl);
        }else{
            imagenMenuPuntuaciones.setImageResource(R.drawable.user_nav);
        }

        nombreMenuPuntuaciones.setText(nombreDB);


        source.close();
    }
}
