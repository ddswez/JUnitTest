package com.example.lpf.junittest.daggermock;

import android.widget.EditText;

import com.example.lpf.junittest.BuildConfig;
import com.example.lpf.junittest.R;
import com.example.lpf.junittest.dagger2.LoginActivity;
import com.example.lpf.junittest.dagger2.LoginPresenter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;

/**
 * Created by lpf on 2017/6/20.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    @Rule
    public DaggerRule daggerRule = new DaggerRule();

    @Mock
    LoginPresenter loginPresenter;

    @Test
    public void testLogin_shinny_way() {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("xiaochuang is handsome");
        loginActivity.findViewById(R.id.login).performClick();

        verify(loginPresenter).login("xiaochuang", "xiaochuang is handsome");
    }
}
