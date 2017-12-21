package org.michaelbel.seriespicker;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import io.realm.Realm;
import io.realm.RealmConfiguration;

@SuppressWarnings("all")
public class AppLoader extends Application {

    private RxBus rxBus;
    private RealmConfiguration realmConfig;
    public static volatile Context AppContext;
    public static volatile Handler AppHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        AppContext = getApplicationContext();
        AppHandler = new Handler(getApplicationContext().getMainLooper());

        rxBus = new RxBus();

        Realm.init(this);
        realmConfig = new RealmConfiguration.Builder()
                .name("spRealmDBv2.realm")
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public RxBus bus() {
        return rxBus;
    }

    public Realm realm() {
        return Realm.getDefaultInstance();
    }
}