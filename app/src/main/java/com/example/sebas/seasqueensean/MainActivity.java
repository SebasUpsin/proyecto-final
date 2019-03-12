package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    private String edad;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.nombre = sharedPreferences.getString("nombre","");
        this.edad = sharedPreferences.getString("edad","");
        this.btnMenu = (Button) findViewById(R.id.btnMenu);
        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuPrincipalActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
            }
        });

        if(this.nombre.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(MainActivity.this, MenuPrincipalActivity.class);
            intent.putExtra("nombre",this.nombre);
            intent.putExtra("edad",this.edad);
            startActivity(intent);
        }
    }
}
