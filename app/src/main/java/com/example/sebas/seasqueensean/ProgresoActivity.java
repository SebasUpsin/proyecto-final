package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;

import DB.CreateUsuario;

public class ProgresoActivity extends AppCompatActivity {

    private String nombre;
    private String edad;

    private ImageView imagenMenuProgreso;
    private TextView nombreNav;

    String[] descriptionData = {"Leccion", "Actividad", "Examen"};

    String[] descriptionDataFinal = {"Modulo\n1", "Modulo\n2", "Modulo\n3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        /*SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.nombre = sharedPreferences.getString("nombre","");
        this.edad = sharedPreferences.getString("edad","");*/

        nombreNav = (TextView) findViewById(R.id.nombreMenuProgreso);
        imagenMenuProgreso = (ImageView) findViewById(R.id.imagenMenuProgreso);


        /* CREACION DE CONSTRUCTOR DE LA CLASE QUE VA A TRAER LOS METODOS DE LA BD*/
        CreateUsuario source = new CreateUsuario(ProgresoActivity.this);

        /* SE ABRE LA CONEXION DE LA BD*/
        source.openDataBase();

        /*EL CURSOR VA A TOMAR LO QUE REGRESA LA CONSULTA TRAER Y ASIGANARA LOS INDICES DE
         * LAS COLUMNAS A LAS VARIABLES COLUM*/
        Cursor c = source.traer();
        int colum1=c.getColumnIndex("nombre");
        int colum3=c.getColumnIndex("genero");
        int colum4=c.getColumnIndex("progreso");

        /*CON ESTO NOS POSICIONAMOS ANTES DE LA PRIMERA FILA PARA EMPEZAR A TRAER LOS DATOS*/
        c.moveToFirst();

        /*ASIGNO EL CONTENIDO DE LO QUE TIENE EL CURSOR A UNA VARIABLE DEL TIPO NECESARIO Y LE DOY
         * LA COLUMNA QUE QUIERO QUE ME TRAIGA EL DATO*/
        String nombreDB = c.getString(colum1);
        String generoDB = c.getString(colum3);
        int progresoDB = c.getInt(colum4);

        /*CHECAMOS QUE SE HAYAN ASIGNADO NUESTROS DATOS*/
        Log.wtf("NombreDb",nombreDB);
        Log.wtf("GeneroDb",generoDB);
        Log.wtf("progesoDb",""+progresoDB);

        //nombreNav.setText(nombre);

        if (generoDB.equals("Femenino")){
            imagenMenuProgreso.setImageResource(R.drawable.user_nav_girl);
        }else{
            imagenMenuProgreso.setImageResource(R.drawable.user_nav);
        }

        nombreNav.setText(nombreDB);


        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.progress_numerosVocales);
        stateProgressBar.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar2 = (StateProgressBar) findViewById(R.id.progress_abecedario);
        stateProgressBar2.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar3 = (StateProgressBar) findViewById(R.id.progress_palabrasClave);
        stateProgressBar3.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar4 = (StateProgressBar) findViewById(R.id.progress_general);
        stateProgressBar4.setStateDescriptionData(descriptionDataFinal);


        Toast.makeText(this, ""+progresoDB, Toast.LENGTH_SHORT).show();

        /*if (progresoDB == 4){
            stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
        }else if (progresoDB == 7){
            stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
        }else if (progresoDB == 9){
            stateProgressBar4.setAllStatesCompleted(true);
        }*/

        switch (progresoDB){
            case 0:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                stateProgressBar2.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                stateProgressBar3.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                break;
            case 1:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                break;
            case 2:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                break;
            case 3:
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                break;
            case 4:
                stateProgressBar2.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                break;
            case 5:
                stateProgressBar2.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                break;
            case 6:
                stateProgressBar2.setAllStatesCompleted(true);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                break;
            case 7:
                stateProgressBar3.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                stateProgressBar2.setAllStatesCompleted(true);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                break;
            case 8:
                stateProgressBar3.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                stateProgressBar2.setAllStatesCompleted(true);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                break;
            case 9:
                stateProgressBar3.setAllStatesCompleted(true);
                stateProgressBar2.setAllStatesCompleted(true);
                stateProgressBar.setAllStatesCompleted(true);
                stateProgressBar4.setAllStatesCompleted(true);
                break;


        }




        source.close();

    }
}
