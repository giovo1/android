package miempresa.com.bo.nytimesapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SessionManager {

    //Shared Preferences
    private SharedPreferences pref;
    //Editor for Shared Preferences
    private SharedPreferences.Editor editor;
    //Sharedpref file name
    private static final String PREF_NAME = "NYTimesApp";
    //Context
    private Context _context;
    //Shared pref mode
    private int PRIVATE_MODE = 0;
    private String KEY_ITEM = "newsItem";

    // Constructor
    public SessionManager(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveNewsItem(NewsItem i) {
        Gson gson = new Gson();
        String user_json = gson.toJson(i);
        editor.putString(KEY_ITEM, user_json);
        editor.commit();
    }

    public NewsItem getNewsItem() {
        Gson gson = new Gson();
        NewsItem i = gson.fromJson(pref.getString(KEY_ITEM,null), NewsItem.class);
        return i;
    }
}

