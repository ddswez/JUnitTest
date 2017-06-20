package com.example.lpf.junittest.dagger2;

import android.widget.EditText;

import com.example.lpf.junittest.BuildConfig;
import com.example.lpf.junittest.R;
import com.example.lpf.junittest.mockito.PasswordValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lpf on 2017/6/20.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    @Test
    public void testActivityStart() {
//        AppModule mockAppModule = spy(new AppModule(RuntimeEnvironment.application));
//        LoginPresenter mockLoginPresenter = mock(LoginPresenter.class);
//
//        // 当mockAppModule的provideLoginPresenter()方法被调用时，让它返回mockLoginPresenter
//        Mockito.when(mockAppModule.provideLoginPresenter(any(UserManager.class), any(PasswordValidator.class)))
//               .thenReturn(mockLoginPresenter);
//
//        // 用mockAppModule来创建DaggerAppComponent
//        AppComponent appComponent = DaggerAppComponent.builder().appModule(mockAppModule).build();
//
//        // 放到ComponentHolder里面，这样LoginActivity#onCreate()里面通过ComponentHolder.getAppComponent()获得的就是这里创建的appComponent
//        ComponentHolder.setAppComponent(appComponent);
//
//        // 启动LoginActivity，onCreate方法会得到调用，里面的mLoginPresenter通过dagger2获得的，将是mockLoginPresenter
//        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
//
//        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
//        ((EditText) loginActivity.findViewById(R.id.password)).setText("heihei");
//        loginActivity.findViewById(R.id.login).performClick();
//
//        verify(mockLoginPresenter, Mockito.times(1)).login("xiaochuang", "heihei");  //pass!


        TestUtils.setupDagger();
        LoginPresenter mockLoginPresenter = mock(LoginPresenter.class);
        Mockito.when(TestUtils.appModule.provideLoginPresenter(any(UserManager.class),
                any(PasswordValidator.class))).thenReturn(mockLoginPresenter);

        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("heihei");
        loginActivity.findViewById(R.id.login).performClick();

        verify(mockLoginPresenter).login("xiaochuang", "heihei");

    }
}
