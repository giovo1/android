package miempresa.com.bo.colores;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private View layoutPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.layoutPrincipal = (LinearLayout) findViewById(R.id.layoutPrincipal);
    }

    public void changeBlue(View view) {
        this.layoutPrincipal.setBackgroundColor(Color.RED);
    }
}
