package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

public class ProgresoActivity extends AppCompatActivity {

    private String nombre;
    private String edad;

    private TextView nombreNav;

    String[] descriptionData = {"Leccion", "Actividad", "Examen"};

    String[] descriptionDataFinal = {"Modulo\n1", "Modulo\n2", "Modulo\n3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.nombre = sharedPreferences.getString("nombre","");
        this.edad = sharedPreferences.getString("edad","");

        nombreNav = (TextView) findViewById(R.id.nombreMenuProgreso);

        nombreNav.setText(nombre);

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.progress_numerosVocales);
        stateProgressBar.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar2 = (StateProgressBar) findViewById(R.id.progress_abecedario);
        stateProgressBar2.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar3 = (StateProgressBar) findViewById(R.id.progress_palabrasClave);
        stateProgressBar3.setStateDescriptionData(descriptionData);

        StateProgressBar stateProgressBar4 = (StateProgressBar) findViewById(R.id.progress_general);
        stateProgressBar4.setStateDescriptionData(descriptionDataFinal);
    }
}
