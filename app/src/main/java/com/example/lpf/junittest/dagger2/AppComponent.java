package com.example.lpf.junittest.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lpf on 2017/6/20.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginPresenter loginPresenter();

    void inject(LoginActivity loginActivity);
}
