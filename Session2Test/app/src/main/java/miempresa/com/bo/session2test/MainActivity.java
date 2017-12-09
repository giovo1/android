package miempresa.com.bo.session2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        session.saveUser("NombreUsuario");
        System.out.println(session.getUserName());
        session.guardarUsuario(new Usuario("Roberto Carlos", "Callisaya Mamani", 31));
        System.out.println(session.devolverUsuario().getApellidos());


    }
}
