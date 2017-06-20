package com.example.lpf.junittest.junitrule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by lpf on 2017/6/20.
 */

public class ContextRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        ContextHolder.set(RuntimeEnvironment.application);
        return base;
    }
}
