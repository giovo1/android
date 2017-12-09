package miempresa.com.bo.login;

import android.view.View;

/**
 * Created by HP on 12/10/2017.
 */

public interface ILoginView {
    void setErrorEmail(String mensaje);

    void setErrorPassword(String mensaje);

    void setErrorConexion();

    void enviarDatos(View view);
}
