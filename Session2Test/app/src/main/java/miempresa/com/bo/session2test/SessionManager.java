package miempresa.com.bo.session2test;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SessionManager {

    //Shared Preferences
    private SharedPreferences pref;
    //Editor for Shared Preferences
    private SharedPreferences.Editor editor;
    //Sharedpref file name
    private static final String PREF_NAME = "Miapptest";
    //Context
    private Context _context;
    //Shared pref mode
    private int PRIVATE_MODE = 0;
    private String KEY_USER = "user";

    private String KEY_USUARIO = "usuario";


    // Constructor
    public SessionManager(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveUser(String username) {
        editor.putString(KEY_USER, username);
        editor.commit();
    }
    public String getUserName() {
        return pref.getString(KEY_USER, null);
    }

    public void guardarUsuario(Usuario u) {
        Gson gson = new Gson();
        String user_json = gson.toJson(u);
        editor.putString(KEY_USUARIO, user_json);
        editor.commit();
    }

    public Usuario devolverUsuario() {
        Gson gson = new Gson();
        Usuario u = gson.fromJson(pref.getString(KEY_USUARIO,null), Usuario.class);
        return u;
    }


}
