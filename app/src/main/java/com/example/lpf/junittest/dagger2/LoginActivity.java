package com.example.lpf.junittest.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.lpf.junittest.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 方法一
//        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
//        mLoginPresenter = appComponent.loginPresenter();

        // 方法二
//        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
//        appComponent.inject(this);

        ComponentHolder.getAppComponent().inject(this);


        findViewById(R.id.login).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();

                mLoginPresenter.login(username, password);
            }
        });
    }
}
