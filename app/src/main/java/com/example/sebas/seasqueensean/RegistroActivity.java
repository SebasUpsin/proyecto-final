package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    ConstraintLayout layoutAnimado;
    AnimationDrawable animacion;
    private EditText txtNombre;
    private EditText txtEdad;
    private ImageButton btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.layoutAnimado = (ConstraintLayout) findViewById(R.id.layoutanimado);
        this.animacion = (AnimationDrawable) this.layoutAnimado.getBackground();
        this.animacion.setEnterFadeDuration(3000);
        this.animacion.setExitFadeDuration(3000);
        this.animacion.start();
        this.txtNombre = (EditText) findViewById(R.id.txtNombre);
        this.txtEdad = (EditText) findViewById(R.id.txtEdad);
        this.btnAceptar = (ImageButton) findViewById(R.id.btnAceptar);

        this.btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().isEmpty()||txtEdad.getText().toString().isEmpty())
                    return;
                SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre",txtNombre.getText().toString());
                editor.putString("edad",txtEdad.getText().toString());
                editor.commit();
                finish();
            }
        });

    }
}
