package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActividadDos extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblPuntos;
    private TextView lblPalabra;
    private EditText txtTexto;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btnBorrar;
    private ProgressBar barra;
    private Thread hilo=null;
    private String nombre;
    private String edad;
    private int x;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        Bundle datos = getIntent().getExtras();

        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.lblNombre = (TextView) findViewById(R.id.lblNombre);
        this.lblNombre.setText("Nombre:"+this.nombre);
        this.lblPuntos = (TextView) findViewById(R.id.lblPuntos);
        this.lblPalabra = (TextView) findViewById(R.id.lblPalabra);
        this.txtTexto = (EditText) findViewById(R.id.txtTexto);
        this.btn1 = (Button) findViewById(R.id.btn1);
        this.btn2 = (Button) findViewById(R.id.btn2);
        this.btn3 = (Button) findViewById(R.id.btn3);
        this.btn4 = (Button) findViewById(R.id.btn4);
        this.btn5 = (Button) findViewById(R.id.btn5);
        this.btn6 = (Button) findViewById(R.id.btn6);
        this.btn7 = (Button) findViewById(R.id.btn7);
        this.btn8 = (Button) findViewById(R.id.btn8);
        this.btnBorrar = (Button) findViewById(R.id.btnBorrar);
        this.barra = (ProgressBar) findViewById(R.id.barra);
        this.barra.setProgress(0);
        this.barra.setMax(6000);
        this.hilo = new Thread() {
            @Override
            public void run() {
                try {
                    while (x < 6000) {
                        barra.setProgress(x);
                        sleep(10);
                        if (running)
                            x++;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(ActividadDos.this, MainMenuActivity.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("edad",edad);
                    startActivity(intent);
                    finish();
                }
            }
        };
        this.hilo.start();
        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"A");
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"L");
            }
        });
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"H");
            }
        });
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"L");
            }
        });
        this.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"S");
            }
        });
        this.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"O");
            }
        });
        this.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"C");
            }
        });
        this.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTexto.setText(txtTexto.getText().toString()+"I");
            }
        });
        this.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtTexto.getText().toString().isEmpty())
                        txtTexto.setText(txtTexto.getText().toString().substring(0,txtTexto.getText().toString().length()-1));
            }
        });
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
