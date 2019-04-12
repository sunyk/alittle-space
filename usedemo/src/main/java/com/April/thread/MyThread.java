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
 * @date 2019/4/8 15:58
 */
public class MyThread extends Thread {
    private static volatile  int num = 0;

    public synchronized void myThread(){
        ++num;
    }

    @Override
    public void run() {
        myThread();
        System.out.println("线程名称:"+ Thread.currentThread().getName() +"主动创建的第"+ num + "个线程");
    }
}

