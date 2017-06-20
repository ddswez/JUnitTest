package com.example.lpf.junittest.mockito;

import com.example.lpf.junittest.common.NetworkCallback;

/**
 * 测试无返回值方法
 * Created by lpf on 17/6/16.
 */

public class LoginPresenter {
    private UserManager mUserManager = new UserManager();
    private PasswordValidator mPasswordValidator = new PasswordValidator();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        mUserManager.performLogin(username, password);
    }

    public void login2(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        if (mPasswordValidator.verifyPassword(password)) return;

        mUserManager.performLogin(username, password);
    }

    public void loginCallback(String username, String password) {
        if (username == null || username.length() == 0) return;
        //假设我们对密码强度有一定要求，使用一个专门的validator来验证密码的有效性
        if (mPasswordValidator.verifyPassword(password)) return;

        mUserManager.performLogin(username, password, new NetworkCallback() {
            @Override
            public void onSuccess(Object data) {
                //update view with data

            }

            @Override
            public void onFailure(int code, String msg) {
                //show error msg
                if (code == 500) throw new RuntimeException();
            }
        });
    }


    /**
     * 测试用
     * @param userManager
     */
    public void setUserManager(UserManager userManager) {
        this.mUserManager = userManager;
    }
    public void setPasswordValidator(PasswordValidator passwordValidator) {
        this.mPasswordValidator = passwordValidator;
    }
}
