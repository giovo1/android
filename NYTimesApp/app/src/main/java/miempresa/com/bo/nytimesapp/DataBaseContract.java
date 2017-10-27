package miempresa.com.bo.nytimesapp;

import android.provider.BaseColumns;


public final class DataBaseContract {
    private DataBaseContract() {} // make non-creatable

    public static final class SearchQueryEntry implements BaseColumns {
        public static final String TABLE_NAME = "search_query";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_QUERY = "query";
        //CREATE TABLE
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE "+ TABLE_NAME + " ("+
                        COLUMN_ID + " INTEGER PRIMARY KEY, "+
                        COLUMN_QUERY + " TEXT NOT NULL)";
    }
}
