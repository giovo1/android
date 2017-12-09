package miempresa.com.bo.sqlite;

import android.provider.BaseColumns;


public final class DataBaseContract {
    private DataBaseContract() {} // make non-creatable

    public static final class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_USER_ID = "id";
        public static final String COLUMN_USER_NAME = "nombre";
        //CREATE TABLE
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE "+ TABLE_NAME + " ("+
                        COLUMN_USER_ID + " INTEGER PRIMARY KEY, "+
                        COLUMN_USER_NAME + " TEXT NOT NULL)";
    }
}
