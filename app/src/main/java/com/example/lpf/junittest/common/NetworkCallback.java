package com.example.lpf.junittest.common;

/**
 * Created by lpf on 2017/6/20.
 */

public interface NetworkCallback {
    void onSuccess(Object data);
    void onFailure(int code, String msg);
}
