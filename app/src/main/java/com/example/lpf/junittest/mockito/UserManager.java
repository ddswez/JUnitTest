package com.example.lpf.junittest.mockito;


import com.example.lpf.junittest.common.NetworkCallback;

public class UserManager {

    public void performLogin(String name, String pwd) {

    }

    public void performLogin(String username, String password, NetworkCallback networkCallback) {
        //perform login and notify networkCallback
    }
}
