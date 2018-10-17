/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.arithmetic;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author sunyang
 * @date 2018/10/9 16:39
 */
public class ArithmeticDemo2 {

    private static Integer num = new Integer(1);

    private final static Vector<Integer> lists = new Vector<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 1000000; i++) {
            num = i % 20;
            if (num == 1){
                lists.add(i);
            }
        }
        System.out.println("在第一台服务器执行取到用户ID：" + lists.toString());

    }
}

