package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CreateUsuario {


    Context context;
    DBHelper dbHelper;
    SQLiteDatabase db;

    String[] columnsToRead = new String[]{
      DefinirTabla.Usuario._ID,
      DefinirTabla.Usuario.COLUMN_NAME_NOMBRE,
      DefinirTabla.Usuario.COLUMN_NAME_GENERO,
      DefinirTabla.Usuario.COLUMN_NAME_EDAD,
      DefinirTabla.Usuario.COLUMN_NAME_PROGRESO,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_UNO,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_DOS,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_TRES,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS,
      DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES,
    };

    public CreateUsuario(Context context){
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    public void openDataBase(){
        db = dbHelper.getWritableDatabase();
    }

    public long insertarUsuario(Usuario c){
        ContentValues values = new ContentValues();
        values.put(DefinirTabla.Usuario.COLUMN_NAME_NOMBRE, c.getNombre());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_GENERO,c.getGenero());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_EDAD,c.getEdad());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PROGRESO,c.getProgreso());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_UNO,c.getPuntuacionActividadUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_DOS,c.getPuntuacionActividadDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_TRES,c.getPuntuacionActividadTres());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO, c.getPuntuacionModuloUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS, c.getPuntuacionModuloDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES, c.getPuntuacionModuloTres());
        return db.insert(DefinirTabla.Usuario.TABLE_NAME,null,values);
    }

    public long updateUsuario(Usuario c,int id){
        ContentValues values = new ContentValues();
        values.put(DefinirTabla.Usuario.COLUMN_NAME_NOMBRE, c.getNombre());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_GENERO,c.getGenero());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_EDAD,c.getEdad());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PROGRESO,c.getProgreso());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_UNO,c.getPuntuacionActividadUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_DOS,c.getPuntuacionActividadDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_TRES,c.getPuntuacionActividadTres());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO, c.getPuntuacionModuloUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS, c.getPuntuacionModuloDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES, c.getPuntuacionModuloTres());
        return db.update(DefinirTabla.Usuario.TABLE_NAME, values, DefinirTabla.Usuario._ID + " = " + id, null);
    }

    public int deleteUsuario(long id){
        return db.delete(DefinirTabla.Usuario.TABLE_NAME, DefinirTabla.Usuario._ID + "=?",
                new String[]{String.valueOf(id)});
    }

    private Usuario readUsuario(Cursor cursor){
        Usuario c = new Usuario();
        c.setID(cursor.getInt(0));
        c.setNombre(cursor.getString(1));
        c.setGenero(cursor.getString(2));
        c.setEdad(cursor.getInt(3));
        c.setProgreso(cursor.getInt(4));
        c.setPuntuacionActividadUno(cursor.getInt(5));
        c.setPuntuacionActividadDos(cursor.getInt(6));
        c.setPuntuacionActividadTres(cursor.getInt(7));
        c.setPuntuacionModuloUno(cursor.getInt(8));
        c.setPuntuacionModuloDos(cursor.getInt(9));
        c.setPuntuacionModuloTres(cursor.getInt(10));
        return c;
    }

    public ArrayList<Usuario> allContactos(){
        Cursor cursor = db.query(DefinirTabla.Usuario.TABLE_NAME,
                columnsToRead, null, null, null, null, null);
        ArrayList<Usuario> contactos = new ArrayList<Usuario>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Usuario c = readUsuario(cursor);
            contactos.add(c);
            cursor.moveToNext();
        }
        cursor.close();
        return contactos;
    }

    public Cursor traer (){
        return db.rawQuery("SELECT * FROM "+DefinirTabla.Usuario.TABLE_NAME,null);
    }

    public void close(){
        dbHelper.close();
    }





}
