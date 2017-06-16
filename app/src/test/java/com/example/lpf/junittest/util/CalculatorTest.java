package com.example.lpf.junittest.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by lpf on 17/6/1.
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }
    @Test
    public void add() throws Exception {
        int sum = mCalculator.add(1, 2);
        Assert.assertEquals(3, sum);
    }

    @Test
    @Ignore
    public void multiply() throws Exception {
        int product = mCalculator.multiply(3, 2);
        Assert.assertEquals(3, product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divide() {
        System.out.println("method divide()");
        mCalculator.divide(4, 0);
    }
    /**
     *
     *  @Test : 测试
     *  @Before : 在每个测试方法执行之前调用
     *  @After : 在每个测试方法执行结束后调用
     *  @BeforeClass : 在跑一个测试类的所有方法之前调用
     *  @BeforeClass : 执行完所有测试方法之后执行
     *  @Ignore : 忽略这个测试方法
     *
     */
}