package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblMaximo;
    private TextView lblPuntos;
    private Button btnActividad;
    private Button btnAceptar;
    private String nombre;
    private String edad;
    private String actividad;
    private int maximo;
    private int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.maximo = datos.getInt("maximo");
        this.puntos = datos.getInt("puntos");
        this.actividad = datos.getString("actividad");
        this.lblNombre = (TextView) findViewById(R.id.lblNombreR);
        this.lblMaximo = (TextView) findViewById(R.id.lblMaximo);
        this.lblPuntos = (TextView) findViewById(R.id.lblPuntos);
        this.btnActividad = (Button) findViewById(R.id.btnActividad);
        this.btnAceptar = (Button) findViewById(R.id.btnAceptarR);
        this.lblNombre.setText(this.nombre);
        this.lblPuntos.setText("Resultado: "+this.puntos);
        this.lblMaximo.setText("Puntaje Máximo: "+this.maximo);
        this.btnActividad.setText(this.actividad);
        this.btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultados.this, MainMenuActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
            }
        });
    }
}
