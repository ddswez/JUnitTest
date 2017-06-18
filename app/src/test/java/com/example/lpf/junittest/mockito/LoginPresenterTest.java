package com.example.lpf.junittest.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;

/**
 * Created by lpf on 17/6/16.
 */
public class LoginPresenterTest {
    @Test
    public void setUserManager() throws Exception {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);

        loginPresenter.login("lpf", "123456");

//        Mockito.verify(mockUserManager).performLogin("lpf", "123456");
//        Mockito.verify(mockUserManager, Mockito.times(1)).performLogin("lpf", "123456");
//        Mockito.verify(mockUserManager, atMost(1)).performLogin("lpf", "123456");
//        Mockito.verify(mockUserManager, atLeast(2)).performLogin("lpf", "123456");
//        Mockito.verify(mockUserManager, never()).performLogin("lpf", "123456");
        Mockito.verify(mockUserManager).performLogin(anyString(), anyString());
    }

}