package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class InstruccionesModuloUno extends AppCompatActivity {

    private ProgressBar barra;
    private TextView lblInstrucciones;
    private String nombre;
    private String edad;
    private int numero;
    private int x;
    private boolean running;
    private Thread hilo=null;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_modulo_uno);

        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.numero = datos.getInt("numero");
        this.barra = (ProgressBar) findViewById(R.id.barra);
        this.lblInstrucciones = (TextView) findViewById(R.id.lblInstrucciones);
        switch (this.numero){
            case 1:
                break;
            case 2:
                this.intent = new Intent(InstruccionesModuloUno.this, ActividadUno.class);
                this.lblInstrucciones.setText(getString(R.string.instruccionesActividad1));
                break;
            case 5:
                this.intent = new Intent(InstruccionesModuloUno.this, ActividadDos.class);
                this.lblInstrucciones.setText("Escribe la palabra impresa en la partes superior... Pero no será tan fácil, ya que deberás hacerlo en el lenguaje de las señas. Debajo tendrás un teclade con algunas letras en el lenguaje de señas");
                break;
            case 8:
                this.intent = new Intent(InstruccionesModuloUno.this, ActividadTres.class);
                this.lblInstrucciones.setText("Hasta este punto ya debes de saber palabras clave en el lenguaje de señas, así que describe cada una de las palabras de la parte superior con las seeñas de abajo.");
                break;
        }
        this.barra.setProgress(0);
        this.barra.setMax(1500);
        this.x=0;
        this.hilo = new Thread()
        {
            @Override
            public void run ()
            {
                try
                {
                    while (x<1500){
                        barra.setProgress(x);
                        sleep(10);
                        if(running)
                            x++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally {

                    intent.putExtra("nombre", nombre);
                    intent.putExtra("edad", edad);
                    startActivity(intent);
                    finish();
                }
            }
        };
        this.hilo.start();
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
