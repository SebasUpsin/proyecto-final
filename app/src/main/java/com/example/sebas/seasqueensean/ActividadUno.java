package com.example.sebas.seasqueensean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ActividadUno extends AppCompatActivity {


    private String nombre;
    private String edad;
    private ProgressBar barra;
    private boolean running;
    private int x;
    private int contador;
    private int[] hechas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private Thread hilo=null;
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
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private int seleccionada1;
    private int seleccionada2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.seleccionada1=0;
        this.seleccionada2=0;
        this.contador=0;
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
        this.btn13 = (Button) findViewById(R.id.btn13);
        this.btn14 = (Button) findViewById(R.id.btn14);
        this.btn15 = (Button) findViewById(R.id.btn15);
        this.btn16 = (Button) findViewById(R.id.btn16);
        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==1)
                        return;
                if(seleccionada1==1)
                    return;
                if(seleccionada1==0){
                    seleccionada1=1;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=1;
                    if(seleccionada1==3&&seleccionada2==1){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=1;
                        contador++;
                        hechas[contador]=3;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==2)
                        return;
                if(seleccionada1==2)
                    return;
                if(seleccionada1==0){
                    seleccionada1=2;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=2;
                    if(seleccionada1==10&&seleccionada2==2){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=2;
                        contador++;
                        hechas[contador]=10;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }
            }
        });
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==3)
                        return;
                if(seleccionada1==3)
                    return;
                if(seleccionada1==0){
                    seleccionada1=3;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=3;
                    if(seleccionada1==1&&seleccionada2==3){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=1;
                        contador++;
                        hechas[contador]=3;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }
            }
        });
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==4)
                        return;
                if(seleccionada1==4)
                    return;
                if(seleccionada1==0){
                    seleccionada1=4;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=4;
                    if(seleccionada1==8&&seleccionada2==4){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=4;
                        contador++;
                        hechas[contador]=8;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==5)
                        return;
                if(seleccionada1==5)
                    return;
                if(seleccionada1==0){
                    seleccionada1=5;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=5;
                    if(seleccionada1==11&&seleccionada2==5){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=5;
                        contador++;
                        hechas[contador]=11;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==6)
                        return;
                if(seleccionada1==6)
                    return;
                if(seleccionada1==0){
                    seleccionada1=6;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=6;
                    if(seleccionada1==7&&seleccionada2==6){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=6;
                        contador++;
                        hechas[contador]=7;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==7)
                        return;
                if(seleccionada1==7)
                    return;
                if(seleccionada1==0){
                    seleccionada1=7;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=7;
                    if(seleccionada1==6&&seleccionada2==7){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=6;
                        contador++;
                        hechas[contador]=7;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==8)
                        return;
                if(seleccionada1==8)
                    return;
                if(seleccionada1==0){
                    seleccionada1=8;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=8;
                    if(seleccionada1==4&&seleccionada2==8){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=4;
                        contador++;
                        hechas[contador]=8;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==9)
                        return;
                if(seleccionada1==9)
                    return;
                if(seleccionada1==0){
                    seleccionada1=9;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=9;
                    if(seleccionada1==16&&seleccionada2==9){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=9;
                        contador++;
                        hechas[contador]=16;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==10)
                        return;
                if(seleccionada1==10)
                    return;
                if(seleccionada1==0){
                    seleccionada1=10;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=10;
                    if(seleccionada1==2&&seleccionada2==10){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=2;
                        contador++;
                        hechas[contador]=10;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }
            }
        });
        this.btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==11)
                        return;
                if(seleccionada1==11)
                    return;
                if(seleccionada1==0){
                    seleccionada1=11;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=11;
                    if(seleccionada1==5&&seleccionada2==11){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=5;
                        contador++;
                        hechas[contador]=11;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==12)
                        return;
                if(seleccionada1==12)
                    return;
                if(seleccionada1==0){
                    seleccionada1=12;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=12;
                    if(seleccionada1==15&&seleccionada2==12){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=12;
                        contador++;
                        hechas[contador]=15;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==13)
                        return;
                if(seleccionada1==13)
                    return;
                if(seleccionada1==0){
                    seleccionada1=13;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=13;
                    if(seleccionada1==14&&seleccionada2==13){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=13;
                        contador++;
                        hechas[contador]=14;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==14)
                        return;
                if(seleccionada1==14)
                    return;
                if(seleccionada1==0){
                    seleccionada1=14;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=14;
                    if(seleccionada1==13&&seleccionada2==14){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=13;
                        contador++;
                        hechas[contador]=14;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==15)
                        return;
                if(seleccionada1==15)
                    return;
                if(seleccionada1==0){
                    seleccionada1=15;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=15;
                    if(seleccionada1==12&&seleccionada2==15){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=12;
                        contador++;
                        hechas[contador]=15;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
        this.btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int y=0;y<contador;y++)
                    if(hechas[y]==16)
                        return;
                if(seleccionada1==16)
                    return;
                if(seleccionada1==0){
                    seleccionada1=16;
                    voltearCarta2(seleccionada1);
                }else if(seleccionada2==0){
                    seleccionada2=16;
                    if(seleccionada1==9&&seleccionada2==16){
                        voltearCarta2(seleccionada2);
                        hechas[contador]=9;
                        contador++;
                        hechas[contador]=16;
                        contador++;
                    }else {
                        voltearCarta1(seleccionada1);
                        voltearCarta1(seleccionada2);
                    }
                    seleccionada1=0;
                    seleccionada2=0;
                }

            }
        });
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
                        if(running)
                            x++;
                        if(contador==16)
                            x=6000;
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
