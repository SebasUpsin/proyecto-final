package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    private String edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(this, ""+nombre, Toast.LENGTH_SHORT).show();

        //this.edad = "";

        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.nombre = sharedPreferences.getString("nombre","");
        this.edad = sharedPreferences.getString("edad","");

        Log.wtf("Contenido de nombre",""+nombre);

        if(this.nombre.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
            intent.putExtra("nombre",this.nombre);
            intent.putExtra("edad",this.edad);
            startActivity(intent);
            finish();
        }
    }


}
