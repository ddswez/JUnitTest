package com.example.lpf.junittest;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by lpf on 17/6/7.
 */
public class LoginPresenterTest {
    @Test
    public void setUserManager() throws Exception {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);
        loginPresenter.login("lpf", "123456");
        Mockito.verify(mockUserManager).performLogin("lpf", "123456");
    }

}