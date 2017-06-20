package com.example.lpf.junittest.mockito;

import com.example.lpf.junittest.common.NetworkCallback;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by lpf on 17/6/16.
 */
public class LoginPresenterTest {
    @Test
    public void loginTest() throws Exception {
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

    @Test
    public void login2Test() throws Exception {
        PasswordValidator validator = Mockito.mock(PasswordValidator.class);
        when(validator.verifyPassword(anyString())).thenReturn(false);
//        Assert.assertEquals(true, validator.verifyPassword("hehehe"));

        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);
        loginPresenter.setPasswordValidator(validator);

        loginPresenter.login2("lpf", "123456");

        Mockito.verify(mockUserManager).performLogin(anyString(), anyString());
    }


    /**
     * 指定一个方法执行特定的动作
     */
    @Test
    public void loginCallbackTest() throws Exception {
//        UserManager mockUserManager = Mockito.mock(UserManager.class);
//        Mockito.doThrow(new RuntimeException()).when(mockUserManager).performLogin(anyString(), anyString(), any(NetworkCallback
//                .class));
//
//        mockUserManager.performLogin("lpf", "123456", Mockito.mock(NetworkCallback.class));
//
//        LoginPresenter loginPresenter = new LoginPresenter();
//        loginPresenter.setUserManager(mockUserManager);


    final UserManager mockUserManager = Mockito.mock(UserManager.class);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();

                System.out.println((String)arguments[0]);
                System.out.println((String)arguments[1]);

                NetworkCallback callback = (NetworkCallback) arguments[2];
                callback.onFailure(500, "Server error");
                return null;
            }
        }).when(mockUserManager).performLogin(anyString(), anyString(), any(NetworkCallback.class));

//       mockUserManager.performLogin("lpf", "123456", Mockito.mock(NetworkCallback.class));

        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);
        loginPresenter.loginCallback("lpf", "123456");
    }

    @Test
    public void testSpy() {
        PasswordValidator spyValidator = Mockito.spy(PasswordValidator.class);
        PasswordValidator mockValidator = Mockito.mock(PasswordValidator.class);

        //在默认情况下，spy对象会调用这个类的real implementation，并返回相应的返回值
//        boolean spyResult = spyValidator.verifyPassword("heihei");
//        boolean mockResult = mockValidator.verifyPassword("heihei");
//        Assert.assertTrue(spyResult);
//        Assert.assertTrue(mockResult);

        // 也可以指定对象的方法的返回
        Mockito.when(spyValidator.verifyPassword(anyString())).thenReturn(true);
        boolean result = spyValidator.verifyPassword("123456");
        Assert.assertTrue(result);
        Mockito.verify(spyValidator, Mockito.times(1)).verifyPassword("123456");
    }


}
