package miempresa.com.bo.testconexion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int SIZE_BUCLE_CONEXION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isConexion(getApplicationContext())){
            Toast.makeText(this, getString(R.string.conConexion),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, getString(R.string.sinConexion),Toast.LENGTH_LONG).show();
        }
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

    public void showConexion(View view) {
        if ( this.isConexion(view.getContext())) {
            Toast.makeText(view.getContext(), "Con conexion a internet", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(),"No se tiene conexion a internet", Toast.LENGTH_LONG).show();
        }
    }

}
