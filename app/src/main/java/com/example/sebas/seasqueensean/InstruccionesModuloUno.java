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
                this.lblInstrucciones.setText(getString(R.string.instruccionesActividad1));
                break;
            case 3:
                break;
        }
        this.barra.setProgress(0);
        this.barra.setMax(100);
        this.x=0;
        this.hilo = new Thread()
        {
            @Override
            public void run ()
            {
                try
                {
                    while (x<100){
                        barra.setProgress(x);
                        sleep(10);
                        if(running)
                            x++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(InstruccionesModuloUno.this, ActividadUno.class);
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
