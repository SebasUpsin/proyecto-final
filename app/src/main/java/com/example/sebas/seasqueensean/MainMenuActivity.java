package com.example.sebas.seasqueensean;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import DB.CreateUsuario;
import DB.DefinirTabla;

public class MainMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String nombre;
    private String edad;
    private ImageButton btnActividad1;
    private ImageButton btnActividad2;
    private ImageButton btnActividad3;
    private ImageButton btnExamen1;
    private ImageButton btnExamen2;
    private ImageButton btnExamen3;
    private ImageButton btnLeccion1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        this.nombre = sharedPreferences.getString("nombre","");
        this.edad = sharedPreferences.getString("edad","");
        /* CREACION DE CONSTRUCTOR DE LA CLASE QUE VA A TRAER LOS METODOS DE LA BD*/
        CreateUsuario source = new CreateUsuario(MainMenuActivity.this);

        /* SE ABRE LA CONEXION DE LA BD*/
        source.openDataBase();

        /*EL CURSOR VA A TOMAR LO QUE REGRESA LA CONSULTA TRAER Y ASIGANARA LOS INDICES DE
        * LAS COLUMNAS A LAS VARIABLES COLUM*/
        Cursor c = source.traer();
        int colum0=c.getColumnIndex("_id");
        int colum1=c.getColumnIndex("nombre");
        int colum2=c.getColumnIndex("edad");
        int colum3=c.getColumnIndex("genero");
        int colum4=c.getColumnIndex("progreso");
        int colum5=c.getColumnIndex("puntuacionactividaduno");
        int colum6=c.getColumnIndex("puntuacionactividaddos");
        int colum7=c.getColumnIndex("puntuacionactividadtres");
        int colum8=c.getColumnIndex("puntuacionmodulouno");
        int colum9=c.getColumnIndex("puntuacionmodulodos");
        int colum10=c.getColumnIndex("puntuacionmodulotres");


        /*CON ESTO NOS POSICIONAMOS ANTES DE LA PRIMERA FILA PARA EMPEZAR A TRAER LOS DATOS*/
        c.moveToFirst();

        /*ASIGNO EL CONTENIDO DE LO QUE TIENE EL CURSOR A UNA VARIABLE DEL TIPO NECESARIO Y LE DOY
        * LA COLUMNA QUE QUIERO QUE ME TRAIGA EL DATO*/
        int idDB = Integer.parseInt(c.getString(colum0));
        String nombreDB = c.getString(colum1);
        int edadDB = Integer.parseInt(c.getString(colum2));
        String generoDB = c.getString(colum3);
        int progresoDB = Integer.parseInt(c.getString(colum4));
        int puntuacionActividadUnoDB = Integer.parseInt(c.getString(colum5));
        int puntuacionActividadDosDB = Integer.parseInt(c.getString(colum6));
        int puntuacionActividadTresDB = Integer.parseInt(c.getString(colum7));
        int puntuacionModuloUnoDB = Integer.parseInt(c.getString(colum8));
        int puntuacionModuloDosDB = Integer.parseInt(c.getString(colum9));
        int puntuacionModuloTresDB = Integer.parseInt(c.getString(colum10));


        /*CHECAMOS QUE SE HAYAN ASIGNADO NUESTROS DATOS*/
        Log.wtf("IdDB",""+idDB);
        Log.wtf("NombreDb",nombreDB);
        Log.wtf("EdadDb",""+edadDB);
        Log.wtf("GeneroDb",generoDB);
        Log.wtf("ProgresoDb",""+progresoDB);
        Log.wtf("ACT1Db",""+puntuacionActividadUnoDB);
        Log.wtf("ACT2Db",""+puntuacionActividadDosDB);
        Log.wtf("ACT3Db",""+puntuacionActividadTresDB);
        Log.wtf("EXAMEN1Db",""+puntuacionModuloUnoDB);
        Log.wtf("EXAMEN2Db",""+puntuacionModuloDosDB);
        Log.wtf("EXAMEN3Db",""+puntuacionModuloTresDB);



        Bundle datos = getIntent().getExtras();
//        this.nombre = datos.getString("nombre");
       // this.edad = datos.getString("edad");

        this.btnLeccion1=(ImageButton) findViewById(R.id.btnLeccion1);
        this.btnActividad1= (ImageButton) findViewById(R.id.btnActividad1);
        this.btnActividad2= (ImageButton) findViewById(R.id.btnActividad2);
        this.btnActividad3= (ImageButton) findViewById(R.id.btnActividad3);
        this.btnExamen1 = (ImageButton) findViewById(R.id.btnExamen1);
        this.btnExamen2 = (ImageButton) findViewById(R.id.btnExamen2);
        this.btnExamen3 = (ImageButton) findViewById(R.id.btnExamen3);




        this.btnLeccion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,LeccionUnoActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
            }
        });


        this.btnActividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,InstruccionesModuloUno.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                intent.putExtra("numero",2);
                startActivity(intent);
                finish();
            }
        });
        this.btnActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,InstruccionesModuloUno.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                intent.putExtra("numero",5);
                startActivity(intent);
                finish();
            }
        });

        this.btnActividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,InstruccionesModuloUno.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                intent.putExtra("numero",8);
                startActivity(intent);
                finish();
            }
        });

        this.btnExamen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,ExamenPrimerModulo.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
            }
        });

        this.btnExamen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,ExamenSegundoModulo.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
            }
        });

        this.btnExamen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,ExamenTercerModulo.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("edad",edad);
                startActivity(intent);
                finish();
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view = navigationView.getHeaderView(0);
        TextView navNombre = (TextView) view.findViewById(R.id.nombreMenu);
        ImageView navImage = (ImageView)view.findViewById(R.id.imageView);
        navNombre.setText(nombreDB);

        if (generoDB.equals("Femenino")){
            navImage.setImageResource(R.drawable.user_nav_girl);
        }else{
            navImage.setImageResource(R.drawable.user_nav);
        }

        /*CERRAMOS LA CONEXION CON LA BASE DE DATOS*/
        source.close();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_progreso) {
            // Handle the camera action
            Intent intent = new Intent(MainMenuActivity.this,ProgresoActivity.class);
            intent.putExtra("nombre",this.nombre);
            intent.putExtra("edad",this.edad);
            startActivity(intent);
        } else if (id == R.id.nav_puntuacion) {
            Intent intent = new Intent(MainMenuActivity.this,Puntuaciones.class);
            startActivity(intent);
        } else if (id == R.id.nav_salir) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
