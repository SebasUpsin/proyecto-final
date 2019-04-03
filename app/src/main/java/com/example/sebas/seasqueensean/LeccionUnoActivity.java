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

public class LeccionUnoActivity extends AppCompatActivity {

    private Button btnAnterior;
    private Button btnSiguiente;
    private ImageView imgCarta;
    private TextView lblNumero;
    private TextView lblDescripcion;
    private int contador;
    private String edad;
    private String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion_uno);

        Bundle datos = getIntent().getExtras();
        this.nombre = datos.getString("nombre");
        this.edad = datos.getString("edad");
        this.lblDescripcion = (TextView) findViewById(R.id.lblIDescripcion);
        this.lblNumero = (TextView) findViewById(R.id.lblNumero);
        this.btnAnterior = (Button) findViewById(R.id.btnAnterior);
        this.btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        this.imgCarta=(ImageView) findViewById(R.id.imgCarta);
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
    private void cambiarCarta ()
    {
        switch (this.contador)
        {
            case 0:
                this.imgCarta.setBackgroundResource(R.drawable.i0);
                this.lblNumero.setText("0");
                this.lblDescripcion.setText("Se pegan todos los dedos a la palma de la manook ");
            break;
            case 1:
                this.imgCarta.setBackgroundResource(R.drawable.i1);
                this.lblNumero.setText("1");
                this.lblDescripcion.setText("Se estira el índice con la palma al frente.");
                break;
            case 2:
                this.imgCarta.setBackgroundResource(R.drawable.i2);
                this.lblNumero.setText("2");
                this.lblDescripcion.setText("Se estiran los dedos índice y medio.");
                break;
            case 3:
                this.imgCarta.setBackgroundResource(R.drawable.i3);
                this.lblNumero.setText("3");
                this.lblDescripcion.setText("Se estiran los dedos índice, medio y anular con la palma al frente.");
                break;
            case 4:
                this.imgCarta.setBackgroundResource(R.drawable.i4);
                this.lblNumero.setText("4");
                this.lblDescripcion.setText("Se estiran los dedos índice, medio, anular y meñique.");
                break;
            case 5:
                this.imgCarta.setBackgroundResource(R.drawable.i5);
                this.lblNumero.setText("5");
                this.lblDescripcion.setText("Se abre la mano con la palma al frente y los dedos separados.");
                break;
            case 6:
                this.imgCarta.setBackgroundResource(R.drawable.i6);
                this.lblNumero.setText("6");
                this.lblDescripcion.setText("Se hace la letra a con el pulgar hacia arriba.");
                break;
            case 7:
                this.imgCarta.setBackgroundResource(R.drawable.i7);
                this.lblNumero.setText("7");
                this.lblDescripcion.setText("Se hace una letra g, colocada en forma inclinada.");
                break;
            case 8:
                this.imgCarta.setBackgroundResource(R.drawable.i8);
                this.lblNumero.setText("8");
                this.lblDescripcion.setText("Se estiran los dedos pulgar, índice y medio, separados con la palma hacia usted.");
                break;
            case 9:
                this.imgCarta.setBackgroundResource(R.drawable.i9);
                this.lblNumero.setText("9");
                this.lblDescripcion.setText("Se hace la letra b con la palma hacia usted. Luego se cierran los dedos rodeando el pulgar.");
                break;
            case 10:
                this.imgCarta.setBackgroundResource(R.drawable.i10);
                this.lblNumero.setText("10");
                this.lblDescripcion.setText("Se hace el número 5 con la palma hacia arriba, y se rota la mano rápidamente hacia abajo.");
                break;
            case 11:
                this.imgCarta.setBackgroundResource(R.drawable.ia);
                this.lblNumero.setText("A");
                this.lblDescripcion.setText("Con la mano cerrada, se muestran las uñas y se estira el dedo pulgar hacia un lado. La palma mira al frente.");
                break;
            case 12:
                this.imgCarta.setBackgroundResource(R.drawable.ie);
                this.lblNumero.setText("E");
                this.lblDescripcion.setText("Se doblan los dedos completamente, y se muestran las uñas. La palma mira al frente.");
                break;
            case 13:
                this.imgCarta.setBackgroundResource(R.drawable.ii);
                this.lblNumero.setText("I");
                this.lblDescripcion.setText("Con la mano cerrada, el dedo meñique se estira señalando hacia arriba. La palma se pone de lado.");
                break;
            case 14:
                this.imgCarta.setBackgroundResource(R.drawable.io);
                this.lblNumero.setText("O");
                this.lblDescripcion.setText("Con la mano se forma una letra o. Todos los dedos se tocan por las puntas.");
                break;
            case 15:
                this.imgCarta.setBackgroundResource(R.drawable.iu);
                this.lblNumero.setText("U");
                this.lblDescripcion.setText("Con la mano cerrada, se estiran los dedos índice y medio unidos. La palma mira al frente.");
                break;
            case 16:
                /*SE ACTUALIZA EL STATUS DEL PROGRESO A 2*/
                CreateUsuario source = new CreateUsuario(LeccionUnoActivity.this);
                source.openDataBase();
                Cursor c = source.traer();
                int colum4=c.getColumnIndex("progreso");
                c.moveToFirst();
                int progresoDB = Integer.parseInt(c.getString(colum4));
                Log.wtf("ProgresoDb",""+progresoDB);

                if (progresoDB == 0){
                    Usuario usuario = new Usuario();
                    usuario.setProgreso(1);
                    source.updateProgreso(usuario, 1);
                }
                source.close();
                /*SE TERMINA LA ACTUALIZACION*/

                Intent intent = new Intent(LeccionUnoActivity.this, MainMenuActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
                break;

        }
    }
}

