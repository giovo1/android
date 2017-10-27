package miempresa.com.bo.nytimesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "News.db";
    public static final int DATABASE_VERSION = 1;

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseContract.SearchQueryEntry.SQL_CREATE_TABLE);
        //COLOCAR LA CREACION DE OTRAS TABLAS
    }

    public void addSearchQuery(String query) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseContract.SearchQueryEntry.COLUMN_QUERY, query);
        db.insert(DataBaseContract.SearchQueryEntry.TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DataBaseContract.SearchQueryEntry.TABLE_NAME);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public ArrayList<String> getSearchQueries(){
        ArrayList<String> result = new ArrayList<>();
        //Select all query
        String selectQuery = "SELECT * FROM "+ DataBaseContract.SearchQueryEntry.TABLE_NAME +" ORDER BY "+ DataBaseContract.SearchQueryEntry.COLUMN_ID+" DESC LIMIT 5" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                // Adding contact to list
                result.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // return contact list
        return result;

    }
}

