package miempresa.com.bo.testcardview;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
        session.saveUser("NombreUsuario");
        System.out.println(session.getUserName());

    }
}
