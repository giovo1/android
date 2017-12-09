package miempresa.com.bo.sessiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
    }

    public void loguearUsuario(View view) {
        TextView text = (TextView) findViewById(R.id.editText);
        session = new SessionManager(getApplicationContext());
        session.saveUser(text.getText().toString());

        Intent i = new Intent(this, WelcomeActivity.class);
        startActivity(i);
    }
}
