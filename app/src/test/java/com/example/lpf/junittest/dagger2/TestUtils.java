package com.example.lpf.junittest.dagger2;

import org.robolectric.RuntimeEnvironment;

import static org.mockito.Mockito.spy;

/**
 * Created by lpf on 2017/6/20.
 */

public class TestUtils {

    public static final AppModule appModule = spy(new AppModule(RuntimeEnvironment.application));

    public static void setupDagger() {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
    }

}
