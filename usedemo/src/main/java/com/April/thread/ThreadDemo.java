/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April.thread;

/**
 * @author sunyang
 * @date 2019/4/8 15:56
 */
public class ThreadDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }
}

