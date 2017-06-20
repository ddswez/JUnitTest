package com.example.lpf.junittest.junitrule;


import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by lpf on 2017/6/20.
 */

public class MethodNameExample implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                base.evaluate();
                System.out.println("Class name: "+className);
                System.out.println("method name: "+methodName);
            }
        };
    }
}
