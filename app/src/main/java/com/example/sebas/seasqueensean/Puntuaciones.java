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

    private TextView act1pts;
    private TextView act2pts;
    private TextView act3pts;

    private TextView exa1pts;
    private TextView exa2pts;
    private TextView exa3pts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        imagenMenuPuntuaciones = (ImageView) findViewById(R.id.imagenMenuPuntuacion);
        nombreMenuPuntuaciones = (TextView) findViewById(R.id.nombreMenuPuntuaciones);

        act1pts = (TextView) findViewById(R.id.act1pts);
        act2pts = (TextView) findViewById(R.id.act2pts);
        act3pts = (TextView) findViewById(R.id.act3pts);

        exa1pts = (TextView) findViewById(R.id.exa1pts);
        exa2pts = (TextView) findViewById(R.id.exa2pts);
        exa3pts = (TextView) findViewById(R.id.exa3pts);

        /* CREACION DE CONSTRUCTOR DE LA CLASE QUE VA A TRAER LOS METODOS DE LA BD*/
        CreateUsuario source = new CreateUsuario(Puntuaciones.this);

        /* SE ABRE LA CONEXION DE LA BD*/
        source.openDataBase();

        /*EL CURSOR VA A TOMAR LO QUE REGRESA LA CONSULTA TRAER Y ASIGANARA LOS INDICES DE
         * LAS COLUMNAS A LAS VARIABLES COLUM*/
        Cursor c = source.traer();
        int colum1=c.getColumnIndex("nombre");
        int colum3=c.getColumnIndex("genero");
        int colum5=c.getColumnIndex("puntuacionactividaduno");
        int colum6=c.getColumnIndex("puntuacionactividaddos");
        int colum7=c.getColumnIndex("puntuacionactividadtres");
        int colum8=c.getColumnIndex("puntuacionmodulouno");
        int colum9=c.getColumnIndex("puntuacionmodulodos");
        int colum10=c.getColumnIndex("puntuacionmodulotres");

        /*CON ESTO NOS POSICIONAMOS ANTES DE LA PRIMERA FILA PARA EMPEZAR A TRAER LOS DATOS*/
        c.moveToFirst();

        /*ASIGNO EL CONTENIDO DE LO QUE TIENE EL CURSOR A UNA VARIABLE DEL TIPO NECESARIO Y LE DOY
         * LA COLUMNA QUE QUIERO QUE ME TRAIGA EL DATO*/
        String nombreDB = c.getString(colum1);
        String generoDB = c.getString(colum3);
        int puntuacionActividadUnoDB = Integer.parseInt(c.getString(colum5));
        int puntuacionActividadDosDB = Integer.parseInt(c.getString(colum6));
        int puntuacionActividadTresDB = Integer.parseInt(c.getString(colum7));
        int puntuacionModuloUnoDB = Integer.parseInt(c.getString(colum8));
        int puntuacionModuloDosDB = Integer.parseInt(c.getString(colum9));
        int puntuacionModuloTresDB = Integer.parseInt(c.getString(colum10));

        /*CHECAMOS QUE SE HAYAN ASIGNADO NUESTROS DATOS*/
        Log.wtf("NombreDb",nombreDB);
        Log.wtf("GeneroDb",generoDB);
        Log.wtf("ACT1Db",""+puntuacionActividadUnoDB);
        Log.wtf("ACT2Db",""+puntuacionActividadDosDB);
        Log.wtf("ACT3Db",""+puntuacionActividadTresDB);
        Log.wtf("EXAMEN1Db",""+puntuacionModuloUnoDB);
        Log.wtf("EXAMEN2Db",""+puntuacionModuloDosDB);
        Log.wtf("EXAMEN3Db",""+puntuacionModuloTresDB);


        if (generoDB.equals("Femenino")){
            imagenMenuPuntuaciones.setImageResource(R.drawable.user_nav_girl);
        }else{
            imagenMenuPuntuaciones.setImageResource(R.drawable.user_nav);
        }

        nombreMenuPuntuaciones.setText(nombreDB);

        act1pts.setText(" "+puntuacionActividadUnoDB+" puntos");
        exa1pts.setText(" "+puntuacionModuloUnoDB+" puntos");
        act2pts.setText(" "+puntuacionActividadDosDB+" puntos");
        exa2pts.setText(" "+puntuacionModuloDosDB+" puntos");
        act3pts.setText(" "+puntuacionActividadTresDB+" puntos");
        exa3pts.setText(" "+puntuacionModuloTresDB+" puntos");

        source.close();
    }
}
