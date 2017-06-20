package com.example.lpf.junittest.dagger2;

/**
 * Created by lpf on 2017/6/20.
 */
public class ComponentHolder {
    private static AppComponent sAppComponent;

    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
