package miempresa.com.bo.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private DataBaseOpenHelper mDBOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBOpenHelper = new DataBaseOpenHelper(this);
        mDBOpenHelper.addUser("Juancho");
        mDBOpenHelper.addUser("Perez");

        System.out.println("Listando datos de la base de datos");
        for (String name : mDBOpenHelper.getUsers()) {
            System.out.println(name);
        }
    }

    @Override
    protected void onDestroy() {
        mDBOpenHelper.close();
        super.onDestroy();
    }
}
