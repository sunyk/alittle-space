/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

/**
 * @author sunyang
 * @date 2019/4/8 11:18
 */
public class IntegerWrapDemo {

    public static void main(String[] args) {
        Integer score = new Integer(1);
        score.intValue();
        System.out.println(score.intValue());
        int i = 10;
//        11 12 13
//        System.out.println(++i + ++i + ++i);
        //10 11 12
//        System.out.println(i++ + i++ + i++);
        //10 12 12
//        System.out.println(i++ + ++i + i++);
        //10 11 13
//        System.out.println(i++ + i++ + ++i);
        //11 12 12
//        System.out.println(++i + ++i + i++);
        //11 12 12 13
//        System.out.println(++i + ++i + i++ + i++);
        //11 12 12 14 14
        System.out.println(++i + ++i + i++ + ++i + i++);
    }
}

