package miempresa.com.bo.login;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    public static final int SIZE_BUCLE_CONEXION = 2;

    private ILoginPresenter loginPresenter;
    private TextView textEmail;
    private TextView textPass;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = (TextView) findViewById(R.id.editEmail);
        textPass = (TextView) findViewById(R.id.editPassword);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        this.loginPresenter = new LoginPresenter(getApplicationContext(), this);


    }

    public void enviarDatos(View view) {

        this.loginPresenter.validarCampos(this.textEmail.getText().toString(), this.textPass.getText().toString());

/*        if (!isConexion(getApplicationContext())){
            Toast.makeText(getBaseContext(), "No tiene conexion a Internet", Toast.LENGTH_LONG).show();
        } else {

            TextView textEmail = (TextView) findViewById(R.id.editEmail);
            TextView textPass = (TextView) findViewById(R.id.editPassword);
            CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
            int cont = 0;

            if (textEmail.getText() == null || textEmail.length() == 0) {
                Toast.makeText(getBaseContext(), "Ingrese el Email", Toast.LENGTH_LONG).show();
            } else if (textPass.getText() == null || textPass.length() == 0) {
                Toast.makeText(getBaseContext(), "Ingrese el Password", Toast.LENGTH_LONG).show();
            } else if (!checkBox.isChecked()) {
                Toast.makeText(getBaseContext(), "Acepte el ingreso", Toast.LENGTH_LONG).show();
            } else {
                cont = 1;
            }


            if (cont == 1) {

                Intent i = new Intent(this, SecondActivity.class);
                startActivity(i);*/


    /*            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i(TAG, "Ingreso a refresh");
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });*/


//            }
//        }

    }


    public boolean isConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < SIZE_BUCLE_CONEXION; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    @Override
    public void setErrorEmail(String mensaje) {
        textEmail.setError(mensaje);
    }

    @Override
    public void setErrorPassword(String mensaje) {
        textPass.setError(mensaje);
    }

    @Override
    public void setErrorConexion() {

    }

}
