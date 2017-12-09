package miempresa.com.bo.test2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    private View layoutPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.layoutPrincipal = (LinearLayout) findViewById(R.id.layoutPrincipal);
    }

    public void changeBlue(View view) {
        this.layoutPrincipal.setBackgroundColor(Color.RED);
    }
}
