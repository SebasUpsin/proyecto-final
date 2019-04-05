package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import DB.CreateUsuario;

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
    private ImageView imagen;

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
        this.imagen = (ImageView) findViewById(R.id.imagenResultados);
        //this.lblNombre.setText(this.nombre);
        this.lblPuntos.setText("Resultado: "+this.puntos);
        this.lblMaximo.setText("Puntaje Máximo: "+this.maximo);
        this.btnActividad.setText(this.actividad);

        CreateUsuario source = new CreateUsuario(Resultados.this);
        source.openDataBase();
        Cursor c = source.traer();
        int colum1=c.getColumnIndex("nombre");
        int colum3=c.getColumnIndex("genero");
        c.moveToFirst();
        String nombreDB = c.getString(colum1);
        String generoDB = c.getString(colum3);
        Log.wtf("NombreDb",nombreDB);
        Log.wtf("GeneroDb",generoDB);

        if (generoDB.equals("Femenino")){
            imagen.setImageResource(R.drawable.user_nav_girl);
        }else{
            imagen.setImageResource(R.drawable.user_nav);
        }

        lblNombre.setText(nombreDB);




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

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Resultados.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
