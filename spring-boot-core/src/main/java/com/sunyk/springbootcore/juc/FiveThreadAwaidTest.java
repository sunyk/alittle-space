/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.juc;

/**
 * @author sunyang
 * @date 2018/11/16 20:25
 */
public class FiveThreadAwaidTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo count = new CountDownLatchDemo();
        count.countDownDemo();
        System.out.println("执行结束-------------");
    }
}

