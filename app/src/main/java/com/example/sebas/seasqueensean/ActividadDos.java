package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btnBorrar;
    private ProgressBar barra;
    private Thread hilo=null;
    private String nombre;
    private String edad;
    private String[][] palabras={{"HOLA","CASA","RAMO","CAMA","CARRO"},
            {"EURO","HILO","AMOR","LLAMA","CLASE"},
            {"SOCIAL","CHILE","PELO","PRIMO","PLUMA"},
            {"PRESA","CLÁUSULA","MUSICA","RARAMURI","HEROES"},
            {"ESCUELA","EMPRESA","MOCHILA","PRIMARIA","PROCLAMAR"}};
    private int palabra;
    private int contador;
    private int x;
    private int j;
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
        this.btn9 = (Button) findViewById(R.id.btn9);
        this.btn10 = (Button) findViewById(R.id.btn10);
        this.btn11 = (Button) findViewById(R.id.btn11);
        this.btn12 = (Button) findViewById(R.id.btn12);
        this.btnBorrar = (Button) findViewById(R.id.btnBorrar);
        this.barra = (ProgressBar) findViewById(R.id.barra);
        this.contador=0;
        this.seleccionarPalabra();
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
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"A");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if (contador == 5){
                        x = 6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"L");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"H");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"R");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
               txtTexto.setText(txtTexto.getText().toString()+"S");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"O");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"C");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"I");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"E");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
            if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                txtTexto.setText(txtTexto.getText().toString()+"M");
            if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                    contador++;
                    txtTexto.setText("");
                    if(contador==5){
                        x=6000;
                        return;
                    }
                    j=0;
                    seleccionarPalabra();
                }
            }
        });
        this.btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
                if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                    txtTexto.setText(txtTexto.getText().toString()+"P");
                if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                    if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                        contador++;
                        txtTexto.setText("");
                        if(contador==5){
                            x=6000;
                            return;
                        }
                        seleccionarPalabra();
                    }
            }
        });

        this.btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDos.this, "simon", Toast.LENGTH_SHORT).show();
                if(palabras[contador][palabra].length()>txtTexto.getText().toString().length())
                    txtTexto.setText(txtTexto.getText().toString()+"U");
                if(palabras[contador][palabra].length()==txtTexto.getText().toString().length())
                    if(txtTexto.getText().toString().equals(palabras[contador][palabra])) {
                        contador++;
                        txtTexto.setText("");
                        if(contador==5){
                            x=6000;
                            return;
                        }
                        seleccionarPalabra();
                    }
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

    private void seleccionarPalabra(){
        this.palabra= (int) (Math.random()*5);
        this.lblPalabra.setText(this.palabras[this.contador][this.palabra]);
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
