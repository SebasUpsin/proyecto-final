package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CreateUsuario {


    Context context;
    DBHelper dbHelper;
    SQLiteDatabase db;

    String[] columnsToRead = new String[]{
      DefinirTabla.Usuario._ID,
      DefinirTabla.Usuario.COLUMN_NAME_NOMBRE,
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
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO, c.getPuntuacionModuloUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS, c.getPuntuacionModuloDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES, c.getPuntuacionModuloTres());
        return db.insert(DefinirTabla.Usuario.TABLE_NAME,null,values);
    }

    public long updateUsuario(Usuario c,int id){
        ContentValues values = new ContentValues();
        values.put(DefinirTabla.Usuario.COLUMN_NAME_NOMBRE, c.getNombre());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO, c.getPuntuacionModuloUno());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS, c.getPuntuacionModuloDos());
        values.put(DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES, c.getPuntuacionModuloTres());
        return db.update(DefinirTabla.Usuario.TABLE_NAME, values, DefinirTabla.Usuario._ID + " = " + id, null);
    }

    public int deleteUsuario(long id){
        return db.delete(DefinirTabla.Usuario.TABLE_NAME, DefinirTabla.Usuario._ID + "=?",
                new String[]{String.valueOf(id)});
    }





}
