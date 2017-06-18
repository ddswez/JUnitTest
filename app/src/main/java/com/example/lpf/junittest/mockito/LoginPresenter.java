package com.example.lpf.junittest.mockito;

/**
 * 测试无返回值方法
 * Created by lpf on 17/6/16.
 */

public class LoginPresenter {
    private UserManager mUserManager = new UserManager();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        mUserManager.performLogin(username, password);
    }

    /**
     * 测试用
     * @param userManager
     */
    public void setUserManager(UserManager userManager) {
        this.mUserManager = userManager;
    }
}
