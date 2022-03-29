/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March;

/**
 * @author sunyang
 * @date 2019/3/5 17:16
 */
public class SynchronizedDetail {

    public static synchronized void staticMethod() throws InterruptedException{
        System.out.println("静态同步方法开始");
        Thread.sleep(1000);
        System.out.println("静态同步方法结束");
    }

    public synchronized void method() throws InterruptedException{
        System.out.println("实例同步方法开始");
        Thread.sleep(1000);
        System.out.println("实例同步方法结束");
    }

    public synchronized void method2() throws InterruptedException{
        System.out.println("实例同步方法2开始");
        Thread.sleep(1000);
        System.out.println("实例同步方法2结束");
    }

    public static void main(String[] args) {
        final SynchronizedDetail synchronizedDetail = new SynchronizedDetail();
        Thread thread1 = new Thread(()-> {
            try {
                synchronizedDetail.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                synchronizedDetail.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }




}

