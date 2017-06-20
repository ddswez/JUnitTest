package com.example.lpf.junittest.mockitoannotations;

import com.example.lpf.junittest.dagger2.UserManager;
import com.example.lpf.junittest.mockito.PasswordValidator;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

/**
 * Created by lpf on 2017/6/20.
 */

public class LoginPresenterTest {

    // 1
    /*@Test
    public void testLogin() {
        UserManager mockUserManager = mock(UserManager.class);
        PasswordValidator mockValidator = mock(PasswordValidator.class);
        Mockito.when(mockValidator.verifyPassword("xiaochuang is handsome")).thenReturn(true);

        LoginPresenter presenter = new LoginPresenter(mockUserManager, mockValidator);

        presenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    } */



    //2
    /*UserManager mockUserManager;
    PasswordValidator mockValidator;
    LoginPresenter loginPresenter;

    @Before
    public void setup() {
        mockUserManager = mock(UserManager.class);
        mockValidator = mock(PasswordValidator.class);
        loginPresenter = new LoginPresenter(mockUserManager, mockValidator);
    }

    @Test
    public void testLogin() {
        Mockito.when(mockValidator.verifyPassword("xiaochuang is handsome")).thenReturn(true);
        loginPresenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    }  */


    // 3
  /*  @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UserManager mockUserManager;

    @Mock
    PasswordValidator mockValidator;

    LoginPresenter loginPresenter;

    @Before
    public void setup() {
        loginPresenter = new LoginPresenter(mockUserManager, mockValidator);
    }

    @Test
    public void testLogin() {
        Mockito.when(mockValidator.verifyPassword("xiaochuang is handsome")).thenReturn(true);
        loginPresenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    }  */


    //4
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UserManager mockUserManager;
    @Mock
    PasswordValidator mockValidator;

    @InjectMocks
    LoginPresenter loginPresenter;

    @Test
    public void testLogin() {
        Mockito.when(mockValidator.verifyPassword("xiaochuang is handsome")).thenReturn(true);
        loginPresenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    }

}
