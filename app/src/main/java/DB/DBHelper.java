package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_USUARIO = "CREATE TABLE " +
            DefinirTabla.Usuario.TABLE_NAME + " (" +
            DefinirTabla.Usuario._ID + " INTEGER PRIMARY KEY, " +
            DefinirTabla.Usuario.COLUMN_NAME_NOMBRE + TEXT_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_GENERO + TEXT_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_EDAD + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PROGRESO + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_UNO + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_DOS + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACION_ACTIVIDAD_TRES + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOUNO + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULODOS + INTEGER_TYPE +
            COMMA_SEP +
            DefinirTabla.Usuario.COLUMN_NAME_PUNTUACIONMODULOTRES + INTEGER_TYPE +
            ")";

    private static final String SQL_DELETE_CONTACTO = "DROP TABLE IF EXISTS " +
            DefinirTabla.Usuario.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "senas.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion){
        db.execSQL(SQL_DELETE_CONTACTO);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int
            newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USUARIO);
    }


}
