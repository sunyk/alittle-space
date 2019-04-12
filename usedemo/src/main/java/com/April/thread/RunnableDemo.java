/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April.thread;

import java.util.logging.SocketHandler;

/**
 * @author sunyang
 * @date 2019/4/8 16:22
 */
public class RunnableDemo {

    public static void main(String[] args) {
        System.out.println("主线程序：" + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread =  new Thread(myRunnable);
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{

        public MyRunnable(){
        }

        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getName());
        }
    }
}

