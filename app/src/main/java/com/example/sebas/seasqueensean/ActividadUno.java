package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ActividadUno extends AppCompatActivity {


    private String nombre;
    private String edad;
    private ProgressBar barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");

        this.barra = (ProgressBar) findViewById(R.id.barra);
        this.barra.setProgress(0);
        this.barra.setMax(600);
        final Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    for (int x = 0; x <= 600; x++) {
                        barra.setProgress(x);
                        sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(ActividadUno.this, MainMenuActivity.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("edad",edad);
                    startActivity(intent);
                    finish();
                }
            }
        };
        hilo.start();
    }
}
