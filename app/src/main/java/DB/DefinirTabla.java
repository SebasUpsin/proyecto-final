package DB;

import android.provider.BaseColumns;

public class DefinirTabla {


    public DefinirTabla(){}
    public static abstract class Usuario implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_PUNTUACIONMODULOUNO = "puntuacionmodulouno";
        public static final String COLUMN_NAME_PUNTUACIONMODULODOS = "puntuacionmodulouno";
        public static final String COLUMN_NAME_PUNTUACIONMODULOTRES = "puntuacionmodulouno";
    }


}