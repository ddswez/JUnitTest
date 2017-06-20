package com.example.lpf.junittest.mockito;

/**
 * Created by lpf on 2017/6/20.
 */

public class PasswordValidator {

    public boolean verifyPassword(String password) {
        // 需要联网等操作

        return "heihei".equals(password);
    }
}
