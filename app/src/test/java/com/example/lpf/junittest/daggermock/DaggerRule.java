package com.example.lpf.junittest.daggermock;

import com.example.lpf.junittest.dagger2.AppComponent;
import com.example.lpf.junittest.dagger2.AppModule;
import com.example.lpf.junittest.dagger2.ComponentHolder;

import org.robolectric.RuntimeEnvironment;

import it.cosenonjaviste.daggermock.DaggerMockRule;

/**
 * Created by lpf on 2017/6/20.
 */

public class DaggerRule extends DaggerMockRule<AppComponent> {

    public DaggerRule() {
        super(AppComponent.class, new AppModule(RuntimeEnvironment.application));
        set(new ComponentSetter<AppComponent>() {
            @Override
            public void setComponent(AppComponent appComponent) {
                ComponentHolder.setAppComponent(appComponent);
            }
        });
    }
}
