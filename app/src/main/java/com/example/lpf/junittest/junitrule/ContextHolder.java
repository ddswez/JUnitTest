package com.example.lpf.junittest.junitrule;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

/**
 * Created by lpf on 2017/6/20.
 */

public class ContextHolder {

    private static Context sContext;

    @VisibleForTesting
    public static void set(Context context) {
        sContext = context;
    }

    public static Context get() {
        return sContext;
    }
}
