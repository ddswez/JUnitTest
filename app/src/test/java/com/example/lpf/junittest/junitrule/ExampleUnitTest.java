package com.example.lpf.junittest.junitrule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lpf on 2017/6/20.
 */

public class ExampleUnitTest {
    @Rule
    public MethodNameExample methodNameExample = new MethodNameExample();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mulitiplication_isCorrect() throws Exception {
        assertEquals(4, 2 * 2);
    }
}
