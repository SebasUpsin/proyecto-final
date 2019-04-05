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
import DB.Usuario;

public class LeccionTresActivity extends AppCompatActivity {


    private Button btnAnterior;
    private Button btnSiguiente;
    private ImageView imgCarta1;
    private ImageView imgCarta2;
    private TextView lblNumero;
    private TextView lblDescripcion;
    private int contador;
    private String edad;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion_tres);
        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.lblDescripcion = (TextView) findViewById(R.id.lblIDescripcion);
        this.lblNumero = (TextView) findViewById(R.id.lblNumero);
        this.btnAnterior = (Button) findViewById(R.id.btnAnterior);
        this.btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        this.imgCarta1 =(ImageView) findViewById(R.id.imgCarta1);
        this.imgCarta2 =(ImageView) findViewById(R.id.imgCarta2);
        this.contador=0;
        this.cambiarCarta();
        this.btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador>0)
                {
                    contador--;
                    cambiarCarta();
                }

            }
        });
        this.btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                cambiarCarta();

            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(LeccionTresActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void cambiarCarta ()
    {
        switch (this.contador)
        {
            case 0:
                this.imgCarta1.setBackgroundResource(R.drawable.hola);
                this.imgCarta2.setVisibility(View.GONE);
                this.lblNumero.setText("Hola");
                this.lblDescripcion.setText("Dobla el dedo pulgar hacia adentro, y pegado el dedo índice a la frente, haz un movimiento hacia afuera");
                break;
            case 1:
                this.imgCarta1.setBackgroundResource(R.drawable.buenos);
                this.imgCarta2.setBackgroundResource(R.drawable.dias);
                this.imgCarta2.setVisibility(View.VISIBLE);
                this.lblNumero.setText("Buenos Días");
                this.lblDescripcion.setText("Se coloca una letra b sobre el corazón, y se mueve al frente. Luego se hace una d, y se mueve en medio círculo hacia un lado.");
                break;
            case 2:
                this.imgCarta1.setBackgroundResource(R.drawable.buenos);
                this.imgCarta2.setBackgroundResource(R.drawable.tardes);
                this.imgCarta2.setVisibility(View.VISIBLE);
                this.lblNumero.setText("Buenas Tardes");
                this.lblDescripcion.setText("Se coloca una letra b sobre el corazón, y se mueve al frente. Luego se coloca una t sobre el antebrazo, y se mueve en línea recta hacia usted");
                break;
            case 3:
                this.imgCarta1.setBackgroundResource(R.drawable.buenos);
                this.imgCarta2.setBackgroundResource(R.drawable.noches);
                this.imgCarta2.setVisibility(View.VISIBLE);
                this.lblNumero.setText("Buenas Noches");
                this.lblDescripcion.setText("Se coloca una letra b sobre el corazón, y se mueve al frente. Luego se coloca una g sobre la frente, y se mueve hacia abajo.");
                break;
            case 4:
                this.imgCarta1.setBackgroundResource(R.drawable.palabraencantadoconocer);
                this.imgCarta2.setVisibility(View.GONE);
                this.lblNumero.setText("Encantado de Conocer");
                this.lblDescripcion.setText("Se frota el corazón con la mano extendida y se coloca una letra c sobre la frente, tocándola con la punta de los dedos, y se hace vibrar en su lugar");
                break;
            case 5:
                this.imgCarta1.setBackgroundResource(R.drawable.palabragracias);
                this.imgCarta2.setVisibility(View.GONE);
                this.lblNumero.setText("Gracias");
                this.lblDescripcion.setText("Toca la boca con los cuaro dedos de cada mano y muevelas hacia afuera");
                break;
            case 6:
                this.imgCarta1.setBackgroundResource(R.drawable.palabraporfavor);
                this.imgCarta2.setVisibility(View.GONE);
                this.lblNumero.setText("Por Favor");
                this.lblDescripcion.setText("Toca el pecho con todos los dedos menos el pulgar y mueve la mano en forma de circulo.");
                break;
            case 7:
                this.imgCarta1.setBackgroundResource(R.drawable.mucho);
                this.imgCarta2.setBackgroundResource(R.drawable.gusto);
                this.lblNumero.setText("Mucho Gusto");
                this.lblDescripcion.setText("Se pone la mano en capullo con la palma hacia arriba y después se apunta el índice con la mano recostada al pecho.");
                break;
            case 8:
                this.imgCarta1.setBackgroundResource(R.drawable.palabraadios);
                this.imgCarta2.setBackgroundResource(R.drawable.gusto);
                this.lblNumero.setText("Adiós");
                this.lblDescripcion.setText("Se levantan todos los dedos y se bajan y suben todes los dedos menos el pulgar");
                break;
            case 9:
                /*SE ACTUALIZA EL STATUS DEL PROGRESO A 2*/
                CreateUsuario source = new CreateUsuario(LeccionTresActivity.this);
                source.openDataBase();
                Cursor c = source.traer();
                int colum4=c.getColumnIndex("progreso");
                c.moveToFirst();
                int progresoDB = Integer.parseInt(c.getString(colum4));
                Log.wtf("ProgresoDb",""+progresoDB);

                if (progresoDB == 6){
                    Usuario usuario = new Usuario();
                    usuario.setProgreso(7);
                    source.updateProgreso(usuario, 1);
                }
                source.close();
                /*SE TERMINA LA ACTUALIZACION*/

                Intent intent = new Intent(LeccionTresActivity.this, MainMenuActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
                break;

        }
    }
}
