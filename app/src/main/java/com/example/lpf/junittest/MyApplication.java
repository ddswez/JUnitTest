package com.example.lpf.junittest;

import android.app.Application;

import com.example.lpf.junittest.dagger2.AppComponent;
import com.example.lpf.junittest.dagger2.AppModule;
import com.example.lpf.junittest.dagger2.ComponentHolder;
import com.example.lpf.junittest.dagger2.DaggerAppComponent;

/**
 * Created by lpf on 2017/6/20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
