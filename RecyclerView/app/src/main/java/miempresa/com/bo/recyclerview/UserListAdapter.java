package miempresa.com.bo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    private ArrayList<Usuario> lista;

    public UserListAdapter(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new UserListAdapter.UserListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserListViewHolder holder, int position) {
        final Usuario usuario = lista.get(position);
        holder.txtNombre.setText(usuario.getNombre());
        holder.txtCorreo.setText(usuario.getCorreo());
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtCorreo;

        public UserListViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txt_nombre);
            txtCorreo =( TextView) itemView.findViewById(R.id.txt_correo);
        }
    }

}
