package miempresa.com.bo.menuprincipal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends Activity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actualizarTexto(View view) {

        text = (TextView) findViewById(R.id.BotonPresionado);

        if (view.getId() == R.id.buttonServicios){
            this.text.setText(R.string.OpcionServicios);
        } if (view.getId() == R.id.buttonPortafolio){
            this.text.setText(R.string.OpcionPortafolio);
        } if (view.getId() == R.id.buttonAcerca){
            this.text.setText(R.string.OpcionAcerca);
        } if (view.getId() == R.id.buttonContacto){
            this.text.setText(R.string.OpcionContacto);
        } if (view.getId() == R.id.buttonRedes){
            this.text.setText(R.string.OpcionRedes);
        }
    }
}
