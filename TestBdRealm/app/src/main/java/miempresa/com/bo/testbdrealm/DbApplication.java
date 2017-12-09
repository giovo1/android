package miempresa.com.bo.testbdrealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DbApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("Mibasededatos.realm")
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
