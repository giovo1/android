package miempresa.com.bo.actionbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private View layoutPrincipal;
    private Button btnWhite;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mToolBar = (Toolbar) findViewById(R.id.toolbar);

        if (this.mToolBar != null) {
            setSupportActionBar(this.mToolBar);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.layoutPrincipal = (LinearLayout) findViewById(R.id.layoutPrincipal);
        this.btnWhite = (Button) findViewById(R.id.btnWhite);

        this.btnWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutPrincipal.setBackgroundColor(Color.WHITE);
            }
        });

    }

    public void changeBlue(View view) {
        this.layoutPrincipal.setBackgroundColor(Color.RED);
    }

}
