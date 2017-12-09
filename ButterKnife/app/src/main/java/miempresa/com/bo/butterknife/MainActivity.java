package miempresa.com.bo.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_saludo)
    TextView txtName;

    @BindView(R.id.btn_saludo)
    Button btnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_saludo)
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), getString(R.string.txt_welcome), Toast.LENGTH_LONG).show();
    }
}
