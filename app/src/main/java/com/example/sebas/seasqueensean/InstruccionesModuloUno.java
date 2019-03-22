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
        this.barra=(ProgressBar) findViewById(R.id.barra);
        this.barra.setProgress(0);
        this.barra.setMax(1000);
        final Thread hilo= new Thread()
        {
            @Override
            public void run ()
            {
                try
                {
                    for(int x=0;x<=1000;x++)
                    {
                        barra.setProgress(x);
                        sleep(10);
                        if(running)
                            x++;
                    }
                }catch(Exception e)
                {
                 e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(InstruccionesModuloUno.this,ActividadUno.class);
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
