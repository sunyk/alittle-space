/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.assertdemo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sunyang
 * @date 2018/10/18 10:32
 */
public class AssertTry {

    @Test
    public static void main(String[] args) {
        System.out.println();Assert.assertEquals("对比结果",new Integer(1), new Integer(1));
    }
}

