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

public class LeccionDosActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_leccion_dos);
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
                this.imgCarta.setBackgroundResource(R.drawable.ia);
                this.lblNumero.setText("A");
                this.lblDescripcion.setText("Con la mano cerrada, se muestran las uñas y se estira el dedo pulgar hacia un lado. La palma mira al frente");
                break;
            case 1:
                this.imgCarta.setBackgroundResource(R.drawable.ib);
                this.lblNumero.setText("B");
                this.lblDescripcion.setText("Los dedos índice, medio, anular y meñique se estiran bien unidos y el pulgar se dobla hacia la palma, la cual mira al frente.");
                break;
            case 2:
                this.imgCarta.setBackgroundResource(R.drawable.ic);
                this.lblNumero.setText("C");
                this.lblDescripcion.setText("Los dedos índice, medio, anular y meñique se mantienen bien unidos y en posición cóncava; el pulgar también se pone en esa posición. La palma mira a un lado.");
                break;
            case 3:
                this.imgCarta.setBackgroundResource(R.drawable.id);
                this.lblNumero.setText("D");
                this.lblDescripcion.setText("Los dedos medio, anular, meñique y pulgar se unen por las puntas y el dedo índice se estira. La palma mira al frente.");
                break;
            case 4:
                this.imgCarta.setBackgroundResource(R.drawable.ie);
                this.lblNumero.setText("E");
                this.lblDescripcion.setText("Se doblan los dedos completamente, y se muestran las uñas. La palma mira al frente.");
                break;
            case 5:
                this.imgCarta.setBackgroundResource(R.drawable.iefe);
                this.lblNumero.setText("F");
                this.lblDescripcion.setText("Con la mano abierta y los dedos bien unidos, se dobla el índice hasta que su parte lateral toque la yema del pulgar. La palma mira a un lado.");
                break;
            case 6:
                this.imgCarta.setBackgroundResource(R.drawable.ig);
                this.lblNumero.setText("G");
                this.lblDescripcion.setText("Se cierra la mano y los dedos índice y pulgar se estiran. La palma mira hacia usted.");
                break;
            case 7:
                this.imgCarta.setBackgroundResource(R.drawable.ih);
                this.lblNumero.setText("H");
                this.lblDescripcion.setText("Con la mano cerrada y los dedos índice y medio bien estirados y unidos, se extiende el dedo pulgar señalando hacia arriba. La palma mira hacia usted.");
                break;
            case 8:
                this.imgCarta.setBackgroundResource(R.drawable.ii);
                this.lblNumero.setText("I");
                this.lblDescripcion.setText("Con la mano cerrada, el dedo meñique se estira señalando hacia arriba. La palma se pone de lado.");
                break;
            case 9:
                this.imgCarta.setBackgroundResource(R.drawable.ij);
                this.lblNumero.setText("J");
                this.lblDescripcion.setText("Con la mano cerrada, el dedo meñique bien estirado señalando hacia arriba y la palma a un lado dibuja una j en el aire.");
                break;
            case 10:
                this.imgCarta.setBackgroundResource(R.drawable.ik);
                this.lblNumero.setText("K");
                this.lblDescripcion.setText("Se cierra la mano con los dedos índice, medio y pulgar estirados. La yema del pulgar se pone entre el índice y el medio. Se mueve la muñeca hacia arriba.");
                break;
            case 11:
                this.imgCarta.setBackgroundResource(R.drawable.il);
                this.lblNumero.setText("L");
                this.lblDescripcion.setText("Con la mano cerrada y los dedos índice y pulgar estirados, se forma una l. La palma mira al frente.");
                break;
            case 12:
                this.imgCarta.setBackgroundResource(R.drawable.im);
                this.lblNumero.setText("M");
                this.lblDescripcion.setText("Con la mano cerrada, se ponen los dedos índice, medio y anular sobre el pulgar.");
                break;
            case 13:
                this.imgCarta.setBackgroundResource(R.drawable.in);
                this.lblNumero.setText("N");
                this.lblDescripcion.setText("Con la mano cerrada, se ponen los dedos índice y medio sobre el pulgar.");
                break;
            case 14:
                this.imgCarta.setBackgroundResource(R.drawable.io);
                this.lblNumero.setText("O");
                this.lblDescripcion.setText("Con la mano se forma una letra o. Todos los dedos se tocan por las puntas.");
                break;
            case 15:
                this.imgCarta.setBackgroundResource(R.drawable.ip);
                this.lblNumero.setText("P");
                this.lblDescripcion.setText("Con la mano cerrada y los dedos índice, medio y pulgar estirados, se pone la yema del pulgar entre el índice y el medio.");
                break;
            case 16:
                this.imgCarta.setBackgroundResource(R.drawable.iq);
                this.lblNumero.setText("Q");
                this.lblDescripcion.setText("Con la mano cerrada, se ponen los dedos índice y pulgar en posición de garra. La palma mira hacia abajo, y se mueve la muñeca hacia los lados.");
                break;
            case 17:
                this.imgCarta.setBackgroundResource(R.drawable.ir);
                this.lblNumero.setText("R");
                this.lblDescripcion.setText("Con la mano cerrada, se estiran y entrelazan los dedos índice y medio. La palma mira al frente.");
                break;
            case 18:
                this.imgCarta.setBackgroundResource(R.drawable.is);
                this.lblNumero.setText("S");
                this.lblDescripcion.setText("Con la mano cerrada, se pone el pulgar sobre los otros dedos. La palma mira al frente.");
                break;
            case 19:
                this.imgCarta.setBackgroundResource(R.drawable.it);
                this.lblNumero.setText("T");
                this.lblDescripcion.setText("Con la mano cerrada, el pulgar se pone entre el índice y el medio. La palma mira al frente.");
                break;
            case 20:
                this.imgCarta.setBackgroundResource(R.drawable.iu);
                this.lblNumero.setText("U");
                this.lblDescripcion.setText("Con la mano cerrada, se estiran los dedos índice y medio unidos. La palma mira al frente.");
                break;
            case 21:
                this.imgCarta.setBackgroundResource(R.drawable.iv);
                this.lblNumero.setText("V");
                this.lblDescripcion.setText("Con la mano cerrada, se estiran los dedos índice y medio separados. La palma mira al frente.");
                break;
            case 22:
                this.imgCarta.setBackgroundResource(R.drawable.iw);
                this.lblNumero.setText("W");
                this.lblDescripcion.setText("Con la mano cerrada, se estiran los dedos índice, medio y anular separados. La palma mira al frente.");
                break;
            case 23:
                this.imgCarta.setBackgroundResource(R.drawable.ix);
                this.lblNumero.setText("X");
                this.lblDescripcion.setText("Con la mano cerrada, el índice y el pulgar en posición de garra y la palma dirigida a un lado, se realiza un movimiento al frente y de regreso.");
                break;
            case 24:
                this.imgCarta.setBackgroundResource(R.drawable.iy);
                this.lblNumero.setText("Y");
                this.lblDescripcion.setText("Con la mano cerrada, se estira el meñique y el pulgar. La palma mira hacia usted.");
                break;
            case 25:
                this.imgCarta.setBackgroundResource(R.drawable.iz);
                this.lblNumero.setText("Z");
                this.lblDescripcion.setText("Con la mano cerrada, el dedo índice estirado y la palma al frente, se dibuja una letra z en el aire.");
                break;
            case 26:                /*SE ACTUALIZA EL STATUS DEL PROGRESO A 2*/
                CreateUsuario source = new CreateUsuario(LeccionDosActivity.this);
                source.openDataBase();
                Cursor c = source.traer();
                int colum4=c.getColumnIndex("progreso");
                c.moveToFirst();
                int progresoDB = Integer.parseInt(c.getString(colum4));
                Log.wtf("ProgresoDb",""+progresoDB);

                if (progresoDB == 3){
                    Usuario usuario = new Usuario();
                    usuario.setProgreso(4);
                    source.updateProgreso(usuario, 1);
                }
                source.close();
                /*SE TERMINA LA ACTUALIZACION*/

                Intent intent = new Intent(LeccionDosActivity.this, MainMenuActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
                break;

        }
    }
}
