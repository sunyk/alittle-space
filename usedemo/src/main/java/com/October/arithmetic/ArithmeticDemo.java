/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sunyang
 * @date 2018/10/9 16:39
 */
public class ArithmeticDemo {

    private static Integer num = new Integer(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            num = i % 20;
            System.out.println("当前id: " + i +",是在第"+num+"台服务器执行：");
            /*if (num == 1){

            }*/
        }

    }
}

