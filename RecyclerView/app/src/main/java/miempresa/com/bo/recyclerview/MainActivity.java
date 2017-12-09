package miempresa.com.bo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Jose", "jose@correo.com"));
        lista.add(new Usuario("Pepe", "pepe@correo.com"));
        lista.add(new Usuario("Efrain", "efrain@correo.com"));
        lista.add(new Usuario("Maria", "maria@correo.com"));

        UserListAdapter userListAdapter = new UserListAdapter(lista);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.recyclerView.setAdapter(userListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);

    }
}
