package com.example.lpf.junittest.mockitoannotations;

import com.example.lpf.junittest.dagger2.UserManager;
import com.example.lpf.junittest.mockito.PasswordValidator;

import javax.inject.Inject;

/**
 * Created by lpf on 2017/6/20.
 */

public class LoginPresenter {
    private final UserManager mUserManager;
    private final PasswordValidator mPasswordValidator;

    public LoginPresenter() {
        this(null, null);
    }

    @Inject
    public LoginPresenter(UserManager userManager, PasswordValidator passwordValidator) {
        this.mUserManager = userManager;
        this.mPasswordValidator = passwordValidator;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (!mPasswordValidator.verifyPassword(password)) return;

        mUserManager.performLogin(username, password);
    }
}
