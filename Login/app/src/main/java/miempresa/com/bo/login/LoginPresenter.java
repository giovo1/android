package miempresa.com.bo.login;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by HP on 12/10/2017.
 */

public class LoginPresenter implements ILoginPresenter{

    private ILoginView iLoginView;
    private Context context;

    public LoginPresenter(Context context,ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.context = context;
    }


    @Override
    public void validarCampos(String email, String password) {
        if (email.isEmpty() || email.length() == 0) {
            this.iLoginView.setErrorEmail("Ingrese el email");
        }else if (password.isEmpty() ){
            this.iLoginView.setErrorPassword("Ingrese el password");
        }
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ILoginView getiLoginView() {
        return iLoginView;
    }

    public void setiLoginView(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }


}
